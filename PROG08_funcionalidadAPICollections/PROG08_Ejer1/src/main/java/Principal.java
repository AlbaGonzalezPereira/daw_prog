
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal que contén o menú de opcións, é dicir, o método main e o
 * código de interacción co usuario
 *
 * @author alba_
 */
public class Principal {

    //atributos
    static Scanner sc = new Scanner(System.in);
    static Banco banco = new Banco();
    static int opcion;

    /**
     * método main
     *
     * @param args
     */
    public static void main(String[] args) {
        do {
            System.out.println("Menú de opciones: \n"
                    + "1. Abrir una nueva cuenta \n"
                    + "2. Ver listado de las cuentas disponibles \n"
                    + "3. Obtener los datos de la cuenta concreta.Realizar un ingreso en una cuenta \n"
                    + "4. Retirar efectivo de la cuenta \n"
                    + "5. Consultar el saldo actual de una cuenta \n"
                    + "6. Eliminar Cuenta Bancaria"
                    + "7. Salir \n"
                    + "Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    abrirCuenta();
                    break;
                case 2:
                    verListado();
                    break;
                case 3:
                    realizarIngreso();
                    break;
                case 4:
                    retirarEfectivo();
                    break;
                case 5:
                    consultarSaldo();
                    break;
                case 6:
                    eliminarCuentaBancaria();
                    break;

            }
        } while (opcion != 7);

    }

    /**
     * método para solicitar os datos para abrir a conta
     * @return 
     */
    public static CuentaBancaria solicitarDatos() throws Exception {
        //declaramos as variables
        String nombre, apellidos, dni, iban;
        CuentaBancaria cuenta;
        double saldo;
        float interes, comision;
        int tipoCuenta;

        //solicitamos os datos por teclado
        System.out.println("Introduce el nombre del titular:");
        nombre = sc.nextLine();
        sc.nextLine();
        System.out.println("Introduce los apellidos del titular:");
        apellidos = sc.nextLine();
        System.out.println("Introduce el DNI titular:");
        dni = sc.nextLine();
        System.out.println("Introduce el iban de la cuenta:");
        iban = sc.nextLine();
        if(comprobarIban(iban)==false)
            throw new Exception("IBAN incorrecto");
        System.out.println("Introduce el saldo titular:");
        saldo = sc.nextDouble();

        do {
            System.out.println("Introduce el tipo de cuenta:");
            System.out.println("1. Cuenta Ahorro \n"
                    + "2. Cuenta corriente empresa \n"
                    + "3. Cuenta corriente personal"
            );
            System.out.println(">:");
            tipoCuenta = sc.nextInt();
        } while (tipoCuenta < 1 || tipoCuenta > 3);
        switch (tipoCuenta) {
            case 1: // abrir Cuenta Ahorro
                System.out.println("Introduce el tipo de interes: ");
                interes = sc.nextFloat();
                cuenta = new CuentaAhorro(tipoCuenta, new Persona(nombre, apellidos, dni), saldo, iban);
                break;
            case 2: //abrir Cuenta corriente empresa
                cuenta = new CuentaCorrienteEmpresa(saldo, saldo, solicitarEntidad(), new Persona(nombre, apellidos, dni), saldo, iban);
                break;
            default: //abrir Cuenta corriente personal
                System.out.println("Introduzca la comisión de mantenimiento: ");
                comision = sc.nextFloat();
                cuenta = new CuentaCorrientePersonal(comision, solicitarEntidad(), new Persona(nombre, apellidos, dni), saldo, iban);
        }
        return cuenta;
    }
    
    /**
     * método para comprobar o iban
     * @param iban
     * @return 
     */
    private static boolean comprobarIban(String iban){
        return iban.matches("ES[0-9]{20}");
        
    
    }

    /**
     * método para solicitar a entidade
     * @return 
     */
    private static String[] solicitarEntidad() {
        String[] entidades;
        String entidad;
        entidades = null;
        System.out.println("Introduce la entidad:");
        entidad = sc.nextLine();
        entidades = new String[1];
        entidades[0] = entidad;
        return entidades;

    }

    /**
     * método para abrir a conta bancaria
     */
    private static void abrirCuenta() {
        
        try {
            CuentaBancaria cuenta = solicitarDatos();
            if (banco.abrirCuenta(cuenta)) {
                System.out.println("Cuenta abierta con éxito");
            } else {
                System.out.println("No se ha podido abrir la cuenta");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * método para ver o listado das contas
     */
    private static void verListado() {
        String[] listado = banco.listadoCuentas();
        for (int i = 0; i < listado.length; i++) {
            System.out.println(listado[i]);
        }

    }

    /**
     * método que realiza un ingreso  nunha conta
     */
    private static void realizarIngreso() {
        System.out.println("Introduce el IBAN:");
        String iban = sc.nextLine();
        System.out.println("Introduce el ingreso:");
        double ingreso = Double.parseDouble(sc.nextLine());
        if (banco.ingresoCuenta(iban, ingreso)) {
            System.out.println("Ingreso realizado correctamente");
        } else {
            System.out.println("No se ha podido realizar el ingreso");
        }

    }

    /**
     * método para retirar efectivo introducindo un iban e unha cantidade
     */
    private static void retirarEfectivo() {
        System.out.println("Introduce el IBAN:");
        String iban = sc.nextLine();
        System.out.println("Introduce la cantidad a retirar:");
        double cantidad = Double.parseDouble(sc.nextLine());
        if (banco.retiradaCuenta(iban, cantidad)) {
            System.out.println("Cantidad retirada correctamente");
        } else {
            System.out.println("No se ha podido retirar el efectivo");
        }

    }
    
    /**
     * método para consultar o saldo dunha conta
     */
    private static void consultarSaldo() {
        System.out.println("Introduce el IBAN:");
        String iban = sc.nextLine();
        System.out.println("El saldo disponible es " + banco.obtenerSaldo(iban));
    }

    private static void eliminarCuentaBancaria() {
        System.out.println("Introduce el IBAN:");
        String iban = sc.nextLine();
        if(banco.eliminarCuenta(iban)){
            System.out.println("Cuenta eliminada");
        }else{
            System.out.println("No se ha podido eliminar la cuenta");
        }
        
    }

}
