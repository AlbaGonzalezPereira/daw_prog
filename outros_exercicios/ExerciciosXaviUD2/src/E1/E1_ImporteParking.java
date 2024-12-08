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
public class E1_ImporteParking {
    
    static int calculaImporte(Integer horaentrada, Integer horasalida) {
        int diferencia=horasalida-horaentrada;
        int horas=(diferencia/100)-1;
        int resto=diferencia%100;
        if (resto!=0) horas++;
        
        return 1000+600*horas;
    }
    
    
    
    public static void main(String[] args) {
        Integer horaentrada=null;
        Integer horasalida=null;
    
        do {
            horaentrada=InputUtils.leeInt("Hora de Entrada en fromato militar: ",0,2399);
            if (horaentrada!=null) {
                if (horaentrada%100 >59) {
                    System.out.println("Hora errónea");
                    horaentrada=2400;
                }
                else {
                    horasalida=InputUtils.leeInt("Hora de Salida en formato militar: ",0,2399);
                    if (horasalida%100 > 59) {
                        System.out.println("Hora errónea");
                        horaentrada=2400;
                    }
                }
            }
        } while ((horaentrada!=null) && (horasalida!=null) && (horaentrada>=horasalida));
        if ((horaentrada!=null) && (horasalida!=null))
            System.out.println("O importe a pagar é de "+calculaImporte(horaentrada,horasalida));
    }
}
