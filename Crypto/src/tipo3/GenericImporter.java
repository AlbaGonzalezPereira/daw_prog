package tipo3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Outra opción:
 * 
 * Importa os datos ao ficheiro resultados.txt ou a BBDD dependendo
 * do Storage que se lle pase ao construtor.
 * 
 */
public class GenericImporter implements Importer {
    private final Storage storage;
    
    public GenericImporter(Storage storage) {
        this.storage=storage;
    }

    /**
     * método que inserta ou importa os datos, dependendo se é un StorageFile ou un StorageDDBB
     */
    @Override
    public void importData() {
        try(BufferedReader rdr=new BufferedReader(new FileReader("datos.txt"))) {//lemos os datos
            //rdr.readline() //se tiveramos unha cabeceira ou csv. así non garda a primeira liña
             String line=rdr.readLine();//lemos unha liña e a gardamos nunha variable
             while(line != null){
                 Usuario u = Usuario.fromString(line);//lemos a liña e obtemos o usuario
                 storage.insert(u); //engadimos un usuario ao storage. Se é un ficheiro o inserta por ficheiro e se un StorageDDBB o inserta como bbdd
                 line=rdr.readLine();//lemos outra liña
             }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenericImporter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenericImporter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(GenericImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DB.URL="jdbc:mariadb://192.168.122.2:3306/mi_bd?allowPublicKeyRetrieval=true&useSSL=false";
        DB.USER="user";
        DB.PASS="pass";
        /**
         * Si creamos un UsuariosStorageDDBB a "importacion" se fai a unha BBDD relacional
         * Si creamos un UsuariosStorageFile a "importacion" se fai a ficheiros de acceso aleatorio cun indice
         */
        try(
            DB db=DB.open();
            //Storage storage=new UsuariosStorageDDBB()
              Storage storage=new UsuariosStorageFile("resultados.txt","resultados.idx")
        ) {
            Importer importer=new GenericImporter(storage);
            importer.importData();
        } catch(Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
