/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicios;

import utils.InputUtils;

/**
 *
 * @author xavi
 */
public class Multiplicacion {
        
    static int signo(int n1,int n2) {
        if (((n1<0) && (n2>0)) || ((n1>0) && (n2<0))) return -1;
        return 1;
    }
    
    
    static int multiplica(int n1, int n2) {
        int resultado=0;
        int signo=signo(n1,n2);
        
        n1=Math.abs(n1);
        n2=Math.abs(n2);
        
        while(n2>0) {
            resultado=resultado+n1;
            n2--;
        }
        return resultado*signo;
    }
    
    public static void main(String[] args) {
        Integer n1,n2;
                
        n1=InputUtils.leeInt("Numero 1: ");
        if (n1!=null) {
            n2=InputUtils.leeInt("Numero 2: ");
            if (n2!=null) {
                System.out.println(n1+"*"+n2+"="+multiplica(n1,n2));
            }
        }
    } 
}
