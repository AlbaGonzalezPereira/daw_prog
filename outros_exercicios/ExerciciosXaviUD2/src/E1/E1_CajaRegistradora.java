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
public class E1_CajaRegistradora {
    static final double IVA=0.15;
    
    public static void main(String[] args) {
        System.out.println("Ticket de Caja");
        String producto;
        Double precio;
        double total=0;
        double iva;
        
        producto=InputUtils.leeString("Producto: ");
        while(producto!=null) {
            precio=InputUtils.leeReal("Precio: ");
            if (precio!=null) {
                total=total+precio;
                producto=InputUtils.leeString("Producto: ");
            } else producto=null;
        }
        iva=total*IVA;
        System.out.printf("Total: %.4f\n"+total);
        System.out.printf("IVA: %.4f\n", iva);
        System.out.printf("Importe a Pagar: %.4f\n", (total+iva));
    }
    
}
