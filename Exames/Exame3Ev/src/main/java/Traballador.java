/**
 * Clase traballador, que corresponde coa táboa traballadores
 */

import java.util.Objects;

public class Traballador implements Comparable<Traballador> {
    private final String dni;
    private String nome;
    private String apelidos;
    private String cif;

    public Traballador(String dni, String nome, String apelidos) {
        this.dni = dni;
        this.nome = nome;
        this.apelidos = apelidos;
    }

    public String getDni() {
        return dni;
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

    public String getEmpresa() {
        return cif;
    }
 
    public void setEmpresa(String cif) {
        this.cif=cif;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    // Son iguais si coincide o seu dni
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
        final Traballador other = (Traballador) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Traballador{" + "dni=" + dni + ", nome=" + nome + ", apelidos=" + apelidos + '}';
    }

    // Se comparan por apelidos e nome
    @Override
    public int compareTo(Traballador t) {
        String fullname =apelidos + " " + nome;
        return fullname.compareTo(t.getApelidos()+" "+t.getNome());
    }

}
