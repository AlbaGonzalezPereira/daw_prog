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
public class NumeroE {
    static int factorial(int num) {
        int r=1;
        while(num>1) {
            r=r*num;
            num--;
        }
        return r;
    }
    
    static double numeroEv1(int precision) {
        int factorial=1;
        double e=1;
        for(int p=1;p<=precision;p++) {
            factorial=factorial*p;
            e=e+1.0/factorial;
        }
        return e;
    }
    
    static double numeroE(int precision) {
        double e=0;
        for(int p=0;p<precision;p++) e=e+1.0/factorial(p);
        return e;
    }
    
    public static void main(String[] args) {
        Integer precision;
        
        precision=InputUtils.leeInt("Precision", 0, 12);
        System.out.printf("O valor de e é %.12f  (%.12f)\n",numeroE(precision),numeroEv1(precision));
    }
}
