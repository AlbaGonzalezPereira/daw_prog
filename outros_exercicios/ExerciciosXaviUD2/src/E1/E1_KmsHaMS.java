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
public class E1_KmsHaMS {
    public static void main(String[] args) {
        Integer kmsh=InputUtils.leeInt("Introduce velocidad en Kms/h: ");
        if (kmsh!=null) {
            System.out.println(kmsh+" kms/h son "+(kmsh*1000.0)/3600.0+" m/sg");
        }
    }
    
}
