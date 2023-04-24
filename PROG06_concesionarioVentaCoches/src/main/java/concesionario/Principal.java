package concesionario;

import java.time.LocalDate;
import java.util.Scanner;
import static metodos.Validar.*;

/**
 *
 * @author alba_
 */
public class Principal {
    //opción mellorada poñendo Concesionario neste lugar, así xa non é necesario
    //pasalo por parámetro
    private static Concesionario concesionario = new Concesionario();
    //tamén poderiamos poñer Scanner sc e así non hai que declaralo
    //private static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        //Concesionario concesionario = new Concesionario();
        Scanner sc;
        do {
            System.out.println("Elixe a opción que desexes");
            System.out.println("1. Novo Vehículo \n"
                    + "2. Listar Vehículos \n"
                    + "3. Buscar Vehículo \n"
                    + "4. Modificar kms Vehículo \n"
                    + "5. Saír");
            sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    //crearNuevoV(concesionario);
                    crearNuevoV();
                    break;
                case 2:
                    //listarV(concesionario);
                    listarV();
                    break;
                case 3:
                    //buscarV(concesionario);
                    buscarV();
                    break;
                case 4:
                    //modificarV(concesionario);
                    modificarV();
                    break;
                case 5:
                    break;

            }
        } while (opcion != 5);

    }

    /**
     * método que crea un novo vehículo
     *
     * @param concesionario
     */
    private static void crearNuevoV(/*Concesionario concesionario*/) {
        String marca, matricula, descricion, nome_prop, dni_prop;
        int km, dia, mes, ano;
        LocalDate fecha;
        float prezo;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Introduza a marca do vehículo: ");

            marca = sc.nextLine();
        } while (marca.equals(""));

        do {
            System.out.println("Introduza a matrícula: ");

            matricula = sc.nextLine();
        } while (validarMatricula(matricula) == false);

        do {
            System.out.println("Introduzca a descrición do vehículo: ");

            descricion = sc.nextLine();
        } while (descricion.equals(""));

        do {
            System.out.println("Introduza o nome do propietari@: ");
            nome_prop = sc.nextLine();
        } while (validarDatosProp(nome_prop) == false);

        do {
            System.out.println("Introduza o dni do propietari@: ");
            dni_prop = sc.nextLine().toUpperCase();
        } while (validarDNI(dni_prop) == false);

        do {
            System.out.println("Introduza os kms do vehículo: ");
            km = sc.nextInt();
        } while (km < 0);

        do {
            System.out.println("Introduza o día de matriculación: ");
            dia = sc.nextInt();
        } while (dia < 1 || dia > 31);
        do {
            System.out.println("Introduza o mes de matriculación: ");
            mes = sc.nextInt();
        } while (mes < 1 || mes > 12);
        do {
            System.out.println("Introduza o ano de matriculación: ");
            ano = sc.nextInt();
        } while (ano < 1900);
        fecha = LocalDate.of(ano, mes, dia);
        do {
            System.out.println("Introduza o prezo: ");
            prezo = sc.nextFloat();
        } while (prezo < 0);
        Vehiculo veh = new Vehiculo(marca, matricula, km, fecha, descricion, prezo, nome_prop, dni_prop);
        concesionario.insertarVehiculo(veh);
    }

    /**
     * método que lista os vehículos, usando o método listaVehiculos xa na Clase
     * Validar
     *
     * @param concesionario
     */
    private static void listarV(/*Concesionario concesionario*/) {
        concesionario.listaVehiculos();

    }

    /**
     * método que busca un vehículo a través da matrícula
     *
     * @param concesionario
     */
    private static void buscarV(/*Concesionario concesionario*/) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce a matrícula a buscar: ");
        String matricula = sc.nextLine();
        String busqueda = concesionario.buscaVehiculo(matricula);
        if (busqueda == null) {
            System.out.println("Non existe vehículo coa matrícula introducida");
        }
        System.out.println(busqueda);

    }

    /**
     * método que modifica un vehículo
     *
     * @param concesionario
     */
    private static void modificarV(/*Concesionario concesionario*/) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce a matrícula a buscar: ");
        String matricula = sc.nextLine();
        System.out.println("Introduce un número de km: ");
        int kmN = sc.nextInt();
        if (concesionario.actualizarKms(matricula, kmN) == false) {
            System.out.println("Non existe vehículo coa matrícula introducida");
        }

    }

}
