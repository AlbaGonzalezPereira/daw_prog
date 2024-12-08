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
public class E1_EPrimo {
    /**
     * O 0 e o 1 non son primos.
     * @param n
     * @return 
     */
    public static boolean ePrimo(int n) {
        int idx=n-1;
        while(n%idx!=0) idx--;
        return (idx==1);
    }
    
    public static void main(String[] args) {
        int num;
        num=InputUtils.leeInt("Introduce un número: ");
        if (num<=0) System.out.println("O número debe ser positivo");
        else        System.out.println("O número "+num+(ePrimo(num)?" é primo ":" non é primo"));
    }
}
