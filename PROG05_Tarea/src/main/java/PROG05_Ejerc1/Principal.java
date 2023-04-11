package PROG05_Ejerc1;

import static PROG05_Ejerc1_util.Metodos_Estaticos.validar;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

/**
 * Clase principal onde se executa o programa
 * @author alba_
 */
public class Principal {
/**
 * Función para ver se un vehículo está creado
 * @param v1 --> é o vehículo novo
 * @return 
 */
    private static boolean existirVehiculo(Vehiculo v1) {
        if (Objects.isNull(v1)) { //v1==null
            System.out.println("\n O vehículo aínda non está creado \n");
            return false;
        }
        return true;
    }
    
    /**
     * Metódo main principal, onde se executan todo o programa
     * @param args 
     */

    public static void main(String[] args) {
        /**
         * Clase Scanner para solicitar os datos por teclado
         */
        Scanner sc = new Scanner(System.in);
        /* Probando o dni
        System.out.println("Introduce o dni do propietario do vehículo sen espazos: ");
                String dni=sc.nextLine();
                if(validar(dni))
                    System.out.println("DNI CORRECTO");
                else
                    System.out.println("incorrecto");
         */
        
        //declaramos as variables que imos usar
        int opcion, kms, dia, mes, ano;
        boolean inputError;
        String marca, matricula, dni, desc, prop;
        LocalDate data;
        float prezo;
        Vehiculo v1 = null;
        
        // Creamos un bucle para visualizar as opcións do menú
        do {
            System.out.println("1.Novo Vehículo");
            System.out.println("2.Ver Matrícula");
            System.out.println("3.Ver Número de Kilómetros");
            System.out.println("4.Actualizar Kilómetros");
            System.out.println("5.Ver anos de antigüedade");
            System.out.println("6.Amosar propietario");
            System.out.println("7.Amosar descripción");
            System.out.println("8.Amosar Prezo");
            System.out.println("9.Saír ");
            System.out.println("Introduce o número da opción que desexe, segundo o que queira visualizar: ");
            opcion = Integer.parseInt(sc.nextLine());
            
            // seleccionamos a opción desexada do menú, dependendo do valor introducido
            switch (opcion) {
                case 1:
                    
                    System.out.println("\nIntroduce a marca do vehículo:");
                    marca = sc.nextLine();
                    System.out.println("\nIntroduce a matrícula do vehículo:");
                    matricula = sc.nextLine();
                    System.out.println("\nIntroduce os kms do vehículo:");
                    kms = Integer.parseInt(sc.nextLine());
                    System.out.println("\nIntroduce a data do vehículo ");
                    System.out.println("Introduce o día: ");
                    dia = Integer.parseInt(sc.nextLine());
                    System.out.println("Introduce o mes: ");
                    mes = Integer.parseInt(sc.nextLine());
                    System.out.println("Introduce ano:");
                    ano = Integer.parseInt(sc.nextLine());
                    data = LocalDate.of(ano, mes, dia);
                    System.out.println("\nIntroduce unha descrición do vehículo: ");
                    desc = sc.nextLine();
                    System.out.println("\nIntroduce o prezo do vehículo: ");
                    prezo = Float.parseFloat(sc.nextLine());
                    System.out.println("\nIntroduce o nome do propietario do vehículo: ");
                    prop = sc.nextLine();
                    
                    //Mentras o dni non sexa correcto, pedirá introducir novamente
                    do {
                        System.out.println("\nIntroduce o dni do propietario do vehículo sen espazos:");
                        dni = sc.nextLine();
                        inputError = false;
                        try {
                            validar(dni);
                        } catch (Exception e) {
                            System.out.println(e);
                            inputError = true;
                        }
                    } while (inputError == true);
                    
                    //creamos o obxecto v1 con todos os parámetros introducidos
                    v1 = new Vehiculo(marca, matricula, kms, data, desc, prezo, prop, dni);
                    System.out.println("\n Vehículo introducido correctamente \n");
                    break;
                    
                //se o v1 existe amosará a matrícula    
                case 2:
                    if (existirVehiculo(v1)) {
                        System.out.print("A matrícula do vehículo é " + v1.getMatricula() + "\n");
                    }
                    break;
                //se o v1 existe amosará os kms
                case 3:
                    if (existirVehiculo(v1)) {
                        System.out.print("Os kms do vehículo son " + v1.getKm() + "\n");
                    }
                    break;
                
                //se o v1 existe e queremos actualizar os kms nos pedirá introducir o novo parámetro
                case 4:
                    if (existirVehiculo(v1)) {
                        System.out.println("\nIntroduce os kms actuais do vehículo: ");
                        kms = Integer.parseInt(sc.nextLine());
                        v1.setKm(kms); //modificxamos os km co método set
                        System.out.print("Os kms actualizados son " + v1.getKm() + "\n");
                    }
                    break;
                
                //se o v1 existe amosará os anos de antigüedade
                case 5:
                    if (existirVehiculo(v1)) {
                        System.out.print("Os anos de antigüedade do vehículo son " + v1.get_Anios() + "\n");
                    }
                    break;

                //se o v1 existe amosará o propietario
                case 6:
                    if (existirVehiculo(v1)) {
                        System.out.print("O propietario do vehículo é " + v1.getNome_prop() + "\n");
                    }
                    break;

                //se o v1 existe amosará a súa descrición
                case 7:
                    if (existirVehiculo(v1)) {
                        System.out.print("A descrición do vehículo é " + v1.getDescricion() + "\n");
                    }
                    break;

                //se o v1 existe amosará o prezo en float
                case 8:
                    if (existirVehiculo(v1)) {
                        System.out.print("O prezo do vehículo é " + v1.getPrezo() + "€\n");
                    }
                    break;

                //sairá do programa
                case 9:
                    break;

            }
        } while (opcion != 9);
    }

    

}
