
/**
 *
 * @author alba_
 */
public class Factorial {

    public static void main(String[] args) {
        //Escribir un programa que solicite un número enteiro e visualice o factorial dese número
        // declaramos un número enteiro e inicializamos o factorial a 1
        int enteiro = 11;
        int factorial = 1;
        
        //imprimimos para que saque o texto que queremos antes do bucle porque así enteiro non está modificado
        System.out.print("o factoriais de " + enteiro + " é ");

        //facemos un bucle para que calcule todos os números que inclúe un factorial
        while (enteiro > 0) {
            factorial = factorial * enteiro; //11*10*9*8*7*6*5*4*3*2*1
            enteiro--;
        }
        
        //imprimos o factorial
        System.out.println(factorial);

    }

}
