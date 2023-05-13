package Implementacion;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author alba_
 */
public class Vehiculo {
    //declaramos os atributos:
    private String matricula,marca,modelo;
    private Propietario propietario;
    
    //insertamos o constructor con 3 argumentos:
    public Vehiculo(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = null;
    }

    //insertamos getter e setter
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
    
    //insertamos o método equals e hashCode para comparar dous vehículos por matrícula
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.matricula);
        return hash;
    }
 
    @Override    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.matricula, other.matricula);
    }

    //insertamos método toString()
    @Override
    public String toString() {
        return "Vehiculo: " + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", propietario=" + propietario;
    }
   
}
