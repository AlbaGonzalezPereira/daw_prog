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
public class E1_MayordeDos {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a;
        int b;
       
        do {
            System.out.println("Introduce dous valores distintos");
            a=InputUtils.leeInt("Valor A: ");
            b=InputUtils.leeInt("valor B: ");
        } while(a==b);
        if (a>b) System.out.println("O maior é "+a);
        else System.out.println("O maior é "+b);
    }
    
}
