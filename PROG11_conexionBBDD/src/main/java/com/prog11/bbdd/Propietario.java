package com.prog11.bbdd;

/**
 *
 * @author alba_
 */
public class Propietario {
    //insertamos os datos que aparecen na táboa propietarios:
    private int id_prop;
    private String nombre_prop;
    private String dni_prop;

    //insertamos os constructores
    /**
     * constructor de dous argumentos onde non insertamos o id_prop poprque é 
     * autonumérico e non é un dato propio do obxecto Propietario, senón da base de datos
     * @param nombre_prop
     * @param dni_prop 
     */
    public Propietario(String nombre_prop, String dni_prop) {
        this.nombre_prop = nombre_prop;
        this.dni_prop = dni_prop;
    }

    public Propietario(int id_prop, String nombre_prop, String dni_prop) {
        this.id_prop = id_prop;
        this.nombre_prop = nombre_prop;
        this.dni_prop = dni_prop;
    }
    
    //insertamos getter e setter:
    public int getId_prop() {
        return id_prop;
    }

    public void setId_prop(int id_prop) {
        this.id_prop = id_prop;
    }

    public String getNombre_prop() {
        return nombre_prop;
    }

    public void setNombre_prop(String nombre_prop) {
        this.nombre_prop = nombre_prop;
    }

    public String getDni_prop() {
        return dni_prop;
    }

    public void setDni_prop(String dni_prop) {
        this.dni_prop = dni_prop;
    }
    
    //insertamos o método toString():
    @Override
    public String toString() {
        return "id_prop=" + id_prop + ", nombre_prop=" + nombre_prop + ", dni_prop=" + dni_prop;
    }

}
