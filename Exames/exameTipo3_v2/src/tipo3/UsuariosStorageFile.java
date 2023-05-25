package tipo3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public final class UsuariosStorageFile implements Storage {

    private String filename;//resultados.txt
    private String indexname;//resultados.idx
    private TreeMap<String, Long> index;//o índice que son os mesmos que no index 

    /**
     * Cando cargamos o índice o marquemos como "inválido" (neste caso o
     * borramos). Cando se pecha UsuariosStorageFile se debe gardar o índice de
     * novo.
     *
     * Si cando imos cargar un índice o índice é "inválido" (neste caso si non
     * existe), o "reindexamos".
     *
     * @param filename
     * @param indexname
     * @throws FileNotFoundException
     * @throws IOException
     */
    public UsuariosStorageFile(String filename, String indexname) throws Exception {
        this.index = new TreeMap<>();
        this.filename = filename;
        this.indexname = indexname;

        // Cargamos o index
        try ( DataInputStream is = new DataInputStream(new FileInputStream(indexname))) {
            while (true) {//lee os datos do treemap
                String dni = is.readUTF();
                Long pos = is.readLong();
                index.put(dni, pos);
            }
        } catch (FileNotFoundException e) {
            get();
        } catch (EOFException e) { //cando chega ao final, elimina o ficheiro de índice despois de cargar todo en memoria      
            new File(indexname).delete();   // Unha vez cargamos o índice o borramos. Se garda de novo ao peche
        }
    }

    /**
     * método que lee un usuario do ficheiro e o devolve
     *
     * @param ras
     * @return
     * @throws EOFException
     * @throws IOException
     */
    private Usuario readUser(RandomAccessFile ras) throws EOFException, IOException {
        String dni = ras.readUTF();//lemos o primeiro elemento, que será o dni
        if (dni == null) {
            throw new EOFException("chegou ao final do ficheiro");
        }

        if (dni.equals("*")) {
            return null;//se o dni é un "*" devolvemos null
        }
        String nome = ras.readUTF(); //lemos o nome
        int idade = Integer.parseInt(ras.readUTF());//lemos a idade
        return new Usuario(dni, nome, idade);
    }

    /**
     * Retorna todos os usuarios. Aproveitando que os ten que ler todos,
     * reindexa a BBDD
     *
     * @return - Usuario[]
     * @throws Exception
     */
    public Usuario[] get() throws Exception {
        ArrayList<Usuario> users = new ArrayList<>();

        try ( RandomAccessFile ras = new RandomAccessFile(filename, "rws");) {
            while (true) {//lee os datos do treemap
                if (readUser(ras) != null) {
                    users.add(readUser(ras));
                }
            }
        } catch (EOFException ex) {
        }
        return (Usuario[]) users.toArray();//return users.toArray(new Usuario[0]);
    }

    /**
     * método que a partir dun dni devolve un usuario
     *
     * @param dni
     * @return
     * @throws Exception
     */
    @Override
    public Usuario get(String dni) throws Exception {
        long posicion = index.get(dni);
        try ( RandomAccessFile ras = new RandomAccessFile(filename, "rws");) {
            ras.seek(posicion);//apuntamos á posición
            return readUser(ras); //devolve un usuario  
        }
    }

    /**
     * método que inserta un usuario no ficheiro
     *
     * @param user
     * @throws Exception
     */
    @Override
    public void insert(Usuario user) throws Exception {
        String dni = user.getDni();//collemos o dni do usuario
        if (index.get(dni) != null) {
            System.out.println("O usuario xa existe");
        }

        try ( RandomAccessFile ras = new RandomAccessFile(filename, "rws");) {
            long ultPosicion = ras.length();//danos a última posición
            ras.seek(ultPosicion); //posicionámonos na última posición
            ras.writeUTF(dni);//escribimos o dni
            ras.writeUTF(user.getNome());//escribimos o nome
            ras.writeUTF(String.valueOf(user.getIdade()));//escribimos a idade
            index.put(dni, ultPosicion);//actualizamos o index
        }
    }

    /**
     * método que actualiza un usuario
     *
     * @param user
     * @throws Exception
     */
    @Override
    public void update(Usuario user) throws Exception {
        String dni = user.getDni();//collemos o dni do usuario
        if (index.get(dni) != null) {
            System.out.println("O usuario atopouse");
        }

        try ( RandomAccessFile ras = new RandomAccessFile(filename, "rws");) {
            long posicion = index.get(dni);//obtemos a posición
            ras.seek(posicion);//nos posicionamos
            ras.writeUTF("*");//metemos o asterisco
            long ultPosicion = ras.length();//danos a última posición
            ras.seek(ultPosicion); //posicionámonos na última posición
            ras.writeUTF(dni);//escribimos o dni
            ras.writeUTF(user.getNome());//escribimos o nome
            ras.writeUTF(String.valueOf(user.getIdade()));//escribimos a idade
            index.remove(dni);//eliminamos o índice dese dni
            index.put(dni, ultPosicion);//actualizamos o index
        }
    }

    /**
     * método que elimina de resultados.txt un usuario cun dni
     *
     * @param dni
     * @throws Exception
     */
    @Override
    public void delete(String dni) throws Exception {
        if (index.get(dni) != null) {
            try ( RandomAccessFile ras = new RandomAccessFile(filename, "rws");) {
                long posicion = index.get(dni);//obtemos a posición
                ras.seek(posicion);//nos posicionamos
                ras.writeUTF("*");//metemos o asterisco
                index.remove(dni);//eliminamos
            }
        }
    }

    /**
     * método que pecha o usuario Storage e garda os datos do treeMap
     *
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        try ( DataOutputStream dos = new DataOutputStream(new FileOutputStream(indexname))) {
            Set<String> keys = index.keySet();
            for (String k : keys) {
                dos.writeUTF(k);
                dos.writeLong(index.get(k));
            }
        }
    }
}
