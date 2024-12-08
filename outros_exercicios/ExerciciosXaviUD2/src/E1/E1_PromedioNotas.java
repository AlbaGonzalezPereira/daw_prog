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
public class E1_PromedioNotas {
    public static void main(String[] args) {
        int total=0;
        int num=0;
        Integer nota;
        
        nota=InputUtils.leeInt("Introduce Nota: ",0,10);
        while(nota!=null) {
            total=total+nota;
            num=num+1;
            nota=InputUtils.leeInt("Introduce Nota: ",0,10);
        }
        System.out.println("El promedio de notas es "+((double)total)/num);
    }
}
