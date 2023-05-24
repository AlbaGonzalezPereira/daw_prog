package database;

import db.DB;
import implementacion.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Clase que traballa coa base de datos
 *
 * @author alba_
 */
public class UsuarioDAO implements Storage {

    /**
     * método que devolve un usuario se existe cun dni dado
     * @param dni -key
     * @return - usuario
     * @throws Exception 
     */
    @Override
    public Usuario get(String dni) throws Exception {
        String consulta = "Select * from usuarios where dni = ?";
        Connection con = DB.getConnection();//obtenemos a conexión
        Usuario usu = null;
        try ( PreparedStatement stmt = con.prepareStatement(consulta);) {
            //agregamos os valores:
            stmt.setString(1, dni); //engadimos o primeiro value
            ResultSet resultado = stmt.executeQuery(); //executamos e recollemos os datos na variable resultado
            if (resultado.next()) {
                usu = new Usuario(dni, resultado.getString(2), resultado.getInt(3));
                //podemos coller o nome dos campos da base de datos
                //Usuario usu = new Usuario(dni,resultado.getString("nome"),resultado.getInt("idade");
            }
        }
        return usu; //devolve usuario
    }

    /**
     * método que inserta un usuario á táboa usuarios
     * @param user
     * @throws Exception 
     */
    @Override
    public void insert(Usuario user) throws Exception {
        String consulta = "INSERT INTO usuarios(dni,nome,idade) VALUES(?,?,?);";
        Connection con = DB.getConnection();//obtenemos a conexión    
        try (PreparedStatement stmt = con.prepareStatement(consulta);) {
            //agregamos os valores:
            stmt.setString(1, user.getDni()); //engadimos o primeiro value
            stmt.setString(2, user.getNome());//engadimos o segundo value
            stmt.setInt(3, user.getIdade());//engadimos o terceiro value
            stmt.executeUpdate(); //executamos
        } 
    }

    /**
     * método que actualiza un usuario
     * @param user
     * @throws Exception 
     */
    @Override
    public void update(Usuario user) throws Exception {
        String consulta = "UPDATE usuarios SET nome = ?, idade = ? WHERE dni = ?;";
        Connection con = DB.getConnection();//obtenemos a conexión 
        int modificado = 0;
        try(PreparedStatement stmt = con.prepareStatement(consulta);) {
            stmt.setString(1,user.getNome()); //poñemos o primeiro valor na consulta
            stmt.setInt(2,user.getIdade());//poñemos o segundo valor na consulta
            stmt.setString(3,user.getDni());
            modificado = stmt.executeUpdate(); // recollemos o número de modificacions 
            if(modificado > 0)
                System.out.println("O usuario modificouse correctamente");
            else
                System.out.println("O usuario non se modificou");
        } 
    }

    /**
     * método que elimina un usuario dado un dni
     * @param dni - key
     * @throws Exception 
     */
    @Override
    public void delete(String dni) throws Exception {
        String consulta = "DELETE FROM usuarios WHERE dni = ?";//consulta sql
        Connection con = DB.getConnection();//obtenemos a conexión 
        int eliminados = 0;
        try(PreparedStatement stmt = con.prepareStatement(consulta);) {
            //agregamos os valores:
            stmt.setString(1,dni); //engadimos o value
            eliminados = stmt.executeUpdate(); // recollemos o número de eliminados   
            //comprobamos o número de eliminados
            if(eliminados > 0)
                System.out.println("O usuario eliminouse correctamente"); //se se eliminou algún dato
            else
                System.out.println("Non se pudo eliminar o usuario");
        }    
    }
    
    /**
     * método que devolve todos os usuarios da táboa usuarios
     * @return
     * @throws Exception 
     */
    public Usuario[] getAll() throws Exception{     
        String consulta = "Select * from usuarios";
        Connection con = DB.getConnection();//obtenemos a conexión
        Usuario usu = null;
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try ( PreparedStatement stmt = con.prepareStatement(consulta);) {
            //agregamos os valores:
            ResultSet resultado = stmt.executeQuery(); //executamos e recollemos os datos na variable resultado
            while (resultado.next()) {
                usu = new Usuario(resultado.getString(1), resultado.getString(2), resultado.getInt(3));
                usuarios.add(usu);
                //podemos coller o nome dos campos da base de datos
                //Usuario usu = new Usuario(dni,resultado.getString("nome"),resultado.getInt("idade");
            }
        }
        return usuarios.toArray(new Usuario[0]);//convertemos o arraylist a array
    }

}
