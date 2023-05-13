package Implementacion;

import Database.Conexion;
import Database.DatabaseException;
import java.sql.Connection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Principal do programa. Conterá o método main
 *
 * @author alba_
 */
public class Principal {

    private static Scanner sc = new Scanner(System.in);
    private static DatabaseVehiculo dbv = new DatabaseVehiculo(); //creamos un obxecto DatabaseVehiculo
    private static DatabasePropietario dbp = new DatabasePropietario(); //creamos un obxecto DatabasePropietario

    public static void main(String[] args) {
        try ( Conexion con = Conexion.crearConexion()) {//creamos a conexión e metémola nun try with resources
            crearMenu(); //chamamos ao método crear menú
        } catch (Exception ex) {
            System.out.println("Erro na conexión" + ex.getMessage());
        }
    }

    private static void crearMenu() throws AssertionError, NumberFormatException {
        //Connection c = Conexion.openConnection(); //recollemos a conexión
        int opcion;

        do { //facemos o menú:           
            System.out.println("1.- Dar de alta un vehículo \n"
                    + "2.- Dar de baixa un vehículo\n"
                    + "3.- Modificar un vehículo\n"
                    + "4.- Dar de alta un propietario\n"
                    + "5.- Dar de baixa un propietario\n"
                    + "6.- Modificar un propietario \n"
                    + "7.- Vender un vehículo\n"
                    + "8.- Saír \n");
            System.out.println("Elixe unha opción: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    darAltaVehiculo();
                    break;
                case 2:
                    darBaixaVehiculo();
                    break;
                case 3:
                    modificarVehiculo();
                    break;
                case 4:
                    darAltaPropietario();
                    break;
                case 5:
                    darBaixaPropietario();
                    break;
                case 6:
                    modificarPropietario();
                    break;
                case 7:
                   venderVehiculo();
                    break;
                case 8:
                    //saír
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcion != 8);
    }

    /**
     * método que solicitará unha matrícula. Si o vehículo existe se
     * visualizarán os seus datos indicando que o vehículo xa existe. Si non
     * existe se pedirá a marca e o modelo e se almacenará no final de
     * Vehiculos.csv. O propietario será inexistente, polo que se deixa en
     * blanco
     */
    private static void darAltaVehiculo() {
        System.out.println("Introduza a matrícula do vehículo");
        String matricula = sc.nextLine();
        try {
            Vehiculo v = dbv.select(matricula);//chamamos ao método que nos devolve un vehículo
            if (v != null) {
                System.out.println("Atopado o vehículo con matrícula " + matricula);
                System.out.println(v);
            } else {
                System.out.println("Introduza a marca: ");
                String marca = sc.nextLine();
                System.out.println("Introduza o modelo: ");
                String modelo = sc.nextLine();
                dbv.insert(new Vehiculo(matricula, marca, modelo));
                System.out.println("Vehículo introducido correctamente");
            }
        } catch (DatabaseException ex) {
            System.out.println("Erro ao intentar dar de alta o vehículo con matrícula " + matricula);
        }
    }

    /**
     * método que da de baixa eu un vehículo Se solicitará unha matrícula. Si o
     * vehículo existe se visualizarán os seus datos solicitando confirmación.
     * Si se acepta, se modificará a matrícula poñendo un ‘*’
     */
    private static void darBaixaVehiculo() {
        System.out.println("Introduza a matrícula do vehículo");
        String matricula = sc.nextLine();
        try {
            Vehiculo v = dbv.select(matricula);
            if (v != null) {
                System.out.println("Atopado o vehículo con matrícula " + matricula);
                System.out.println(v);
                System.out.println("Quere borrar o vehículo amosado? Pulse 1.aceptar e 2.cancelar");
                int opcion = Integer.parseInt(sc.nextLine()); //para evitar erros coa solicitude
                if (opcion == 1) {
                    dbv.delete(v);
                    System.out.println("Vehículo borrado correctamente");
                } else {
                    System.out.println("Operación cancelada");
                }
            } else {
                System.out.println("Vehículo non atopado");
            }

        } catch (DatabaseException ex) {
            System.out.println("Erro ao intentar dar de baixa o vehículo con matrícula " + matricula);
        }
    }

    /**
     * método que solicitará unha matrícula. Si o vehículo existe se
     * visualizarán os seus datos e se solicitará de novo a marca e o modelo (a
     * matrícula e propietario se manteñen) e se solicitará confirmación. Si se
     * acepta, se eliminará o Vehículo orixinal e se engadirá un novo cos datos
     * modificados.
     */
    private static void modificarVehiculo() {
        System.out.println("Introduza a matrícula do vehículo");
        String matricula = sc.nextLine();
        try {
            Vehiculo v = dbv.select(matricula);
            if (v != null) {
                System.out.println("Atopado o vehículo solicitado");
                System.out.println(v);
                System.out.println("Introduza a marca: ");
                String marca = sc.nextLine();
                System.out.println("Introduza o modelo: ");
                String modelo = sc.nextLine();
                System.out.println("Quere modificar o vehículo amosado? Pulse 1.aceptar e 2.cancelar");
                int opcion = Integer.parseInt(sc.nextLine()); //para evitar erros coa solicitude
                if (opcion == 1) {
                    dbv.update(new Vehiculo(matricula, marca, modelo));//insertamos o vehículo
                    System.out.println("Vehículo modificado correctamente");
                } else {
                    System.out.println("Operación cancelada");
                }
            } else {
                System.out.println("Vehículo non atopado");
            }

        } catch (DatabaseException ex) {
            System.out.println("Erro ao intentar modificar os datos do vehículo con matrícula " + matricula);
        }
    }


    /**
     * método que solicita o DNI. Si o DNI existe se visualizarán os seus datos
     * indicando que xa existe. Si non existe se pedirá o nome e apelidos e se
     * engadirán ao ficheiro
     */
    private static void darAltaPropietario() {
        
        System.out.println("Introduza o dni do Propietario");
        String dni = sc.nextLine();
        try {
            Propietario p = dbp.select(dni);
            if (p != null) {
                System.out.println("Atopado o propietario solicitado");
                System.out.println(p);
            } else {
                System.out.println("Introduza o nome: ");
                String nome = sc.nextLine();
                System.out.println("Introduza os apelidos: ");
                String apelidos = sc.nextLine();
                dbp.insert(new Propietario(dni, nome, apelidos));//insertamos propietario
            }
        } catch (DatabaseException ex) {
            System.out.println("Erro ao dar de alta ao propietario con dni " + dni);
        }

    }

    /**
     * método que solicita un DNI. Si o DNI existe, se visualizarán os datos do
     * propietario e se pedirá confirmación. Si se acepta, se modificará o
     * propietario de todos os vehículos correspondentes poñendo blanco no
     * propietario (para iso se debe dar de baixa o Vehiculo, e dar unha nova
     * alta co propietario a blanco) e se cambiará o DNI por *.
     */
    private static void darBaixaPropietario() {
        System.out.println("Introduza o dni");
        String dni = sc.nextLine();
        try {
            Propietario p = dbp.select(dni);
            if (p != null) {
                System.out.println("Atopado o propietario solicitado");
                System.out.println(p);
                System.out.println("Quere borrar o propietario amosado? Pulse 1.aceptar e 2.cancelar");
                int opcion = Integer.parseInt(sc.nextLine()); //para evitar erros coa solicitude
                if (opcion == 1) {
                    dbp.delete(p);
                    System.out.println("Propietario borrado correctamente");
                } else {
                    System.out.println("Operación cancelada");
                }
            } else {
                System.out.println("Propietario non atopado");
            }
        } catch (DatabaseException ex) {
            System.out.println("Erro ao intentar dar de baixa ao propietario con dni " + dni);
        }
    }
//
    /**
     * método que solicita o DNI. Si o DNI existe, se visualizarán os seus datos
     * e se pedirá o nome e apelidos, eliminando o propietario vello, engadindo
     * os novos datos ao final e modificando os Vehiculos relacionados do xeito
     * apropiado.
     */
    private static void modificarPropietario() {
        System.out.println("Introduza o dni do propietario");
        String dni = sc.nextLine();
        try {
            Propietario p = dbp.select(dni);//buscamos o propietario co dni dado
            if (p != null) {
                System.out.println("Atopado o propietario solicitado");
                System.out.println(p);
                System.out.println("Introduza o nome: ");
                String nome = sc.nextLine();
                System.out.println("Introduza os apelidos: ");
                String apelidos = sc.nextLine();
                System.out.println("Quere modificar o propietario? Pulse 1.aceptar e 2.cancelar");
                int opcion = Integer.parseInt(sc.nextLine()); //para evitar erros coa solicitude
                if (opcion == 1) {
                    p.setNome(nome);
                    p.setApelidos(apelidos);
                    dbp.update(p);
                    System.out.println("Propietario modificado correctamente");
                } else {
                    System.out.println("Operación cancelada");
                }
            } else {
                System.out.println("Propietario non atopado");
            }

        } catch (DatabaseException ex) {
            System.out.println("Erro ao intentar modificar o propietario con dni " + dni);
        }
    }

    /**
     * método que solicita a matrícula do vehículo. Si o Vehiculo non existe se indicará 
     * que non existe, si existe se visualizarán os datos e se pedirá o DNI do propietario. 
     * Si o propietario existe, se pedirá confirmación e se modificará o Vehículo para indicar 
     * o propietario. Si o propietario non existe, se pedirá o nome e apelidos dando de alta 
     * o propietario. Se visualizarán os datos do propietario e se pedirá confirmación, si se 
     * acepta, se modificará o Vehículo para indicar o propietario.
     */
    private static void venderVehiculo() {
        System.out.println("Introduza a matrícula do vehículo");
        String matricula = sc.nextLine();
        try {
            Vehiculo v = dbv.select(matricula);//buscamos o vehículo coa matrícula dada
            if (v != null) {
                int opcion;
                System.out.println("Atopado o vehículo solicitado");
                System.out.println(v);
                System.out.println("Introduza o dni do propietario: ");
                String dni = sc.nextLine();
                Propietario p = dbp.select(dni);//buscamos o dni do propietario
                if (p != null) {
                    System.out.println("O propietario foi atopado");
                    System.out.println("Quere asignar o Propietario ao vehículo? Pulse 1.aceptar e 2.cancelar");
                    opcion = Integer.parseInt(sc.nextLine()); //para evitar erros coa solicitude
                    if (opcion == 1) {
                        v.setPropietario(p);
                        dbv.update(v);
                        System.out.println("Vehículo modificado correctamente");
                    } else {
                        System.out.println("Operación cancelada");
                    }
                } else {
                    System.out.println("O propietario non existe");
                    System.out.println("Quere dar de alta o propietario? 1. aceptar, 2. cancelar");
                    opcion = Integer.parseInt(sc.nextLine());
                    if (opcion == 1) {
                        System.out.println("Introduza o nome do propietario: ");
                        String nome = sc.nextLine();
                        System.out.println("Introduza os apelidos: ");
                        String apelidos = sc.nextLine();
                        p = new Propietario(dni, nome, apelidos);
                        dbp.insert(p);
                        System.out.println("Propietario insertado correctamente");
                        v.setPropietario(p);
                        dbv.update(v);
                        System.out.println("Vehículo modificado correctamente");
                    } else {
                        System.out.println("Operación cancelada");
                    }              
                }
            } else {
                System.out.println("O Vehículo non existe");
            }

        } catch (DatabaseException ex) {
            System.out.println("Erro ao vender o vehículo" + ex.getMessage());
        }
    }

    

}//fin class

