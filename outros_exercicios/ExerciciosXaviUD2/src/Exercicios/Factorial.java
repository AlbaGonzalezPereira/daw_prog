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
public class Factorial {
   
    static int factorial(int num) {
        int r=1;
        while(num>1) {
            r=r*num;
            num--;
        }
        return r;
    }
    
    public static void main(String[] args) {
        Integer num;
        
        num=InputUtils.leeInt("Numero: ",0,12);  // Non caben resultados maiores a 12! nun int
        if (num!=null) System.out.println(num+"! = "+factorial(num));
    }
}
