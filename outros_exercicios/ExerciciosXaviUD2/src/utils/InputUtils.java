/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author xavi
 */
public class InputUtils {
    private static Scanner scn;
    
    public static final double PI=3.1415926;

    
    public static String leeString(String title) {
        String line;
        if (scn==null) scn=new Scanner(System.in);
        
        System.out.print(title+" (* para cancelar) ");
        line=scn.nextLine();
        if (line.charAt(0)=='*') return null;
        return line;
    }
    
    public static Integer leeInt(String title) {
        String line=leeString(title);
        if (line!=null) return Integer.parseInt(line);
        return null;
    }

    public static Integer leeInt(String title,int min,int max) {
        int num;
        
        do {
            String line=leeString(title);
            if (line==null) return null;
            num=Integer.parseInt(line);
        } while(num<min || num>max);
        return num;
    }
    
    public static Double leeReal(String title) {
        String line=leeString(title);
        if (line!=null) return Double.parseDouble(line);
        return null;
    }
    
    public static int leeOpcion(String opciones,String selectores) {
        int idx;
        if (scn==null) scn=new Scanner(System.in);

        do {
            System.out.print(opciones);
            String line=scn.nextLine();
            idx=posicion(line.charAt(0),selectores);
        } while(idx<0);
        return idx;
    }
    
    private static int posicion(char letra,String posibles) {
        int pos=-1;
        int len=posibles.length();
        int idx=0;
        
        posibles=posibles.toUpperCase();
        letra=Character.toUpperCase(letra);
        
        while ((idx<len) && posibles.charAt(idx)!=letra) idx++;
        if (idx<len) pos=idx;
        return pos;
    }
}
