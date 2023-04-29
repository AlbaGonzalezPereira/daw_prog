package com.prog11.bbdd;

import com.prog11.princ.Prog11_Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que se vai encargar de realizar a conexión á base de datos e o peche da mesma
 * @author alba_
 */
public class ConnectionDB {
    private static Connection con = null;//establecemos a conexión a null
    
    /**
     * método para establecer a conexión
     * @return - Connection
     */
    public static Connection openConnection(){
        try {
            //se fose necesario cargar o driver de mariadb o faríamos así:
            //Class.forName("org.mariadb.jdbc.Driver"); --> tería un catch
            
            //creamos a variable url
            String url = "jdbc:mariadb://localhost/concesionario?allowPublicKeyRetrieval=true&useSSL=false";
            //se quixeramos poñer o usuario e contrasinal na variable url de arriba o poríamos así:
            //String url = "jdbc:mariadb://localhost/concesionario?user=root&password='';
            con = DriverManager.getConnection(url, "root", "");//facemos a conexión
            //System.out.println("Conexión creada");//comprobamos que fai a conexión
            //con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Prog11_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con; //devolvemos a conexión
    }
    
    /**
     * método para pechar a conexión
     */
    public static void closeConnection(){
        try {
            if (con != null) { //comprobamos se a conexión non é null
                con.close(); //pechamos a conexión
                con = null; //asignamos null ao obxecto Connection
            }
        } catch (SQLException ex) {
            Logger.getLogger(Prog11_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
