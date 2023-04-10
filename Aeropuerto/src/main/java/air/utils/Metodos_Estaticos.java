package air.utils;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author alba_
 */
public class Metodos_Estaticos {

    public static Scanner sc = new Scanner(System.in);

    /**
     * método que devuelve la cadena introducida o null si escribe "*"
     *
     * @param titulo
     * @return - cadena (String)
     */
    public static String leeString(String titulo) {
        System.out.println("Introduce " + titulo + ":");
        String cadena = sc.nextLine();
        if (!cadena.equals("*") && cadena.length() > 0) {
            return cadena;
        } else {
            return null;
        }
    }

    /**
     * método que lee un String y devuelve un float
     *
     * @param titulo
     * @return - txt (float)
     */
    public static Float leeFloat(String titulo) {
        String texto = leeString(titulo);
        float txt;
        if (texto != null) {
            txt = Float.parseFloat(texto);
            return txt;
        }
        return null;
    }

    /**
     * lee un String y devuelve un entero
     *
     * @param titulo
     * @return - txt2 (int)
     */
    public static Integer leeEntero(String titulo) {
        String texto2 = leeString(titulo);
        int txt2;
        if (texto2 != null) {
            txt2 = Integer.parseInt(texto2);
            return txt2;
        }
        return null;

    }

    /**
     * método que descompone un nombre y devuelve nombre y apellidos
     *
     * @param nombre
     * @return - array nomApel
     */
    public static String[] descomponerNombre(String nombre) {
        //declarar array de 4 elementos String[] nomApel = new String[4];
        String[] nomApel = nombre.split(" ");
        return nomApel;
    }

    /**
     * devuelve verdadero o falso si el código tiene 4 números
     *
     * @param codigo
     * @return
     */
    public static boolean validarCodigo(String codigo) {
        if (codigo.matches("[0-9]{4}")) {
            return true;
        }
        return false;
    }

    public static int queMes(Date fecha) {
        int mes = fecha.getMonth();
        return mes;
    }
    
    /**
     * devuelve una nota aleatoria entre 1 y 10
     * @return - int notaExamen
     */
    public static int notaExamen(){
    int notaExamen=(int)Math.floor(Math.random()) + 1;
    return notaExamen;
    }
}
