package implementacion;

/**
 * Clase que nos permite xestionar usuarios
 * @author alba_
 */

import java.util.Scanner;

/**
 *
 * @author alba
 */
public class XestionUsuario {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * método que crea un usuario se non existe ou o modifica se existira
     * @param u
     * @return 
     */
     public static Usuario crearModificarUsuario(Usuario u) {
        String dni=null,nome=null;
        Integer idade=null;
        String input;
        String dnom="",didade="";
        if (u!=null) {
            dni=u.getDni();
            nome=u.getNome();
            idade=u.getIdade();
            dnom=" ["+nome+"] ";
            didade=" ["+idade+"] ";
        }

        if (dni==null) {
            dni=getDni();//chama ao método
            //if(dni==null) return null;//MODIFICACION
        } else System.out.println("Modificouse o usuario con dni " + dni);
        
        System.out.println("Nome (* para cancelar) :" + dnom);
        input = scanner.nextLine();
        if (input.startsWith("*")) return null;
        if (input.length() > 0) nome=input; 

        System.out.println("Idade (* para cancelar):"+didade);
        input = scanner.nextLine();
        if (input.startsWith("*")) return null;
        if (input.length() > 0) idade=Integer.valueOf(input); 
        if (dni==null || nome==null || idade==null) return null;
        Usuario usu = new Usuario(dni, nome, idade);
        return usu;
    }
       
    static String getDni() {
        System.out.println("Introduce o DNI do usuario (* para cancelar) :");
        String dni = scanner.nextLine();
        if (dni.startsWith("*")) return null;//se empeza por "*"
        return dni;
    }    
}
