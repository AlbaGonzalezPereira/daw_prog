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
public class E1_Nominas {
    static final int NUM_OBREROS=50;
    static final int PRECIO_HORA=30000;
    
    public static void main(String[] args) {
        int total=0;
        Integer horas;
        
        System.out.println("IMPORTE DE LA NOMINA");
        for(int i=0;i<NUM_OBREROS;i++) {
            int subtotal;
            
            horas=InputUtils.leeInt("Horas Trabajadas: ");
            if (horas==null) System.exit(0);
            subtotal=horas*PRECIO_HORA;
            System.out.println("Salario: "+subtotal);
            total=total+subtotal;
        }
        System.out.println("Importe total de las nóminas: "+total);
    }
}
