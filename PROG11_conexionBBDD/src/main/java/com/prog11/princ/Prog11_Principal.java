package com.prog11.princ;

import com.prog11.bbdd.Propietario;
import com.prog11.bbdd.PropietariosDAO;
import com.prog11.bbdd.Vehiculo;
import com.prog11.bbdd.VehiculosDAO;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * clase Principal de la aplicación
 * @author alba_
 */
public class Prog11_Principal {
    static Scanner sc = new Scanner(System.in);
    static int opcion;
    public static void main(String[] args) {
        //Insertar varios vehículos y propietarios.
        System.out.println("Insertando dos propietarios ...");
        Propietario prop1 = new Propietario("Pepe Pérez", "08876543S");
        Propietario prop2 = new Propietario("María Gutiérrez", "33333444R");
        Propietario prop3 = new Propietario("Yago García", "12345678Y");
        Propietario prop4 = new Propietario("Miguel Yánez", "98789871L");
        if (PropietariosDAO.insertarPropietario(prop1) == -1) {
            System.out.println("Error al insertar Propietario");
        }

        if (PropietariosDAO.insertarPropietario(prop2) == -1) {
            System.out.println("Error al insertar Propietario");
        }
        
        if (PropietariosDAO.insertarPropietario(prop3) == -1) {
            System.out.println("Error al insertar Propietario");
        }
        
        if (PropietariosDAO.insertarPropietario(prop4) == -1) {
            System.out.println("Error al insertar Propietario");
        }

        System.out.println("Insertando varios vehículos ...");
        Vehiculo v1 = new Vehiculo("1111DBJ", "Fiat", 100000, 10000, "Fiat Stilo 115D",PropietariosDAO.getId("08876543S"));
        Vehiculo v2 = new Vehiculo("3333KKJ", "Seat", 130000, 15000, "Seat León FR",PropietariosDAO.getId("33333444R"));
        Vehiculo v3 = new Vehiculo("3234KMD", "Seat", 9000, 25000, "Seat Ibiza",PropietariosDAO.getId("98789871L"));
        if (VehiculosDAO.insertarVehiculo(v1) == -1) {
            System.out.println("Error al insertar Vehículo");
        }

        if (VehiculosDAO.insertarVehiculo(v2) == -1) {
            System.out.println("Error al insertar Vehículo");
        }
        
        if (VehiculosDAO.insertarVehiculo(v3) == -1) {
            System.out.println("Error al insertar Vehículo");
        }
        //Listar todos los vehículos.
        ArrayList<String> vehiculos = VehiculosDAO.recuperarVehiculos();
        for (String vehiculo : vehiculos) {
            System.out.println(vehiculo);    
        }
        
        //Actualizar propietario de un vehículo.
        VehiculosDAO.actualizarPropVehiculo("1234ABC", PropietariosDAO.getId("08876543S"));
        
        //Listar todos los vehículos.
        vehiculos = VehiculosDAO.recuperarVehiculos();
        for (String vehiculo : vehiculos) {
            System.out.println(vehiculo);    
        }
        
        //Eliminar un vehículo que exista.
        if(VehiculosDAO.eliminarVehiculo("1234ABC")==0)
            System.out.println("Vehículo eliminado correctamente");
        else
            System.out.println("Non se eliminou o vehículo");
        
        //Eliminar un vehículo que no exista.
        if(VehiculosDAO.eliminarVehiculo("1234ABC")==0)//xa non está
            System.out.println("Vehículo eliminado correctamente");
        else
            System.out.println("Non se pudo eliminar o vehículo");
        
        //Listar todos los vehículos.
        vehiculos = VehiculosDAO.recuperarVehiculos();
        for (String vehiculo : vehiculos) {
            System.out.println(vehiculo);    
        }
        //Listar los vehículos de una marca.
        vehiculos = VehiculosDAO.recuperarVehiculos("Seat");
        for (String vehiculo : vehiculos) {
            System.out.println(vehiculo);    
        }
        
        //Listar todos los vehículos de un propietario.
        vehiculos = PropietariosDAO.recuperarVehiculos("33333444R");
        for (String vehiculo : vehiculos) {
            System.out.println(vehiculo);    
        }
        
        //Eliminar un propietario con vehículos.
        vehiculos = PropietariosDAO.recuperarVehiculos("98789871L");
            if (vehiculos.size() > 0){
                PropietariosDAO.eliminaPropietario("98789871L");
                System.out.println("Propietario con vehiculo eliminado correctamente");
            }
        //Eliminar un propietario sin vehículos.  
        vehiculos = PropietariosDAO.recuperarVehiculos("12345678Y");
            if (vehiculos.size() == 0){
                PropietariosDAO.eliminaPropietario("12345678Y");
                System.out.println("Propietario sen vehiculo eliminado correctamente");
            }
    }//fin main
        
}//fin class
