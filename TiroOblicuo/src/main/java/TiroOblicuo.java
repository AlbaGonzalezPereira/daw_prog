
import java.util.Scanner;

/**
 *
 * @author alba_
 */

public class TiroOblicuo {
    
    public static void main(String[] args) {
        
        //primer caso
        Scanner sc = new Scanner(System.in);
        int velocidade, angulo, calcula;
        double anguloRad, cos, sen, tempo, alcance; 
        double alcance2,velocidadeInicial, seno, angulo2Rad, angulo2;
        double G = 9.80665; //9.80665 m/s2        
       
        do{
        System.out.println("Selecciona 1 se queres calcular o alcance ou 2 se queres calcular o ángulo: ");
        calcula= sc.nextInt();
              
            if (calcula == 1){
                System.out.println("Introduce a velocidade: ");
                velocidade = sc.nextInt();
                System.out.println("Introduce o ángulo de disparo: ");
                angulo = sc.nextInt();
                anguloRad = (angulo * Math.PI)/180;
                cos = Math.cos(anguloRad);
                sen = Math.sin(anguloRad);
                tempo = (2*velocidade*sen)/G; //tempo=2*velocidade*sen(angulo)/g
                alcance = velocidade + tempo * cos; //alcance=velocidade+tempo * cos(angulo)
                System.out.println("Impacto a " + alcance + " metros en " + tempo + " segundos");
        
            }else if(calcula == 2){
                System.out.println("Introduce o alcance: ");
                alcance2 = sc.nextDouble(); //alcance=velocidade^2*sen(2*angulo)/g
                System.out.println("Introduce a velocidade inicial: ");
                velocidadeInicial = sc.nextDouble();
                seno=(alcance2 *G / Math.pow(velocidadeInicial, 2)) / 2; //seno =(alcance_desexado*g / velocidade^2) / 2
                angulo2Rad = Math.asin(seno);
                angulo2 = angulo2Rad * 180 / Math.PI;
                System.out.println("angulo2Rad = " + angulo2Rad);
                System.out.println("angulo2 = " + angulo2);
            }
        
        }while (calcula != 2 && calcula !=1);
    }
        
}
