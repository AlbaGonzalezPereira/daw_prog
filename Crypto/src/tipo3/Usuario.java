/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipo3;

import java.util.Objects;

/**
 *
 * @author xavi
 */
public class Usuario implements Comparable<Usuario> {

    private final String dni;
    private String nome;
    private int idade;

    /**
     * método a partir dun String vai crear un usuario
     *
     * @param line
     * @return - Usuario
     * @throws Exception - cando hai un erro
     */
    public static Usuario fromString(String line) throws Exception {
        String[] campos = line.split(",");
        return new Usuario(campos[0], campos[1], Integer.parseInt(campos[2]));
    }

    public Usuario(String dni, String nome, int idade) {
        this.dni = dni;
        this.nome = nome;
        this.idade = idade;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Usuario{" + "dni=" + dni + ", nome=" + nome + ", idade=" + idade + '}';
    }

    //O Usuario é comparable por DNI
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.dni);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.dni, other.dni);
    }

    //comparamos os Usuarios por dni:
    @Override
    public int compareTo(Usuario otroUsuario) {
        return this.dni.compareTo(otroUsuario.getDni());
    }

}
