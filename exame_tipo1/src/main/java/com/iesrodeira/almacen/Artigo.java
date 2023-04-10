package com.iesrodeira.almacen;

/**
 *Clase pai
 * @author alba_
 */
public class Artigo {
    private String codigo;
    private String denominacion;
    private String descricion;
    private double prezo;

    /**
     * constructor cos parámetros
     * @param codigo
     * @param denominacion
     * @param descricion
     * @param prezo 
     */
    public Artigo(String codigo, String denominacion, String descricion, double prezo) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.descricion = descricion;
        this.prezo = prezo;
       
    }

  
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public double getPrezo() {
        return prezo;
    }

    public void setPrezo(float prezo) {
        this.prezo = prezo;
    }

    @Override
    public String toString() {
        return "Artigo{" + "codigo=" + codigo + ", denominacion=" + denominacion + ", descricion=" + descricion;
    }
    
    
    
    
}
