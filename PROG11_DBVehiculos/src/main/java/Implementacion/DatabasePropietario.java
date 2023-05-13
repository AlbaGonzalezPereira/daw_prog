package Implementacion;

import Database.Conexion;
import Database.Criteria;
import Database.Database;
import Database.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alba_
 */
public class DatabasePropietario implements Database<Propietario,String>{

    /**
     * método que vai permitir insertar datos na táboa propietario
     * @param data - propietario
     * @return - número de insertados ou 0 en caso de non insertar ningún dato
     * @throws DatabaseException 
     */
    @Override
    public int insert(Propietario data) throws DatabaseException {
        Connection con = Conexion.openConnection();
        String sql = "INSERT INTO propietario VALUES (?,?,?)";//consulta
        int insertados = 0;
        try(PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, data.getDni());
            stmt.setString(2, data.getNome());
            stmt.setString(3, data.getApelidos());
            insertados=stmt.executeUpdate();//executamos a sentenza e gardamos o número que devolve nunha variable
        } catch (SQLException ex) {
            Logger.getLogger(DatabasePropietario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return insertados;
    }

    /**
     * método que actualiza o propietario dado un dni
     * @param data - propietario
     * @return - número de actualizados
     * @throws DatabaseException 
     */
    @Override
    public int update(Propietario data) throws DatabaseException {
        Connection con = Conexion.openConnection();
        String sql = "UPDATE propietario SET nome = ?, apelidos = ? WHERE dni = ?";//consulta
        int actualizados=0;
        try(PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, data.getNome());
            stmt.setString(2, data.getApelidos());
            stmt.setString(3, data.getDni());
            actualizados=stmt.executeUpdate();//executamos a sentenza e gardamos o número que devolve nunha variable
        } catch (SQLException ex) {
            Logger.getLogger(DatabasePropietario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actualizados;
    }

    @Override
    public int insertOrUpdate(Propietario data) throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * método que elimina un propietario dado un dni
     * @param data - propietario
     * @throws DatabaseException 
     */
    @Override
    public void delete(Propietario data) throws DatabaseException {
        Connection con = Conexion.openConnection();
        String sql = "DELETE FROM propietario WHERE dni = ?";//consulta
        try(PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, data.getDni());
            if(stmt.executeUpdate()!=0)//executamos a sentenza 
                System.out.println("Propietario eliminado correctamente");
            else
                System.out.println("Propietario non atopado");
        } catch (SQLException ex) {
            Logger.getLogger(DatabasePropietario.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Propietario[] delete(Criteria<Propietario> c) throws DatabaseException {
       throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody 
    }

    @Override
    public Propietario[] select(Criteria<Propietario> c) throws DatabaseException {
       throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody 
    }

    /**
     * método que selecciona un propietario cun dni dado
     * @param key - dni
     * @return - propietario
     * @throws DatabaseException 
     */
    @Override
    public Propietario select(String key) throws DatabaseException {
        Connection con = Conexion.openConnection();
        Propietario propietario = null;
        String sql = "SELECT * FROM propietario WHERE dni = ?";
        try(PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, key);
            ResultSet resultado = stmt.executeQuery();
            if(resultado.next()){//porque neste caso será só 1, senón mellor nun while
                propietario = new Propietario(resultado.getString(1), resultado.getString(2), resultado.getString(3));
                //propietario = new Propietario(resultado.getString(dni), resultado.getString(nome), resultado.getString(apelidos));
            }        
        } catch (SQLException ex) {
            Logger.getLogger(DatabasePropietario.class.getName()).log(Level.SEVERE, null, ex);
        }        
      return propietario;  
    }
}
