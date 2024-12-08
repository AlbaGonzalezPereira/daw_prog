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
public class E1_Hipotenusa {
    public static void main(String[] args) {
        double cat1;
        double cat2;
        double hipotenusa;
        
        cat1=InputUtils.leeReal("Medida de cateto 1: ");
        cat2=InputUtils.leeReal("Medida de cateto 2: ");
        hipotenusa=Math.sqrt(cat1*cat1+cat2*cat1);
        System.out.printf("A hipotenusa é de %.4f\n",hipotenusa);
    }
    
}
