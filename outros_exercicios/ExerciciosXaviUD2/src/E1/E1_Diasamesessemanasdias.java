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
public class E1_Diasamesessemanasdias {
    public static void main(String[] args) {
        int anos=0;
        int meses=0;
        int semanas=0;
        Integer dias=0;
        
        dias=InputUtils.leeInt("Total Dias: ");
        if (dias!=null) {
            while(dias >= 365) {
                anos++;
                dias-=365;
            }
            while(dias >= 30) {
                meses++;
                dias-=30;
            }
            while(dias >= 7) {
                semanas++;
                dias-=7;
            }
            System.out.println(anos+" Anos, "+meses+" Meses, "+semanas+" Semanas e "+dias+" días");
        }
    }
}
