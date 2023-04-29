
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que vai visualizar as liñas conde se atopa unha palabra ou frase introducida
 * @author alba_
 */
public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File ficheiro = new File("cadenas.txt"); //permite realizar operacións como verificar se existe un arquivo ou directorio, obter propiedades, eliminalo, crealo.
        try ( PrintWriter escribir = new PrintWriter(ficheiro)) {
            //PrintWriter nos permiten dar formato a conversión en texto da información que queremos escribir no Stream
            ficheiro.createNewFile();//se non existe o crea
            System.out.println("Introduce as frases do ficheiro (enter para rematar): ");
            String fr;
            do {
                fr = sc.nextLine();
                escribir.println(fr);//garda as liñas introducidas no ficheiro
            } while (!fr.equals(""));

        } catch (IOException ex) {//en caso de erro
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Introduzca la palabra o palabras a buscar: ");
        String frase = sc.nextLine();
        ArrayList<String> lineasDev = new ArrayList<>();
        lineasDev = devolverLineas(frase, ficheiro);
        System.out.println(lineasDev);
    }

    /**
     * método que nos vai devolver as liñas e o seu contido
     *
     * @param frase
     * @return
     */
    public static ArrayList<String> devolverLineas(String frase, File f) {
        ArrayList<String> lineas = new ArrayList<>();
        int numFila = 1; //para que parta do número 1, que é onde comezan as liñas
        //ao ser autocloseable métese nun try with resources
        try ( BufferedReader bufReader = new BufferedReader(new FileReader(f))) {
            //aquí facemos o programa
            String linea = bufReader.readLine();
            while (linea != null) { //mentras lineas sexa diferente de null
                if (linea.contains(frase)) {//se lee a frase
                    lineas.add("Fila " + numFila + ":" + linea);
                }
                numFila++;
                linea = bufReader.readLine();//para que lea a seguinte liña
            }

        } catch (FileNotFoundException ex) { //se non atopa o arquivo erro:
            System.out.println("O arquivo non existe" + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lineas; //devolve o arraylist de líneas, estea baleiro ou non
    }

}
