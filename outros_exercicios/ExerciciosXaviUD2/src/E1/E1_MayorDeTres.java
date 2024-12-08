/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package E1;

import utils.InputUtils;

/**
 *
 * @author xavi
 */
public class E1_MayorDeTres {
    public static void main(String[] args) {
        int a;
        int b;
        int c;
       
        do {
            System.out.println("Introduce tres valores distintos");
            a=InputUtils.leeInt("Valor A: ");
            b=InputUtils.leeInt("Valor B: ");
            c=InputUtils.leeInt("Valor C: ");
        } while ((a==b) || (a==c) || (c==b));
    
        if (a>b) {
            if (a>c) System.out.println("O maior é "+a);
            else System.out.println("O maior é "+c);
        } else {
            if (b>c) System.out.println("O maior é "+b);
            else System.out.println("O maior é "+c);
        }
    }
}
