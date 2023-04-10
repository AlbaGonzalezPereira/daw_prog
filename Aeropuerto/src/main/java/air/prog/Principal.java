package air.prog;

import static air.utils.Metodos_Estaticos.*;
import java.util.Scanner;

/**
 *
 * @author alba_
 */
public class Principal {

    private static Scanner sc = new Scanner(System.in);
    private static Aeropuerto ap = new Aeropuerto();

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("1. Introducir avión \n"
                    + "2. Visualizar aviones \n"
                    + "3. Ver el número de las plazas totales \n"
                    + "4. Modificar precio del billete \n"
                    + "5. Salir \n");

            System.out.println("Escoge una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    introducirAvion();
                    break;
                case 2:
                    visualizarAviones();
                    break;
                case 3:
                    verPlazas();
                    break;
                case 4:
                    modificarPrecio();
                    break;
                case 5:
                    break;
            }

        } while (opcion != 5);
    }//fin main

    private static void introducirAvion() {
        boolean tipo;
        int numPl, vel, ta, Tpmis;
        float precio;
        String codigo;
        TipoMisiles Tmis;

        System.out.println("Introduce el tipo de avión (0 para pasajeros y 1 para Combate): ");
        ta = sc.nextInt();
        if (ta == 0) {
            System.out.println("Introduzca el número de plazas: ");
            numPl = sc.nextInt();
            System.out.println("Introduzca el precio: ");
            precio = sc.nextFloat();
            System.out.println("Introduzca el código: ");
            sc.nextLine();
            codigo = sc.nextLine();

            Avion av1 = new AvionPasaj(numPl, precio, codigo, ta);
            if (ap.engadirAvion(av1)) {
                System.out.println("Avión añadido");
            } else {
                System.out.println("Avión no añadido");
            }
        } else {
            System.out.println("Introduzca la velocidad del avión: ");
            vel = sc.nextInt();
            do {
                System.out.println("Introduzca el tipo de misiles): \n"
                        + "0. aire-tierra \n"
                        + "1. aire-aire \n"
                        + "2. bengala \n");

                Tpmis = sc.nextInt();
            } while (Tpmis < 0 || Tpmis > 2);

            if (Tpmis == 0) {
                Tmis = TipoMisiles.aireTierra;
            } else if (Tpmis == 1) {
                Tmis = TipoMisiles.aireAire;
            } else {
                Tmis = TipoMisiles.bengala;
            }

            System.out.println("Introduzca el código: ");
            sc.nextLine();
            codigo = sc.nextLine();
            Avion av = new AvionComb(vel, Tmis, codigo, ta);
            ap.engadirAvion(av);

        }//else

    }//fin de IntroducirAvion()

    private static void visualizarAviones() {
        Avion[] a = ap.getAviones();
        for (int i = 0; i < ap.getNumAviones(); i++) {
            System.out.println(a[i]);
        }
    }

    private static void verPlazas() {
        Avion[] a = ap.getAviones();
        for (int i = 0; i < ap.getNumAviones(); i++) {
            if (a[i].getTipo() == 0) {
                System.out.println("El número de plazas es: " + a[i].getNumPlaza());
            }
        }
    }

    private static void modificarPrecio() {
        Avion[] a = ap.getAviones();
        for (int i = 0; i < ap.getNumAviones(); i++) {
            if (a[i].getTipo() == 0) {
                System.out.println("Introduce el nuevo precio del billete");
                float nuevoPr = sc.nextFloat();
                a[i].setPrecioBillete(nuevoPr);
            }
        }
    }

}//fin class
