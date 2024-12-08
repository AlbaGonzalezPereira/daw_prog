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
public class Ecuacion {
    private final double a;
    private final double b;
    private final double c;
    
    public Ecuacion(double a,double b,double c) {
        this.a=a;
        this.b=b;
        this.c=c;
    }
    
    @Override
    public String toString() {
        return String.format("%.04fx²+%.04fx+%.04f=0",a,b,c);
    }
    
    Double[] resolve() {
        double raiz;
        Double[] resultado=null;
        
        if (a==0.0) {
            if (b!=0.0) {
                resultado=new Double[1];
                resultado[0]=-c / b;
            }
        } else {
            raiz=b*b-4*a*c;
            if (raiz >= 0.0) {
                resultado=new Double[2];
                raiz=Math.sqrt(raiz);
                resultado[0]=(-b+raiz)/(2*a);
                resultado[1]=(-b-raiz)/(2*a);
            }
        }
        return resultado;
    }
    
    
    public static void main(String[] args) {
        Double a,b,c;
        Double[] solucions;
        Ecuacion ecuacion;
        
        System.out.println("Solución de ecuacións da forma Ax²+Bx+C = 0");
        a=InputUtils.leeReal("Introduce valor de A: ");
        if (a!=null) {
            b=InputUtils.leeReal("Introduce valor de B: ");
            if (b!=null) {
                c=InputUtils.leeReal("Introduce valor de C: ");
                ecuacion=new Ecuacion(a,b,c);
                solucions=ecuacion.resolve();
                if (solucions!=null) {
                    System.out.println("A ecuación "+ecuacion+" ten "+solucions.length+" solucións");
                    for(int idx=1;idx<=solucions.length;idx++) {
                        System.out.printf("Solución %d: %.6f\n",idx,solucions[idx]);
                    }
                } else System.out.println("A ecuación "+ecuacion+" non ten solucións reais");
            }
        }
    }
}
