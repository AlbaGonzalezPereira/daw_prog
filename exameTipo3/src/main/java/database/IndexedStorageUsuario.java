package database;

import implementacion.Usuario;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que va a gestionar los usuarios con ras
 * @author alba_
 */
public class IndexedStorageUsuario implements Storage {
    protected IndexRAS<String> index=null;
    String filename;

    public IndexedStorageUsuario(String filename) {
        this.filename = filename;
    }
    
    private void makeIndex() throws StorageException {
        Usuario usu;
        // try-with-resources: Pecha ao rematar
        try (RandomAccessFile ras=new RandomAccessFile(filename,"rws")) {
            index=new IndexRAS<>();
            long position=ras.getFilePointer();
            usu=read(ras);
            while(usu!=null) {
                // Si o elemento está borrado, non o poño no índice
                if (!isDeleted(usu)) index.addIndex(getKey(usu), position);
                position=ras.getFilePointer();
                usu=read(ras);
            }
        } catch (IOException ex) {
            index=null;
            throw new StorageException("Indexed Storage Constructor Error: "+ex.getMessage());
        }
    }
    
    protected Usuario read(RandomAccessFile ras) throws StorageException{
    try {
            String rexistro = ras.readLine();
            if (rexistro != null) {
                String[] datos = rexistro.split(",");
                return new Usuario(datos[0], datos[1], Integer.parseInt(datos[2]));
            }
            return null;
        } catch (EOFException e) {
            return null;
        } catch (IOException ex) {
            throw new StorageException("Indexed Storage read: " + ex.getMessage());
        }
    }

    /**
     * método que devolve un usuario a partir dun dni
     * @param dni
     * @return
     * @throws Exception 
     */
    @Override
    public Usuario get(String dni) throws Exception {   
        if(index==null) makeIndex();
        Long position=index.getPosition(dni);//colle a posición onde está o dni
        if (position==null) throw new StorageException("Get: O dni non existe");
        try (RandomAccessFile ras=new RandomAccessFile(filename,"rws")) {
            ras.seek(position);//posiciónase para ler a liña
            String linea = readLine(ras);//recolle a liña lida na variable linea
            String[] campos = new String[3];//creamos o array de cada un dos campos da liña
            campos = linea.split(",");//partimos a liña e a engadimos ao array campos
            return new Usuario(campos[0], campos[1], Integer.parseInt(campos[2]));//retornamos o usuario cos campos
        } catch (Exception ex) {
            throw new StorageException("Indexed Storage insert: "+ex.getMessage());
        }
        
    }

    @Override
    public void insert(Usuario usu) throws Exception {
        if (index==null) makeIndex();
        Long position=index.getPosition(getKey(usu));
        if (position!=null) throw new StorageException("Insert: O rexistro xa existe");
        try (RandomAccessFile ras=new RandomAccessFile(filename,"rws")) {
            position=ras.length();
            ras.seek(position);
            write(ras,usu);
            index.addIndex(getKey(usu),position);
        } catch (Exception ex) {
            throw new StorageException("Indexed Storage insert: "+ex.getMessage());
        }
    }

    /**
     * método que actualiza un usuario
     * @param usu
     * @throws Exception 
     */
    @Override
    public void update(Usuario usu) throws Exception {
        if (index==null) makeIndex();
        String key=getKey(usu);
        Long position=index.getPosition(key);
        if (position==null) throw new StorageException("Update: O rexistro non existe");
        try (RandomAccessFile ras=new RandomAccessFile(filename,"rws")) {
            ras.seek(position);//posiciónase na liña
            remove(ras);//pon o "*" na liña para indicar que se borrou
            index.delIndex(key);//elimina o index
            position=ras.length();//lee o tamaño do ras que é a última posición
            ras.seek(position);//posiciónase na última liña
            write(ras,usu);//escribe o usuario no ras, o arquivo
            index.addIndex(getKey(usu),position);//escribe e engade o index no outro arquivo        
        } catch (Exception ex) {
            throw new StorageException("Indexed Storage update: "+ex.getMessage());
        }
    }

    @Override
    public void delete(String dni) throws Exception {
        if (index==null) makeIndex();
        Long position=index.getPosition(dni);
        if (position==null) throw new StorageException("Delete: O rexistro non existe");
        try (RandomAccessFile ras=new RandomAccessFile(filename,"rws")) {
            ras.seek(position);
            remove(ras);
            index.delIndex(dni);
            System.out.println("Usuario eliminado correctamente");
        } catch (Exception ex) {
            throw new StorageException("Indexed Storage delete: "+ex.getMessage());
        }
    }

    private boolean isDeleted(Usuario usu) {
        if(usu.getDni().charAt(0)=='*')
            return true;
        return false;
    }

    private String getKey(Usuario usu) {
        return usu.getDni();
    }
    
    /**
     * método que escribe un Usuario cun dni, nome e idade
     * @param ras
     * @param usu
     * @throws StorageException 
     */
    protected void write(RandomAccessFile ras,Usuario usu) throws StorageException{
        try {
            ras.writeBytes(usu.getDni() + "," + usu.getNome() + "," + usu.getIdade() + "\n");
        } catch (IOException ex) {
            Logger.getLogger(IndexedStorageUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * método que engade ás liñas eliminadas un "*"
     * @param ras
     * @throws StorageException 
     */
    protected void remove(RandomAccessFile ras) throws StorageException{
        try {
            ras.writeBytes("*");
        } catch (IOException ex) {
            Logger.getLogger(IndexedStorageUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * lee unha liña
     * @param ras
     * @return - String
     */
    private String readLine(RandomAccessFile ras) throws IOException {
        ArrayList<Byte> lineas = new ArrayList<>();//arraylist
        try{
            byte leeByte = ras.readByte();//lemos un byte
            while(leeByte !='\n'){//mentres haxa un \n
                //if(leeByte!='\r')
                    lineas.add(leeByte);//engade ao array os chars que lee
               leeByte=ras.readByte();//lee un byte
            }
        }catch(EOFException e){} //cando chegue ao final non fai nada
        
        int tamanho = lineas.size();
        if(tamanho==0)
            return null;
        byte[] bytes = new byte[tamanho];
        for (int i = 0; i < tamanho; i++) {
            bytes[i]=lineas.get(i); //pasa o arraylist a un array de bytes           
        }
        return new String(bytes);//convirte o array de bytes (que ten char) a un String
    }
    
    /**
     * método que devolve todos os usuarios
     * @return 
     */
    public Usuario[] getAll(){
        ArrayList<Usuario> usuarios = new ArrayList<>(); //creamos o arraylist de usuarios
        try (RandomAccessFile ras = new RandomAccessFile(filename, "rws")){
            String linea;
            String[] lineas;
            linea=readLine(ras);
            while(linea!=null){//se non é  null
                lineas=linea.split(",");//parte as liñas en trozos
                usuarios.add(new Usuario(lineas[0], lineas[1], Integer.parseInt(lineas[2])));//engade ao arrayList 
                linea=readLine(ras);//lee outra liña
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IndexedStorageUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IndexedStorageUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return usuarios.toArray(Usuario[]::new);//pasamos coma un array o arraylist
    }
    
}
