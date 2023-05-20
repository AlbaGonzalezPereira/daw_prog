package database;

/**
 * Clase que nos crea un index mediante un ficheiro
 * @author alba_
 */
import implementacion.Usuario;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IndexRAS<K> {
    //private final HashMap<K,Long> index=new HashMap<>();
    String filename="resultados.idx";
 
    /**
     * método que nos vai engadir un índice despois do dni deste xeito dni-espazo-index
     * @param key - dni
     * @param position - o número de byte
     */
    public void addIndex(K key,long position) {
        try(RandomAccessFile ras = new RandomAccessFile(filename, "rws")) {
            ras.seek(ras.length());//posicionámomos ao final para engadilo ao final
            ras.writeBytes((String) key + " " + position + "\n");//engadimos o index que irá deste xeito dni-espazo-index
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IndexRAS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IndexRAS.class.getName()).log(Level.SEVERE, null, ex);
        }
        //index.put(key,position);
    }
    
    /**
     * método que elimina o índice dun RandomAccessFile
     * @param key 
     */
    public void delIndex(K key) {
        try(RandomAccessFile ras = new RandomAccessFile(filename, "rws")) {
            Long posicion=ras.getFilePointer();
            String linea=readLine(ras);
            boolean encontrado=false;
            String dni;
            while(linea!=null && !encontrado){
                dni=linea.split(" ")[0];//colle o primeiro elemento que é o dni (mirar addIndex)
                if(dni.equals(key)){
                    encontrado=true;
                    ras.seek(posicion);
                    ras.writeBytes("*");
                }
                posicion=ras.getFilePointer();
                linea=readLine(ras);                      
            }      
        } catch (EOFException ex) {} //non fai nada
        
          catch (FileNotFoundException ex) {
            Logger.getLogger(IndexRAS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IndexRAS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * método que obtén todas as posicións do índice do arquivo RandomAccessFile
     * @return 
     */
    public Collection<Long> getPositions() {
        Collection<Long> col= new ArrayList<>();
        try(RandomAccessFile ras = new RandomAccessFile(filename, "rws")) {
            ras.seek(0);//posiciónase na primeira liña
            String dni;
            Long pos;
            String linea=readLine(ras);
            while(linea!=null){
                dni=linea.split(" ")[0];//garda o dni que é o primeiro elemento
                if(!dni.startsWith("*")){//se non empeza con "*", é dicir, que está eliminado
                    pos=Long.valueOf(linea.split(" ")[1]);//garda a posición
                    col.add(pos);//engádea ao array
                }
                linea=readLine(ras); //lee a liña       
            }    
        } catch (EOFException ex) { } //excepcón cando chega ao final do arquivo
        
          catch (FileNotFoundException ex) {
            Logger.getLogger(IndexRAS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IndexRAS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return col;//devolve todas as posicións nun arrayList
    }
    /**
     * Retorna a posición na que se atopa o rexistro con chave Key
     * @param key chave do rexistro
     * @return Posición ou null si non está
     * 
     * Temos que retornar a clase Long e non o tipo primitivo long
     * para poder retornar null en caso de que non exista
     */
    public Long getPosition(K key) {
        try(RandomAccessFile ras = new RandomAccessFile(filename, "rws")) {
            ras.seek(0);//posiciónase no primeiro       
            Long pos;
            String dni;
            String linea=readLine(ras);
            while(linea!=null){
                dni=linea.split(" ")[0];
                if(dni.equals(key)){
                    pos=Long.valueOf(linea.split(" ")[1]);
                    return pos;
                }
                linea=readLine(ras);
            }    
        } catch (EOFException ex) {}
        
          catch (FileNotFoundException ex) {
            Logger.getLogger(IndexRAS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IndexRAS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * método que lee unha liña. COPIADO
     * @param ras
     * @return
     * @throws IOException 
     */
    private String readLine(RandomAccessFile ras) throws IOException {
        ArrayList<Byte> line=new ArrayList<>();
        try {
            byte cbyte=ras.readByte();
            while(cbyte!='\n') {
                line.add(cbyte);
                cbyte=ras.readByte();
            }
        } catch(EOFException e) {
        }
        int size=line.size();
        if (size==0) return null;
        byte[] chars=new byte[line.size()];
        for(int idx=0;idx<size;idx++) chars[idx]=line.get(idx);
        return new String(chars);
    }
}

