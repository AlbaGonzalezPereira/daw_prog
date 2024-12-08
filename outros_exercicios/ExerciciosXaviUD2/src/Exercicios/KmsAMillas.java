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
public class KmsAMillas {
    static double FACTOR_KMSMILLAS=0.621371;
    
    public static void main(String[] args) {
        Integer kms=InputUtils.leeInt("Número de Kms: ");
        if (kms!=null) {
            System.out.printf("%d Kms son %.4f millas\n",kms,kms*FACTOR_KMSMILLAS);
        }
    }
}
