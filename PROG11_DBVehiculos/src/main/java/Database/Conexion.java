package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alba_
 */
public class Conexion implements AutoCloseable {

    //declaramos os atributos da conexión  
    public static String DRIVER = "org.mariadb.jdbc.Driver";
    public static String URL = "jdbc:mariadb://localhost/concesionariosql";
    public static String USER = "root";
    public static String PASS = "";
    //declaramos un obxecto Connection
    private static Connection con = null;
    
    /* PATRÓN SINGLETON:
    Para patrón Singleton, indica que só se pode crear un obxecto desa clase. cando queramos
    crear un obxecto desa clase, vai devolver o obxecto xa creado.
    - necesita un atributo que é un obxecto da propia clase
    - necesita un constructor baleiro pero privado para que non se poda chamar, para evitar que
    se cree un obxecto desde fora da clase.
    - un método o cal vai funcionar coma o constructor: se conexión é null, vai crear o obxecto
    e senón o vai devolver
    */
    private static Conexion conexion = null; //obxecto da clase

    private Conexion() { //constructor baleiro private
    }
    
    public static Conexion crearConexion(){ 
        if (conexion == null) conexion = new Conexion(); //crea a conexión se é null
        return conexion;//devolve a conexión
    }
    
    /**
     * método que abre a conexión e lanza unha SQLEXception en caso de erro
     * @return 
     */
    public static Connection openConnection() {
        //establecemos a conexión       
        try {
            if (con == null) {
                con = DriverManager.getConnection(URL, USER, PASS);//facemos a conexión
                System.out.println("Conexión creada");//comprobamos que fai a conexión
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con; //devolvemos a conexión
    }

    /**
     * método que pecha a conexión e lanza unha SQLEXception en caso de erro
     */
    public static void closeConnection() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Conexión pechada");
                con = null; //para pechar a conexión
                conexion = null;//para "borrar" obxecto da clase
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("A conexión xa está pechada");
        }
    }

    /**
     * método que pecha a conexión. Chama ao método closeConnection()
     * @throws Exception 
     */
    @Override
    public void close() throws Exception {
        closeConnection();//chamamos ao método anterior xa creado
    }

}//fin class
