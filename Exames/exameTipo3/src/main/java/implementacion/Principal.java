package implementacion;

import database.IndexedStorageUsuario;
import database.UsuarioDAO;
import db.DB;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal
 *
 * @author alba_
 */
public class Principal {

    private static Scanner sc = new Scanner(System.in);
    private static IndexedStorageUsuario isu = new IndexedStorageUsuario("resultados.txt");//para xestionar o ficheiro resultados.txt mediante un index
    private static UsuarioDAO usuDb = new UsuarioDAO();
    
    public static void main(String[] args) {
        // asignamos el nombre del fichero si no está creado lo crea con la función privada createFile();
        File archivo = new File("datos.txt");
        ArrayList<String> lineas = lerLineas(archivo);//recollemos as liñas lidas
        escribirLineas(lineas);
        //System.out.println(XestionUsuario.crearModificarUsuario(null));
        File indice = new File("resultados.idx"); //creamos o dicheiro resultados.idx
        indice.delete();//borramos o ficheiro

        int op;
        do {
            System.out.println("Elixe unha opción: ");
            System.out.println("1. Traballar con RandomAccessFile\n"
                                + "2. Traballar con base de datos\n");
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1:
                    crearMenuRAS();
                    break;
                
                case 2:
                    //collemos os datos para poder realizar a conexión
                    DB.URL = "jdbc:mariadb://localhost/mi_bd?allowPublicKeyRetrieval=true&useSSL=false";
                    DB.USER = "root";
                    DB.PASS = "";
                    try ( DB db = DB.open()) {//abrimos a conexión              
                        crearMenuDB();//creamos o menú
                    } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;

                case 3:
                    //saír
                    break;
            }
        } while (op > 0 && op <= 3);

    }//fin main

    /**
     * método que nos crea un menú que nos vai permitir a inserción, borrado /
     * actualización dun usuario específico e a eliminación dun usuario polo seu
     * dni.
     *
     * @throws AssertionError
     * @throws NumberFormatException
     */
    private static void crearMenuRAS() {
        int opcion;
        do { //facemos o menú:           
            System.out.println("1.- Dar de alta un usuario \n"
                    + "2.- Dar de baixa un usuario\n"
                    + "3.- Modificar un usuario\n"
                    + "4.- Buscar un usuario\n"
                    + "5.- Listar todos os usuarios\n"
                    + "6.- Saír");
            System.out.println("Elixe unha opción: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    darAltaUsuarioRAS();
                    break;
                case 2:
                    darBaixaUsuarioRAS();
                    break;
                case 3:
                    modificarUsuarioRAS();
                    break;
                case 4:
                    buscarUsuarioRAS();
                    break;
                case 5:
                    listarUsuariosRAS();
                    break;
                case 6:
                    //saír
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcion != 6);
    }

    private static void crearMenuDB() {
        int opcion;
        do { //facemos o menú:           
            System.out.println("1.- Dar de alta un usuario \n"
                    + "2.- Dar de baixa un usuario\n"
                    + "3.- Modificar un usuario\n"
                    + "4.- Buscar un usuario\n"
                    + "5.- Listar todos os usuarios\n"
                    + "6.- Importar ficheiro datos.txt\n"
                    + "7.- Saír\n");
            System.out.println("Elixe unha opción: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    darAltaUsuarioDB();
                    break;
                case 2:
                    darBaixaUsuarioDB();
                    break;
                case 3:
                    modificarUsuarioDB();
                    break;
                case 4:
                    buscarUsuarioDB();
                    break;
                case 5:
                    listarUsuariosDB();
                    break;
                 case 6:
                    importar();
                    break;
                case 7:
                    //saír
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcion != 7);

    }

    
     /************************métodos menú RAS**********************************/
    /**
     * método que vai escribir as liñas dun arquivo noutro diferente, neste
     * caso, do arquivo datos.txt en resultados.txt
     *
     * @param lineas
     */
    private static void escribirLineas(ArrayList<String> lineas) {
        try ( PrintWriter escribir = new PrintWriter(new File("resultados.txt"))) {//abrimos un writer de escritura
            for (String linea : lineas) {//recorremos o array
//                if(lineas.size()-1==lineas.indexOf(linea))
//                    escribir.print(linea);//para que non nos poña o último "\n"
//                else

                escribir.write(linea + "\n"); //escribimos o arquivo  
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * método que vai ler as liñas dun arquivo, neste caso datos.txt
     *
     * @param archivo
     * @return
     */
    private static ArrayList<String> lerLineas(File archivo) {
        ArrayList<String> rexistros = new ArrayList<>();//creamos un arraylist de liñas
        try ( BufferedReader ler = new BufferedReader(new FileReader(archivo))) {//abrimos un buffer de lectura 
            String rexistro = ler.readLine();//lemos a liña
            while (rexistro != null) {
                rexistros.add(rexistro);//engadimos a liña ao arraylist
                rexistro = ler.readLine();//lemos a liña
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rexistros;
    }

    /**
     * método que da de alta un usuario ao ser o dni==null
     */
    private static void darAltaUsuarioRAS() {
        try {
            Usuario u = XestionUsuario.crearModificarUsuario(null);//recollemos os datos na variable "u"
            if (u != null) {
                isu.insert(u);//inseramos usuario
            }
        } catch (Exception ex) {
            System.out.println("Erro ao dar de alta\n" + ex.getMessage());
        }
    }

    /**
     * método que nos permite dar de baixa un usuario cando pasamos o dni
     */
    private static void darBaixaUsuarioRAS() {
        try {
            String dni = XestionUsuario.getDni();//obtemos o dni
            if (dni != null) {
                isu.delete(dni);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao dar de baixa\n" + ex.getMessage());
        }
    }

    /**
     * método que modifica un usuario con dni
     */
    private static void modificarUsuarioRAS() {
        String dni = XestionUsuario.getDni();//obtemos o dni
        if (dni != null) {
            try {
                Usuario usuMod = isu.get(dni);//obtemos o usuario a través do dni
                usuMod = XestionUsuario.crearModificarUsuario(usuMod);//modificamos o usuario a través dese método
                isu.update(usuMod);//actualizamos o usuario
                System.out.println("usuario modificado correctamente");
            } catch (Exception ex) {
                System.out.println("Erro ao modificar o usuario\n" + ex.getMessage());
            }
        }
    }

    /**
     * método que busca un usuario por dni
     */
    private static void buscarUsuarioRAS() {
        String dni = XestionUsuario.getDni();
        if (dni != null) {
            Usuario usuBus = null;
            try {
                usuBus = isu.get(dni);
                if (usuBus != null) {
                    System.out.println("O usuario con " + dni + " atopado é " + usuBus);
                }
            } catch (Exception ex) {
                System.out.println("Erro ao buscar o usuario\n" + ex.getMessage());
            }

        }
    }

    private static void listarUsuariosRAS() {
        Usuario[] usuarios = isu.getAll();
        for (Usuario usuario : usuarios) {
            if (!usuario.getDni().startsWith("*")) {
                System.out.println(usuario);
            }
        }
    }
    
    
    /*************************métodos menú DB***********************************/

    /**
     * método que da de alta un usuarioDB
     */
    private static void darAltaUsuarioDB() {
        try {
            Usuario u = XestionUsuario.crearModificarUsuario(null);//recollemos os datos na variable "u"
            if (u != null) {
                usuDb.insert(u);//inseramos usuario
            }
        } catch (Exception ex) {
            System.out.println("Erro ao dar de alta\n" + ex.getMessage());
        }   
    }

    /**
     * método que da de baixa un usuario da base de datos
     */
    private static void darBaixaUsuarioDB() {
         try {
            String dni = XestionUsuario.getDni();//obtemos o dni
            if (dni != null) {
                usuDb.delete(dni);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao dar de baixa\n" + ex.getMessage());
        }
    }

    /**
     * método que modifica un usuario da base de datos
     */
    private static void modificarUsuarioDB() {
        String dni = XestionUsuario.getDni();//obtemos o dni
        if (dni != null) {
            try {
                Usuario usuMod = usuDb.get(dni);//obtemos o usuario a través do dni
                usuMod = XestionUsuario.crearModificarUsuario(usuMod);//modificamos o usuario a través dese método
                usuDb.update(usuMod);//actualizamos o usuario
                System.out.println("usuario modificado correctamente");
            } catch (Exception ex) {
                System.out.println("Erro ao modificar o usuario\n" + ex.getMessage());
            }
        }
    }

    private static void buscarUsuarioDB() {
        String dni = XestionUsuario.getDni();
        if (dni != null) {
            Usuario usuBus = null;
            try {
                usuBus = usuDb.get(dni);
                if (usuBus != null) {
                    System.out.println("O usuario con " + dni + " atopado é " + usuBus);
                }
            } catch (Exception ex) {
                System.out.println("Erro ao buscar o usuario\n" + ex.getMessage());
            }
        }
    }

    /**
     * método que lista todos os usuarios da base de datos
     */
    private static void listarUsuariosDB() {
        try {
            Usuario[] usuarios = usuDb.getAll();
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao listar os usuarios" + ex.getMessage());
        }
    }

    /**
     * método que importa os datos do ficheiro datos.txt á base de datos
     */
    private static void importar() {
        try(BufferedReader buf = new BufferedReader(new FileReader("datos.txt"))) {//para ler datos do ficheiro datos.txt
            String rexistro = buf.readLine();
            String[] rexistros;
            while(rexistro!=null){
                rexistros= rexistro.split(",");
                usuDb.insert(new Usuario(rexistros[0],rexistros[1], Integer.parseInt(rexistros[2])));  
                rexistro = buf.readLine();
            }
            System.out.println("importouse correctamente o ficheiro");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    

}//fin class
