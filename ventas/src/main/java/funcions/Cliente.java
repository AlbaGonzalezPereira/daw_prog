package funcions;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author alba_
 */
public class Cliente implements Comparable<Cliente> {
    //declaramos atributos que non se podan instanciar fora do package
    //engadimos final xa que o dni, nome e apelidos non deben ser modificables unha vez establecido o seu valor no construtor
    private final String dni;
    private final String nome;
    private final String apelidos;
    private String direccion;
    private String telefono;
    private LocalDate data_nacem;
    private String localidade;
    private String email;
    private int cp;

    /**
     * método construtor único dun cliente recibe o dni, o nome e os apelidos
     * @param dni
     * @param nome
     * @param apelidos 
     */
    Cliente(String dni, String nome, String apelidos) {
        this.dni = dni;
        this.nome = nome;
        this.apelidos = apelidos;
    }

    /**
     * engadimos getter e setter correspondentes
     * @return 
     */
    public String getDni() {
        return dni;
    }

    public String getNome() {
        return nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public LocalDate getData_nacem() {
        return data_nacem;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getEmail() {
        return email;
    }

    public int getCp() {
        return cp;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setData_nacem(LocalDate data_nacem) {
        this.data_nacem = data_nacem;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    /**
     * sobreescribimos o método toString() para que o método faga a 
     * representación como String dun cliente será apelidos, nome (dni)
     * @return 
     */
    @Override
    public String toString() {
        return apelidos + ", " + nome + "(" + dni + ")";
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
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.dni, other.dni);
    }

    
    @Override
    public int compareTo(Cliente o) {
        //redefinimos o método
//        if (this.apelidos.equals(o.getApelidos()) && this.nome.equals(o.getNome())) {
//            if (this.dni.equals(o.getDni())) {
//                return 0;
//            } else if (this.dni.compareTo(o.getDni()) > 0) {
//                return 1;
//            } else {
//                return -1;
//            }
//
//        } else if (this.apelidos.equals(o.getApelidos()) && !this.nome.equals(o.getNome())) {
//            if (this.nome.compareTo(o.getNome()) > 0) {
//                return 1;
//            }
//            return -1;
//
//        } else {
//            if (this.apelidos.compareTo(o.getApelidos()) > 0) {
//                return 1;
//            }
//
//        }
//        return -1;
if (o==null) return 1;
        return (apelidos+", "+nome).compareTo(o.apelidos+", "+o.nome);
    }
}
