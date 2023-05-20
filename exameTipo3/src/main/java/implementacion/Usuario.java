package implementacion;

/**
 *
 * @author alba_
 */
public class Usuario {
    private String dni;
    private String nome;
    private int idade;

    //constructor
    public Usuario(String dni, String nome, int idade) {
        this.dni = dni;
        this.nome = nome;
        this.idade = idade;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    //insertamos método toString:
    @Override
    public String toString() {
        return "Usuario: " + "dni=" + dni + ", nome=" + nome + ", idade=" + idade;
    }
    
    
}
