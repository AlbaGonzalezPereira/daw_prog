## ENUNCIADO TAREFA02-PROG

### TAREFA 1

**Exercicio 1**. Realización de multiplicacións mediante sumas (so números enteiros).
```java
import java.util.Scanner;
public class multiplicacion {
    public static void main (String[] args){
        int num1;
        int num2;
	    int resultado=0;
 
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce o primeiro numero");
        num1=sc.nextInt();
 
        System.out.println("Introduce o segundo numero");
        num2=sc.nextInt();
 
        while (num2>0){
            resultado=resultado + num1;
	        num2=num2-1;
        }
	System.out.println(resultado);
    } 
}
```

**Exercicio 2**. Indicar si o usuario é maior ou menor de idade (a idade non pode ter decimais).
```java
import java.util.Scanner;
public class idade {
    public static void main (String[] args){
        String nome;
        int idade;
	 
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce o teu nome");
        nome=sc.nextLine();
 
        System.out.println("Ola" + nome + ", introduce a tua idade");
        idade=sc.nextInt();
 
        if (idade>=18){
            System.out.println("Vaia" + nome + ", es maior de idade");
	        num2=num2-1;
        }else{
            System.out.println(nome + " aínda es menor de idade");
        }	
    }
}
```
**Exercicio 3**. Indica si un número é primo ( o número debe ser enteiro ).
```java
import java.util.Scanner;
public class numPrimo {
    public static void main (String[] args){
        int num;
	    int conta;
	 
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero maior que 0:");
        num=sc.nextInt();
 
        if (num==1){
            System.out.println("1 é numero primo");
        }else{
            conta = 2;
	    
        while(num%conta!=0){
		    conta++;
        }

	    if (conta!=num){
		    System.out.println(num + "NON é primo");
        }else{
		    System.out.println(num + "É primo");
	    }	
    } 
}
```

### TAREFA 2
**Exercicio 1**. Escribir un programa Java que nos indique si un número é par ou impar.
```java
import java.util.Scanner;

public class ParImpar{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int num = 0;

        System.out.println("Introduce un numero: ");
        num = sc.nextInt();

        if ((num % 2) == 0){
            System.out.println(num + " e par");
        }else{
            System.out.println(num + " e impar");
        }
     }
}
```

**Exercicio 2**. Escribir un programa Java que pida un número de Kms e nos visualice o seu valor en millas.

```java
import java.util.Scanner;

public class ConverterKmMillas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double km;
        double millas;
       
            System.out.print("Introduce a distancia en kilometros para convertela en millas: ");
            km = sc.nextDouble();

            if (km != 0) {
                millas = km/1.6093;
                System.out.printf(km + " son " + millas + " millas");                      
            }
	}  
}
```

**Exercicio 3**.Escribir un programa Java que realice unha división enteira de dous números enteiros empregando restas.

```java
import java.util.Scanner;

public class divisionConRestas {

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int dividendo = 0;
        int divisor = 0;
        int cocente = 0;
          
        System.out.print("Introduce o numero que queres dividir: ");
        dividendo = sc.nextInt();

        System.out.print("Agora introduce o divisor: ");
        divisor = sc.nextInt();
		   
		while (dividendo >0) {
				cocente++;
				dividendo = dividendo-divisor;		
		} 
		System.out.print("O resultado da division é: " + cocente);           
    }
}
```

**Exercicio 4**. Escribir un programa Java que visualice os factores primos dun número.
```java
import java.util.Scanner;

public class FactoresPrimos {
    public static void main (String [ ] args) {
	  int num;
	  int fact = 2;
      Scanner sc = new Scanner(System.in);
      System.out.println("Imos sacar os factores primos do numero introducido");
	  System.out.println("Introduce o numero (enteiro) que desexes: ");
      num = sc.nextInt();
	  System.out.println("Os factores primos de " + num + "son:");
	  
	  while(num != 1){
		if(num % fact ==0){
			System.out.print(fact + " ");
			num = num /fact;
		}else{
			fact = fact + 1;
		}
	  }
    }  //fin main       
}//fin class
```

**Exercicio 5**. Escribir un programa Java que solicite dous números enteiros e visualice o resultado do
primeiro número elevado ao segundo utilizando multiplicacións.
```java
import java.util.Scanner;

public class ElevadoConMultipl {

       public static void main(String args[]) {
           Scanner sc=new Scanner(System.in);
           int b = 1;
           int p = 0;
          
           System.out.print("Introduce o numero que queres elevar: ");
           b = sc.nextInt();

           System.out.print("Introduce a potencia: ");
           p = sc.nextInt();

           System.out.print(b + " elevado a " + p + " é igual a " + Math.pow(base,pot));
       }
}
```

**Exercicio 6**. Escribir un programa Java que pida un número enteiro e visualice o seu factorial.

```java
import java.util.Scanner;

public class Factorial {
     public static void main (String [ ] args) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Imos sacar o factorial do numero introducido");
	      System.out.println("Introduce o numero (enteiro) que desexes: ");
          int num = sc.nextInt();
          double factorial = 1;
     
      	  while (n!=0) {
  		        factorial=factorial*num;
  		        num--;
	      }
	  
	      System.out.println("O factorial do numero " + num + "é " + fatorial);
     }
}
```

**Exercicio 7**. Escribir un programa Java que visualice na pantalla o número de términos da serie de Fibonacci
queindique o usuario. A serie de Fibonacci ten a seguinte forma: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55,
89, ...

```java
import java.util.Scanner;

public class Fibo {

  public static void main(String[] args) {
  
	Scanner sc=new Scanner(System.in);
    System.out.println("Imos mostrar a serie de Fibonacci do numero dado");
    
	int n = 0;
	int n2=1;
	int fi = 0;
	int sfib = 1;
		    
	System.out.print("Introduce o primeiro numero: ");
    n = sc.nextInt();
		   
	for(int i = 1; i <=n && ((n2 + fi) <=n); i++) {
            sfib = fi;
	    fi = n2 + fi;
	    n2 = sfib;
	    System.out.println(fi);
	}           
  }
}
```