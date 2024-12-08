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
public class E1_ParImpar {
    public static void main(String[] args) {
        int num;
        
        num=InputUtils.leeInt("Introduce un número: ");
        System.out.println("O número "+num+" e "+(num%2==0?"par":"impar"));
    }
}
