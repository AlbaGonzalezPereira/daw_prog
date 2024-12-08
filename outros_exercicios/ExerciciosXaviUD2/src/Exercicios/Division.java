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
public class Division {
    
    static int signo(int n1,int n2) {
        if (((n1<0) && (n2>0)) || ((n1>0) && (n2<0))) return -1;
        return 1;
    }
    
    
    static int divide(int dividendo, int divisor) {
        int cociente=0;
        int s=signo(dividendo,divisor);
        
        dividendo=Math.abs(dividendo);
        divisor=(divisor<0)?-divisor:divisor;  // Sin usar Math.abs
        
        while(dividendo>=divisor) {
            dividendo-=divisor;
            cociente++;
        }
        return cociente*s;
    }
    
    public static void main(String[] args) {
        Integer dividendo;
        Integer divisor;
        
        dividendo=InputUtils.leeInt("Dividendo: ");
        if (dividendo!=null) {
            divisor=InputUtils.leeInt("Divisor: ");
            if (divisor!=null) {
                if (divisor==0) System.out.println("No se puede dividir entre 0");
                else            System.out.println(dividendo+"/"+divisor+"="+divide(dividendo,divisor));
            }
        }
    }
}
