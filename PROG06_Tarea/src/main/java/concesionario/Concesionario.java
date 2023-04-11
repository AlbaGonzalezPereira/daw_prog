package concesionario;

/**
 *
 * @author alba_
 */
public class Concesionario {

    private int numV;
    private final int MAX_V = 50;
    private Vehiculo[] vehiculos;

    /**
     * método constructor, inicializamos numV a 0 e o array co máximo
     */
    public Concesionario() {
        numV = 0;
        vehiculos = new Vehiculo[MAX_V];
    }

    /**
     * método para buscar os datos dun vehículo introducindo a matrícula
     * @param matricula
     * @return 
     */
    public String buscaVehiculo(String matricula) {
        for (int i = 0; i < numV; i++) {
            if (matricula.equals(vehiculos[i].getMatricula())) {
                return vehiculos.toString();
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
        if (numV == 0) {
            return -1;//devolve -1 porque o di a tarefa
        }

        for (int i = 0; i < numV; i++) {
            if (v.getMatricula().equals(this.vehiculos[i].getMatricula())) {
                return -2;//devolve -2 porque o di a tarefa
            }
        }
        vehiculos[numV] = v;
        numV++;
        return 0; //devolve 0 porque o di a tarefa
    }

    /**
     * método para listar os vehículos que hai no concesionario
     */
    public void listaVehiculos() {
        System.out.println("Todos os vehículos do concesionario son: ");
        for (int i = 0; i < numV; i++) {
            System.out.println(vehiculos[i]);

        }
    }

    /**
     * método para actualizar os kms
     * @param matricula
     * @param kms
     * @return 
     */
    public boolean actualizarKms(String matricula, int kms) {
        for (int i = 0; i < numV; i++) {
            if (matricula.equals(vehiculos[i].getMatricula())) {
                vehiculos[i].setKm(kms);
                return true;
            }
        }
        return false;
    }

}
