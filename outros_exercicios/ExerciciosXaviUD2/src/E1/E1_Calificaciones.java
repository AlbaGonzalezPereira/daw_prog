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
public class E1_Calificaciones {
    static char charNota(int nota) {
        char charnota;
        switch(nota) {
            case 19: case 20:               charnota='A'; break;
            case 16: case 17: case 18:      charnota='B'; break;
            case 13: case 14: case 15:      charnota='C'; break;
            case 10: case 11: case 12:      charnota='D'; break;
            default:                        charnota='E'; break;
        }
        return charnota;
    }
    
    public static void main(String[] args) {
        Integer nota;
        
        nota=InputUtils.leeInt("Introduce Nota: ",1,20);
        while (nota!=null) {
            System.out.println("A nota é "+charNota(nota));
            nota=InputUtils.leeInt("Introduce Nota: ",1,20);
        }
    }
}
