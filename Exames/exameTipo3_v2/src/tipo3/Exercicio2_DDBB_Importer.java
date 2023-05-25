package tipo3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercicio2_DDBB_Importer implements Importer {
    // Eficiente ao utilizar unha sentencia preparada e non depende de UsuariosStorageDDBB
    
    /**
     * método que inserta datos e que os importa do arquivo datos.txt á base de datos cando arranca o programa
     */
    public void importData() {
        String sql="INSERT INTO usuarios(dni,nome,edade) VALUES(?,?,?)";
        Connection con=DB.getConnection();
        try(BufferedReader rdr=new BufferedReader(new FileReader("datos.txt")); PreparedStatement stmt = con.prepareStatement(sql);) {//preparamos a consulta
            String line=rdr.readLine();
             while(line != null){
                 Usuario u = Usuario.fromString(line);//lemos a liña e obtemos o usuario
                 //preparamos a consulta
                 stmt.setString(1, u.getDni());
                 stmt.setString(2, u.getNome());
                 stmt.setInt(3, u.getIdade());
                 stmt.execute();//executamos a consulta
                 line=rdr.readLine();//lemos outra liña
        }   
              
    }   catch (IOException ex) {
            Logger.getLogger(Exercicio2_DDBB_Importer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Exercicio2_DDBB_Importer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Exercicio2_DDBB_Importer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Exercicio2_DDBB_Importer importer=new Exercicio2_DDBB_Importer();
        //na url poñemos localhost e despois a base de datos
        DB.URL="jdbc:mariadb://localhost/usuarios?allowPublicKeyRetrieval=true&useSSL=false";
        //o driver o importamos da librería
        DB.USER="";
        DB.PASS="";
        try(DB db=DB.open()) {
            importer.importData();
        }
    }
}
