//importamos clase Scanner para solicitar o número por pantalla

import java.util.Scanner;

/**
 *
 * @author alba_
 */

/*
Escribir un programa que calcule e visualice o valor do número e cunha precisión n 
indicada por teclado mediante a serie de Newton: e=1 + 1/1! + 1/2! + 1/3! + ... + 1/n! 
PD: Resulta de moita axuda definir unha función que reciba un número enteiro e 
devolva o seu factorial

 */
public class NumeroE {

    //creamos unha función co factorial que xa tiñamos do exercicio anterior
    public static long fact(int a) {
        int enteiro = a;
        long factorial = 1;

        //imprimimos para que saque o texto que queremos antes do bucle porque así enteiro non está modificado
        //System.out.print("o factoriais de " + enteiro + " é ");
        //facemos un bucle para que calcule todos os números que inclúe un factorial
        while (enteiro > 0) {
            factorial = factorial * enteiro;
            enteiro--;
        }
        return factorial;
    }

    ;
    
    public static void main(String[] args) {
        //O número e é unha constante, canta máis longa é a serie, máis precisión ten
        // e = 1 + 1/1 + 1/(1*2) + 1/(1*2*3) ....
        //1! --> factorial de 1
        //0! = 1 --> factorial de 0 é 1

        // declaramos o número e que vai ser un double xa que leva decimais 
        double e = 0;
        System.out.println("Introduce o número de fraccións da serie de Newton: ");
        Scanner sc = new Scanner(System.in);
        //será la precisión de fracciones
        int n = sc.nextInt();

        //hacemos un bucle para calcular el número de fracciones de la serie
        for (int i = 0; i < n; i++) {
            e = e + (1.0 / (fact(i)));
        }
        System.out.println(e);

    }

}
