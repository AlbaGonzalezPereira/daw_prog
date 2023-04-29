package com.prog11.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alba_
 */
public class VehiculosDAO {
    /**
     * método que recibe por parámetro os datos do vehículo a insertar, trata de insertalo 
     * na BBDD.
     * @param vehiculo
     * @return - 0 se a operación se realizou con éxito ou -1 en caso contrario
     */
    public static int insertarVehiculo(Vehiculo vehiculo){
        //declaramos a consulta:
        String sql = "INSERT INTO vehiculos(mat_veh, marca_veh,kms_veh,precio_veh,desc_veh, id_prop) VALUES(?,?,?,?,?,?);";
        /****************/
        
        
        /****************/
        int numAdd;
        /* 
            ISTO É SIMILAR AO QUE POÑEMOS NO stmt de abaixo
            String sql = "Insert into Vehiculos ( mat_veh, marca_veh, kms_veh, precio_veh, desc_veh, id_prop)"
                    + " values ('" + mat + "', '" + marca + "', '" + kms + "', '" + precio + "', '" + desc + "', '" + id_prop + "')";
            st.executeUpdate(sql);
        */
        //declaramos conexion e a clase para modificar os valores
        //facemos un try with resources coas dúas enteriores
        try(Connection con = ConnectionDB.openConnection();PreparedStatement stmt = con.prepareStatement(sql)) {
            //agregamos os valores na consulta:
            stmt.setString(1,vehiculo.getMat_veh()); //engadimos o primeiro value
            stmt.setString(2,vehiculo.getMarca_veh());//engadimos o segundo value
            stmt.setInt(3, vehiculo.getKms_veh());
            stmt.setFloat(4, vehiculo.getPrecio_veh());
            stmt.setString(5, vehiculo.getDesc_veh());
            stmt.setInt(6, vehiculo.getId_prop());
            numAdd = stmt.executeUpdate(); //executamos
        } catch (SQLException ex) {
            return -1; //se non se realiza con éxito
        }
        //comprobamos que insertou algún rexistro
        if(numAdd > 0)
            return 0; //se se realiza con éxito    
        return -1;
    }
    
    /**
     * método que recibe por parámetro a matrícula dun vehículo xunto ao identificador 
     * dun propietario e trata de actualizar o vehículo na BBDD. 
     * @param matricula
     * @return - 0 se a operación se realizou con éxito ou -1 si o vehículo non existe
     */
    public static int actualizarPropVehiculo(String matricula, int id_prop){
        String sql = "UPDATE vehiculos SET mat_veh = ? WHERE id_prop = ?;";
        int numMod;
        try(Connection con = ConnectionDB.openConnection();PreparedStatement stmt = con.prepareStatement(sql);) {
            stmt.setString(1,matricula); //poñemos o primeiro valor na consulta
            stmt.setInt(2, id_prop);//poñemos o segundo valor na consulta
            numMod = stmt.executeUpdate(); // recollemos o número de modificacions   
        } catch (SQLException ex) {
            return -1; //se non se realiza con éxito
        }
        
        //comprobamos o número de modificados
        if(numMod > 0)
            return 0; //se se modificou algún dato
        return -1; //se non se modificou
    }
    
    /**
     * método que recibe por parámetro a matrícula dun vehículo e trata de eliminalo da BBDD.
     * @param matricula
     * @return - 0 se a operación se realizou con éxito ou -1 si o vehículo non existe.
     */
    public static int eliminarVehiculo(String matricula){
        String sql = "DELETE FROM vehiculoss WHERE mat_veh = ?";
        int numEliminados = 0;
        try(Connection con = ConnectionDB.openConnection();PreparedStatement stmt = con.prepareStatement(sql);) {
            //agregamos os valores:
            stmt.setString(1,matricula); //engadimos o value
            numEliminados = stmt.executeUpdate(); // recollemos o número de eliminados   
        } catch (SQLException ex) {
            return -1; //se non se realiza con éxito
        }
        //comprobamos o número de eliminados
        if(numEliminados > 0)
            return 0; //se se eliminou algún dato
        return -1; //se non se eliminou
    }
    /**
     * método que devolve unha lista con todos os vehículos do concesionario.Para cada vehículo, 
     * a lista conterá unha cadea de caracteres cos datos do mesmo, incluído o nome do propietario
     * @return 
     */
    public static ArrayList<String> recuperarVehiculos(){
        String sql = "SELECT mat_veh, marca_veh, kms_veh, precio_veh, nombre_prop "
                + "FROM vehiculos, propietarios "
                + "WHERE vehiculos.id_prop = propietarios.id_prop;";
        ArrayList<String> lista = new ArrayList<>(); //declaramos a lista a devolver
        try(Connection con = ConnectionDB.openConnection();PreparedStatement stmt = con.prepareStatement(sql);) {
            try(ResultSet rs = stmt.executeQuery();){//recollemos o select nun ResultSet
                while(rs.next()){
                    //agregamos os valores:
                    lista.add(rs.getString(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getDouble(4) + " " + rs.getString(5));
                }
            }
        } catch (SQLException ex) {
            return null; //se non se realiza con éxito
        }
        return lista; //se se realiza con éxito
    }
    
    /**
     * método que recibe unha marca por parámetro e devolve unha lista co listado de vehículos 
     * da citada marca. Para cada vehículo, a lista conterá unha cadea de caracteres cos datos
     * do mesmo, incluído o nome do propietario. 
     * @param marca
     * @return - ArrayList
     */
    public static ArrayList<String> recuperarVehiculos(String marca){
        String sql = "SELECT mat_veh, marca_veh, kms_veh, precio_veh, nombre_prop "
                + "FROM vehiculos, propietarios "
                + "WHERE vehiculos.id_prop = propietarios.id_prop AND marca_veh = ?;";
        ArrayList<String> lista = new ArrayList<>(); //declaramos a lista a devolver
        try(Connection con = ConnectionDB.openConnection();PreparedStatement stmt = con.prepareStatement(sql);) {
            //agregamos os valores na consulta:
            stmt.setString(1, marca);
            try(ResultSet rs = stmt.executeQuery();){//recollemos o select nun ResultSet
                while(rs.next()){
                    lista.add(rs.getString(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getDouble(4) + " " + rs.getString(5));
                }
            }
        } catch (SQLException ex) {
            return null; //se non se realiza con éxito
        }
        return lista; //se se realiza con éxito
    }
    
    /**
     * método que non recibe parámetros (só a coneción coa BBDD).
     * @param con
     * @return - lista coa matrícula, marca, kilómetros e precio de cada vehículo
     */
    public static ArrayList<String> recuperarVehiculos(Connection conexion){
        String sql = "SELECT mat_veh, marca_veh, kms_veh, precio_veh, nombre_prop "
                + "FROM vehiculos, propietarios "
                + "WHERE vehiculos.id_prop = propietarios.id_prop;";
        ArrayList<String> lista = new ArrayList<>(); //declaramos a lista a devolver
        try(Connection con = conexion;PreparedStatement stmt = con.prepareStatement(sql);) { //a conexión xa a temos
            try(ResultSet rs = stmt.executeQuery();){//recollemos o select nun ResultSet
                while(rs.next()){
                    //agregamos os valores:
                    lista.add(rs.getString(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getDouble(4) + " " + rs.getString(5));
                }
            }
        } catch (SQLException ex) {
            return null; //se non se realiza con éxito
        }
        return lista; //se se realiza con éxito
    }
    
}
