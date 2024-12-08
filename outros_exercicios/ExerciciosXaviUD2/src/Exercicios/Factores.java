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
public class Factores {
    public static void main(String[] args) {
        Integer num;
        int factor;
        
        num=InputUtils.leeInt("Numero: ");
        if (num!=null) {
            if (num<1) System.out.println("Debe ser maior que 1");
            else {
                System.out.print("Os factores de "+num+" son ");
                factor=2;
                while(num > 1) {
                    while (num%factor==0) {
                        System.out.print(factor+" ");
                        num=num/factor;
                    }
                    factor++;
                }
                System.out.println();
            }
        }
        
    }
}
