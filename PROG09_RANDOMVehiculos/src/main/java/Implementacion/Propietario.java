package Implementacion;

/**
 * Clase que conterá o propietario dos vehículos
 * @author alba_
 */
public class Propietario {
   private String dni,nome,apelidos;

   //insertamos constructor
    public Propietario(String dni, String nome, String apelidos) {
        this.dni = dni;
        this.nome = nome;
        this.apelidos = apelidos;
    }
   
   //insertamos getter e setter:
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    //insertamos método toString()
    @Override
    public String toString() {
        return "Propietario: " + "dni=" + dni + ", nome=" + nome + ", apelidos=" + apelidos;
    }
   
}
