
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * clase cos métodos relevantes para o almacenamento e recuperación dos datos
 * @author alba_
 */
class Database {
    
    /**
     * método que permite ler un obxecto da clase Banco almacenado nun arquivo chamado "datoscuentasbancarias.dat".
     * @return 
     */
    public Banco leer() {
        //try (ObjectInputStream obj=new ObjectInputStream(new FileInputStream("datoscuentasbancarias.dat")))
        File file = new File("datoscuentasbancarias.dat"); //creamos o arquivo
        if(!file.exists()){
            try {
                file.createNewFile();//se non existe crea o ficheiro
                return null;
            } catch (IOException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try(FileInputStream input = new FileInputStream(file);ObjectInputStream obj = new ObjectInputStream(input);) {//comprobamos se existe
            
            //Primeiro, crea un obxecto FileInputStream para ler os bytesOutputGuardar do arquivo 
//            FileInputStream input = new FileInputStream(file);
            //agora o utiliza para crear un obxecto ObjectInputStream
//            ObjectInputStream obj = new ObjectInputStream(input);
            /*O obxecto ObjectInputStream utilízase para ler os obxectos do arquivo na 
            orde en que se escribiron.*/
            Banco banco=(Banco)obj.readObject();//o obxecto Banco lese utilizando o método readObject()
            /*Unha vez que se leeu o obxecto Banco, péchase o obxecto ObjectInputStream 
            e o obxecto FileInputStream*/
//            obj.close();
//            input.close();
            return banco;
        //Se se produce algunha excepción ao ler o arquivo, registrarase unha mensaxe de erro.
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * método que vai gardar unha piscina nun arquivo chamado "datoscuentasbancarias.dat", utilizando 
     * un obxecto ObjectOutputStream.
     * @param banco
     * @return 
     */
    public boolean guardar(Banco banco) {
        File file = new File("datoscuentasbancarias.dat");//creamos un obxecto File que representa o arquivo "datoscuentasbancarias.dat"
        //creamos un obxecto FileOutputStream para escribir no arquivo
        //creamos un obxecto ObjectOutputStream
        if(!file.exists()){
                return false;
        }
        try (FileOutputStream output = new FileOutputStream(file);
            ObjectOutputStream obj = new ObjectOutputStream(output);){ //try with resources
            file.createNewFile();//creamos o arquivo se non existe
            obj.writeObject(banco);//escribimos o obxecto Banco no archivo utilizando o método writeObject().
            //comentamos estas liñas porque implícitamente agora co try with resources vanse pechar
//            obj.close();//pechamos
//            output.close();//pechamos
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
}
