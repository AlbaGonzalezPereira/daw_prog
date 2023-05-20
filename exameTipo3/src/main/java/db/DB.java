package db;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase da conexión da base de datos. COPIADA
 * @author alba_
 */
public class DB  implements Closeable {
    private static DB db=null;
//    public static String DRIVER="org.mariadb.jdbc.Driver";
    public static String URL="jdbc:.....";
    public static String USER="user";
    public static String PASS="pass";
    
    private Connection conn=null;
        
    /**
     *  Singleton. open crea o obxeto DB que establece a conexiÃ³n
     *  si non estÃ¡ xa establecida. Si estÃ¡ establecida retorna o obxecto
     *  existente. Iso evita facer conexiÃ³ns/desconexiÃ³ns continuas.
     */
    public static DB open() throws SQLException, ClassNotFoundException {
        if (DB.db==null) DB.db=new DB();
        return DB.db;
    }
    
   /**
    * Retorna a conexiÃ³n para traballar coa BBDD
    */
    public static Connection getConnection() {
        if (DB.db==null) throw new RuntimeException("Debes abrir antes a conexión con open");
        try {
            if (DB.db.conn==null) DB.db.connect();  // Reconectamos si Ã© necesario
            return DB.db.conn;
        } catch (ClassNotFoundException | RuntimeException | SQLException ex) {
            throw new RuntimeException("Erro obtendo conexión coa BBDD: "+ex.getMessage());
        }
    }

    /**
     * Construtor. Ã‰ privado para implementer Singleton. Garante que unicamente
     * pode existir unha instancia da clase
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    private DB() throws SQLException, ClassNotFoundException {
        connect();
    }
    
    /**
     * Establece a conexiÃ³n coa BBDD
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    private final void connect() throws SQLException,ClassNotFoundException {
//        Class.forName(DB.DRIVER);
        conn=DriverManager.getConnection(DB.URL,DB.USER,DB.PASS);
    }
    
    /**
     * O mÃ©todo close de Closeable non pode lanzar SQLException,lanzo unha non-checked exception
     * en caso de erro.
     */
    @Override
    public void close() {
        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro pechando conexión: "+ex.getMessage());
            }
        }
        conn=null;
        DB.db=null;
    }
}

