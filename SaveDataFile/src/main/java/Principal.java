
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alba_
 */
public class Principal {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Persona> personas = new ArrayList<>();

    public static void main(String[] args) {
        //declaramos las variables File
        File archivo = new File("datos.txt");
        File archivo2 = new File("datos2.txt");
        File archivo3 = new File("personas.dat");
        
        //creamos el archivo personas.dat
        try {
            if (!archivo3.exists())//si no existe
            {
                archivo3.createNewFile();//lo crea
            }
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        //para que lea el archivo al inicio del programa 
        try ( ObjectInputStream inicio = new ObjectInputStream(new FileInputStream(archivo3));) {
            personas = (ArrayList<Persona>) inicio.readObject();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //1. Lee cada una de las lineas con stream y visualiza por pantalla.
        //2. Lee cada una de las lineas y escribelas en otro fichero datos2.txt.
        try ( BufferedReader ler = new BufferedReader(new FileReader(archivo));  PrintWriter escribir = new PrintWriter(archivo2);) {
            ArrayList<String> lineas = new ArrayList<>();
            String linea = ler.readLine();//lee la línea de datos.txt
            while (linea != null) {
                lineas.add(linea); //añade las líneas al arrayList
                linea = ler.readLine();
            }

            for (String linea1 : lineas) {
                System.out.println(linea1);
                escribir.print(linea1 + "\n");//escribe en el archivo datos2.txt
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("");
        int opc;
        do {
            System.out.println("******MENÚ******");
            System.out.println("""
                               1. Introducir persona
                               2. Visualizar personas
                               3. Salir
                               """);

            System.out.println("Elige una opcion");
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    introducirPersona();
                    break;
                case 2:
                    visualizarPersona();
                    break;
                case 3:
                    volcarDatos(archivo3);
                    break;
                default:
            }
        } while (opc <= 2);
    }

    /**
     * método que vuelca los datos al salir del programa en personas.dat
     * @param archivo3 
     */
    private static void volcarDatos(File archivo3) {
        try ( ObjectOutputStream volcado = new ObjectOutputStream(new FileOutputStream(archivo3));) {
            volcado.writeObject(personas);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * método que nos introduce una persona en el arraylist
     */
    private static void introducirPersona() {
        System.out.println("Introduzca el dni: ");
        String dni = sc.nextLine();
        System.out.println("Introduzca el nombre: ");
        String nome = sc.nextLine();
        Persona p = new Persona(dni, nome);
        personas.add(p);
    }

    /**
     * método que nos visualiza las personas que hay en el arraylist
     */
    private static void visualizarPersona() {
        for (Persona persona : personas) {
            System.out.println(persona);
        }
        System.out.println("");
    }
}
