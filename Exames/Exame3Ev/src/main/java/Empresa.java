

import java.util.Objects;

public class Empresa implements Comparable<Empresa> {
    private final String cif;
    private String nome;
    private String razonsocial;
    
    public Empresa(String cif, String nome, String razonsocial) {
        this.cif = cif;
        this.nome = nome;
        this.razonsocial = razonsocial;
    }
    
    public String getCif() {
        return cif;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.cif);
        return hash;
    }

    // Son iguais si coincide o seu cif
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
        final Empresa other = (Empresa) obj;
        if (!Objects.equals(this.cif, other.cif)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empresa{" + "cif=" + cif + ", nome=" + nome + ", razonsocial=" + razonsocial + '}';
    }

    // Se comparan polo nome
    @Override
    public int compareTo(Empresa t) {
        return nome.compareTo(t.nome);
    }
}
