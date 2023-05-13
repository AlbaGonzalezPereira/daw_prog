package Implementacion;

/**
 *
 * @author alba_
 */
public class Vehiculo {
    //declaramos os atributos:
    private String matricula,marca,modelo,propietario;
    
    //insertamos o constructor con 4 argumentos:
    public Vehiculo(String matricula, String marca, String modelo, String propietario) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = propietario;
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

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    //insertamos método toString()
    @Override
    public String toString() {
        return "Vehiculo: " + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", propietario=" + propietario;
    }
   
}
