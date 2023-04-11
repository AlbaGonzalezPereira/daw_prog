package concesionario;

import java.util.TreeSet;

/**
 *
 * @author alba_
 */
public class Concesionario {

    private int numV;
    private final int MAX_V = 50;
    //private Vehiculo[] vehiculos;
    private TreeSet<Vehiculo> vehiculos; //escogemos un TreeSet porque van a ser 
    //almacenados de forma ordenada y no admiten duplicados, además de ser una 
    //colección dinámica, al contrario que un array. Escogemos un set en vez de 
    //Map porque no tenemos llave y valor

    /**
     * método constructor, inicializamos numV a 0 e o array co máximo
     */
    public Concesionario() {
        numV = 0;
        //vehiculos = new Vehiculo[MAX_V];
        vehiculos = new TreeSet<>();
    }

    /**
     * método para buscar os datos dun vehículo introducindo a matrícula
     *
     * @param matricula
     * @return
     */
    public String buscaVehiculo(String matricula) {
//        for (int i = 0; i < numV; i++) {
//            if (matricula.equals(vehiculos[i].getMatricula())) {
//                return vehiculos.toString();
//            }
//        }
//        return null;
        for (Vehiculo vehiculo : vehiculos) {
            if (matricula.equals(vehiculo.getMatricula())) {
                return vehiculo.toString();
            }

        }
        return null;
    }

    /**
     * método para insertar un vehículo
     *
     * @param v
     * @return
     */
    public int insertarVehiculo(Vehiculo v) {
//        if (numV == 0) {
//            return -1;//devolve -1 porque o di a tarefa
//        }
//
//        for (int i = 0; i < numV; i++) {
//            if (v.getMatricula().equals(this.vehiculos[i].getMatricula())) {
//                return -2;//devolve -2 porque o di a tarefa
//            }
//        }
//        vehiculos[numV] = v;
//        numV++;
//        return 0; //devolve 0 porque o di a tarefa
        if (numV == 0) {
            return -1;//devolve -1 porque o di a tarefa
        }
        //tamén valería así:
        //if(vehiculos.size()==0){
        //return -1;//devolve -1 porque o di a tarefa
        //    }

        for (Vehiculo vehiculo : vehiculos) {
            if (v.getMatricula().equals(vehiculo.getMatricula())) {
                return -2;
            }

        }
        vehiculos.add(v);
        numV++;
        return 0; //devolve 0 porque o di a tarefa

    }

    /**
     * método para listar os vehículos que hai no concesionario
     */
    public void listaVehiculos() {
//        System.out.println("Todos os vehículos do concesionario son: ");
//        for (int i = 0; i < numV; i++) {
//            System.out.println(vehiculos[i]);
//
//        }
        System.out.println("Todos os vehículos do concesionario son: ");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
        }

    }

    /**
     * método para actualizar os kms
     *
     * @param matricula
     * @param kms
     * @return
     */
    public boolean actualizarKms(String matricula, int kms) {
//        for (int i = 0; i < numV; i++) {
//            if (matricula.equals(vehiculos[i].getMatricula())) {
//                vehiculos[i].setKm(kms);
//                return true;
//            }
//        }
//        return false;
        for (Vehiculo vehiculo : vehiculos) {
            if (matricula.equals(vehiculo.getMatricula())) {
                vehiculo.setKm(kms);
                return true;
            }

        }
        return false;

    }
    //engadimos o método
    /**
     * método que dada unha matrícula, elimina o vehículo cuia matrícula coincide se existe
     * @param matricula
     * @return 
     */
    public boolean eliminarVehiculo(String matricula){
        for (Vehiculo vehiculo : vehiculos) {
            if (matricula.equals(vehiculo.getMatricula())) {
                vehiculos.remove(vehiculo);
                return true;
            }

        }
        
    return false;
    }
}
