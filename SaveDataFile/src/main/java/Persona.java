
import java.io.Serializable;

/**
 * Clase serializable
 * @author alba_
 */
public class Persona implements Serializable{
    private String dni;
    private String nome;

    public Persona(String dni, String nome) {
        this.dni = dni;
        this.nome = nome;
    }

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

    @Override
    public String toString() {
        return "dni=" + dni + ", nome=" + nome;
    }
    
    
    
    
}
