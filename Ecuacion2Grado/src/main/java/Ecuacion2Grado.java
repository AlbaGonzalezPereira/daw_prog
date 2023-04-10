
import java.util.Scanner;


/**
 *
 * @author alba_
 */

// programa que solicite os valores dos coeficientes reais a, b e c dunha ecuación 
//de segundo grao e visualice as solucións, indicando en caso de que a solución non 
//exista "Non ten solucións".

//O programa debe funcionar correctamente sexan cales sexan os valores de entrada para os coeficientes

public class Ecuacion2Grado {
    //método main, principal, el que ejecuta
    public static void main(String[] args) {
        //ecuación segundo grado es a2 + b + c = 0
        System.out.println("--- Ecuacións de segundo grado ---");
        
//solicitamos os números pola consola
        System.out.println("Introduce tres números reais:");
        System.out.println("Introduce a: ");
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        System.out.println("Introduce b: ");
        double b = sc.nextDouble();
        System.out.println("Introduce c: ");
        double c = sc.nextDouble();//x2+3x+2=0
        double i;
        double sol1, sol2; //posibles solucións, que poden ser decimais
        i=Math.pow(b,2) - (4*a*c);
        //System.out.println("i = " + i);
       
        //poñemos as condicións para resolver a ecuación
        if(i<0)
            System.out.println("Non ten solucións");
        else if (a!=0){
            sol1=(-b+Math.sqrt(i))/(2*a);
            sol2=(-b-Math.sqrt(i))/(2*a);
            System.out.println("As solucións posibles son: " + sol1 + " e " + sol2);
            //System.out.println("sol2 = " + sol2);
        }else{
            sol1=(-b/c);
            System.out.println("A única solución é: " + sol1);
        }
        
    }
    
}
