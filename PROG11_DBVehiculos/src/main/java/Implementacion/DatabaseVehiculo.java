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
public class DatabaseVehiculo implements Database<Vehiculo, String> {

    /**
     * método que inserta un vehículo cuns valores
     *
     * @param data
     * @return - número de vehículos insertados
     * @throws DatabaseException
     */
    @Override
    public int insert(Vehiculo data) throws DatabaseException {
        Connection con = Conexion.openConnection();
        String sql = "INSERT INTO vehiculo(matricula,marca,modelo,propietario) VALUES (?,?,?,?)";//consulta
        int vinsertados = 0;
        Propietario propietario = data.getPropietario();
        String dni = null;
        if (propietario != null) {
            dni = propietario.getDni();
        }
        try ( PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, data.getMatricula());
            stmt.setString(2, data.getMarca());
            stmt.setString(3, data.getModelo());
            stmt.setString(4, dni);
            vinsertados = stmt.executeUpdate();//executamos a sentenza e gardamos o número que devolve nunha variable
        } catch (SQLException ex) {
            throw new DatabaseException("Non se pudo insertar o vehículo" + ex.getMessage());
        }
        return vinsertados;
    }

    /**
     * método que actualiza os datos dun vehículo
     *
     * @param data
     * @return
     * @throws DatabaseException
     */
    @Override
    public int update(Vehiculo data) throws DatabaseException {
        Connection con = Conexion.openConnection();
        String sql = "UPDATE vehiculo SET marca = ?, modelo = ?, propietario = ? WHERE matricula = ?";//consulta
        int vactualizados = 0;
        Propietario propietario = data.getPropietario();
        String dni = null;
        if (propietario != null) {
            dni = propietario.getDni();
        }
        try ( PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, data.getMarca());
            stmt.setString(2, data.getModelo());
            stmt.setString(3, dni);
            stmt.setString(4, data.getMatricula());
            vactualizados = stmt.executeUpdate();//executamos a sentenza e gardamos o número que devolve nunha variable
        } catch (SQLException ex) {
            throw new DatabaseException("Non se pudo actualizar o vehículo" + ex.getMessage());
        }
        return vactualizados;
    }

    @Override
    public int insertOrUpdate(Vehiculo data) throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * método que elimina un vehículo. Chama ao método delete(String matricula)
     *
     * @param data
     * @throws DatabaseException
     */
    @Override
    public void delete(Vehiculo data) throws DatabaseException {
        delete(data.getMatricula());
    }

    /**
     * método que elimina un vehículo dado un dni
     *
     * @param data
     * @throws DatabaseException
     */
    public void delete(String matricula) throws DatabaseException {
        Connection con = Conexion.openConnection();
        String sql = "DELETE FROM vehiculo WHERE matricula = ?";//consulta
        try ( PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, matricula);
            if (stmt.executeUpdate() > 0)//executamos a sentenza e gardamos o número que devolve nunha variable
            {
                System.out.println("Eliminouse o vehículo correctamente");
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Non se pudo eliminar o vehículo" + ex.getMessage());
        }

    }

    @Override
    public Vehiculo[] delete(Criteria<Vehiculo> c) throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vehiculo[] select(Criteria<Vehiculo> c) throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * método que selecciona todos os vehículos cuia matrícula corresponda coa
     * dada
     *
     * @param key
     * @return
     * @throws DatabaseException
     */
    @Override
    public Vehiculo select(String key) throws DatabaseException {
        Connection con = Conexion.openConnection();
        String sql = "SELECT * FROM vehiculo v LEFT JOIN propietario p ON v.propietario = p.dni WHERE matricula = ?";//consulta
        try ( PreparedStatement stmt = con.prepareStatement(sql)) {
            Vehiculo vehiculo = null;
            stmt.setString(1, key);
            ResultSet seleccionado = stmt.executeQuery();//executamos a sentenza
            if (seleccionado.next()) {//porque neste caso será só 1, senón mellor nun while
                if (seleccionado.getString("propietario") != null) {
                    Propietario p = new Propietario(seleccionado.getString("dni"), seleccionado.getString("nome"), seleccionado.getString("apelidos"));
                    vehiculo = new Vehiculo(seleccionado.getString("matricula"), seleccionado.getString("marca"), seleccionado.getString("modelo"));
                    vehiculo.setPropietario(p);//modifico o propietario
                    p.getVehiculos().add(vehiculo); //engadimos o vehículo ao propietario
                }
                else{
                    vehiculo = new Vehiculo(seleccionado.getString("matricula"), seleccionado.getString("marca"), seleccionado.getString("modelo"));
                }
            }
            return vehiculo;
        } catch (SQLException ex) {
            throw new DatabaseException("Non se atopou ningún vehículo coa matrícula" + key + ex.getMessage());
        }
       

    }

}
