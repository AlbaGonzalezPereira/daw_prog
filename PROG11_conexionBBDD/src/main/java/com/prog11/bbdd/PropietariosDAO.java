package com.prog11.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * clase estática que contén os métodos para realizar operacións coa táboa
 * propietarios
 *
 * @author alba_
 */
public class PropietariosDAO { //se poño static dame erro e non sei por que

    /**
     * método que recibe por parámetro os datos dun propietario a insertar,
     * trata de insertalo na BBDD e devolve 0 se a operación se realizou con
     * éxito ou -1 en caso contrario.
     * 
     * @param propietario
     * @return - 0 ou -1
     */
    public static int insertarPropietario(Propietario propietario) {
        //declaramos a consulta:
        String sql = "INSERT INTO propietarios(nombre_prop, dni_prop) VALUES(?,?);";
        //declaramos conexion e a clase para modificar os valores
        //facemos un try with resources coas dúas enteriores
        try (Connection con = ConnectionDB.openConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {
            //agregamos os valores:
            stmt.setString(1, propietario.getNombre_prop()); //engadimos o primeiro value
            stmt.setString(2, propietario.getDni_prop());//engadimos o segundo value
            //stmt.executeUpdate(sql);//executamos //non fai falla por o sql xa que o poñemos no prepareStatement(sql)
            stmt.executeUpdate(); //executamos
        } catch (SQLException ex) {
            return -1; //se non se realiza con éxito
        }
        return 0; //se se realiza con éxito
    }

    /**
     * método que que recibe por parámetro o DNI dun propietario e que devolve
     * os vehículos que ten
     *
     * @param dni - dni do propietario
     * @return - lista coa matrícula, marca, número de kms e precio de todos os
     * seus vehículos ou null
     */
    public static ArrayList<String> recuperarVehiculos(String dni) {
        String sql = "SELECT mat_veh, marca_veh, kms_veh, precio_veh "
                + "FROM vehiculos, propietarios "
                + "WHERE vehiculos.id_prop = propietarios.id_prop AND dni_prop = ?;";
        ArrayList<String> lista = new ArrayList<>(); //declaramos a lista a devolver
        try ( Connection con = ConnectionDB.openConnection();  PreparedStatement stmt = con.prepareStatement(sql);) {
            //agregamos os valores:
            stmt.setString(1, dni); //engadimos o value
            try ( ResultSet rs = stmt.executeQuery();) {//recollemos o select nun ResultSet
                while (rs.next()) {
                    lista.add(rs.getString(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getDouble(4));
                }
            }
        } catch (SQLException ex) {
            return null; //se non se realiza con éxito
        }
        return lista; //se se realiza con éxito    
    }

    /**
     * método que recibe por parámetro o DNI dun propietario e trata de
     * eliminalo da BBDD. Devolve o número de rexistros eliminados.
     *
     * @param dni
     * @return
     */
    public static int eliminaPropietario(String dni) {
        String sql = "DELETE FROM propietarios WHERE dni_prop = ?";
        int numEliminados = 0;
        try ( Connection con = ConnectionDB.openConnection();  PreparedStatement stmt = con.prepareStatement(sql);) {
            //agregamos os valores:
            stmt.setString(1, dni); //engadimos o value
            numEliminados = stmt.executeUpdate(); // recollemos o número de eliminados   
        } catch (SQLException ex) {
            return 0; //se non se realiza con éxito
        }
        return numEliminados; //devolve o número de rexistros eliminados
    }

    /**
     * método que pasando por parámetro un dni, devolve o id un propietario
     *
     * @param dni_prop
     * @return
     */
    public static int getId(String dni_prop) {
        String sql = "SELECT id_prop "
                + "FROM  propietarios "
                + "WHERE dni_prop = ?;";

        try ( Connection con = ConnectionDB.openConnection();  PreparedStatement stmt = con.prepareStatement(sql)) {
            //agregamos os valores na consulta:
            stmt.setString(1, dni_prop); //engadimos o value
            try ( ResultSet rs = stmt.executeQuery()) {//recollemos o select nun ResultSet
                if (rs.next()) {
                    return rs.getInt(1);//collemos o id
                }
                return -1;
            }
        } catch (SQLException ex) {
            return -1; //se non se realiza con éxito
        }
    }

}//fin class
