package com.iesrodeira.utils;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Clase con métodos estáticos
 *
 * @author alba_
 */
public class InputUtils {
    //método accesible desde calquera parte

    /**
     * Visualiza title e espera a entrada dun String na mesma liña
     *
     * @param title
     * @return
     */
    public static String leeString(String title) {
        System.out.println(title + " ou prema * para cancelar");
        Scanner sc = new Scanner(System.in);
        String titulo = sc.nextLine();
        if (titulo.equals("*")) {
            return null; //devolve null se poñemos *
        }
        return titulo; //devolve o título

    }//fin leeString

    //método leeReal
    /**
     * Visualiza title e espera a entrada dun String na mesma liña que se
     * transformará nun double e se retornará
     *
     * @param title
     * @return
     */
    public static Double leeReal(String title) {
        System.out.println(title + " ou prema * para cancelar");
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        //String cadena=leeString(title);
        double cadenadou = Double.parseDouble(cadena);
        if (cadena.equals("*")) {
            return null;
        }
        return cadenadou;

    }//fin leeReal(String title)

    /**
     * Visualiza title e espera a entrada dun String na mesma liña, que se
     * transformará nun double que ten que estar comprendido entre min e max
     *
     * @param title
     * @param min
     * @param max
     * @return
     */
    public static Double leeReal(String title, double min, double max) {
        String cadena2;
        double cadenad;
        Scanner sc;
        do {
            System.out.println(title + " ou prema * para cancelar");
            sc = new Scanner(System.in);
            cadena2 = sc.nextLine();
            cadenad = Double.parseDouble(cadena2);
            if (cadena2.equals("*")) {
                return null;
            }
        } while (min > cadenad || cadenad > max);

        return cadenad;
    }//fin leeReal(String title, double min, double max)

    /**
     * Visualiza title e espera a entrada dun String na mesma liña e se
     * transformará nun obxecto Date que se retornará
     *
     * @param title
     * @return
     */
    public static Date leeData(String title) {
        System.out.println(title + " ou prema * para cancelar");
        Scanner sc = new Scanner(System.in);
        String cadenaData = sc.nextLine();
        if (cadenaData.equals("*")) {
            return null;
        }
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = dateFormat.parse(cadenaData);
            return date;
        } catch (Exception e) {
            //System.out.println(e); se quixeramos visualizar a excepción
        }
        return null;

    }//fin leeData

    /**
     * Visualiza as opcións nunha liña separada por comas
     *
     * @param opcions
     * @param choosers
     * @return
     */
    public static int opcionElixeOpcion(String[] opcions, char[] choosers) {
        int lonxitude, indexEncontrado;
        Scanner sc;
        char Op;
        do {
            lonxitude = opcions.length;
            for (int i = 0; i < lonxitude; i++) {
                //visualizamos todo nunha liña separada por comas
                System.out.print(choosers[i] + " " + opcions[i] + ", ");
            }
            System.out.println("Elixe a opción: \n");
            sc = new Scanner(System.in);
            Op = sc.nextLine().charAt(0);
            indexEncontrado = -1;
            for (int i = 0; i < choosers.length; i++) {
                if (Op == choosers[i]) {
                    indexEncontrado = i;
                }
            }
        } while (indexEncontrado == -1);
        return indexEncontrado+1;

    } //fin opcionElixeOpcion(String[] opcions, char[] choosers)

    /**
     * método para imprimir guións
     *
     * @param nchars
     */
    private static void printLine(int nchars) {
        //Scanner sc = new Scanner(System.in);
        for (int i = 0; i < nchars; i++) {
            System.out.print("-");
        }
           System.out.println();
    } //fin printLine

    /**
     * Visualizará o título suliñado cunha liña de guións
     *
     * @param title
     * @param opcions
     * @param choosers
     * @return
     */
    public static int opcionElixeOpcion(String title, String[] opcions, char[] choosers) {
        System.out.println(title);
        printLine(title.length());
        //mesmo exercicio que o anterior
        int lonxitude, indexEncontrado;
        Scanner sc;
        char Op;
        do {
            lonxitude = opcions.length;
            for (int i = 0; i < lonxitude; i++) {
                //visualizamos todo nunha liña separada por comas
                System.out.println(choosers[i] + " " + opcions[i] + ", ");
            }
            System.out.println("Elixe a opción: \n");
            sc = new Scanner(System.in);
            Op = sc.nextLine().charAt(0);
            indexEncontrado = -1;
            for (int i = 0; i < choosers.length; i++) {
                if (Op == choosers[i]) {
                    indexEncontrado = i;
                }
            }
        } while (indexEncontrado == -1);
        return indexEncontrado+1;

    }//fin opcionElixeOpcion(String title, String[] opcions, char[] choosers)
    
    public static boolean contarCaracteres(String codigo){
        if (codigo.length()!=12){
            System.out.println("O codigo é incorrecto");
            return false;
        }
        
        return true;
    }

}
