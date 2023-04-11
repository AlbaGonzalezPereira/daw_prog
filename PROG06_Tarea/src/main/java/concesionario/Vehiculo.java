package concesionario;

//importamos clase LocalDate para obter a data de matriculación
import java.time.LocalDate;

/**
 * Esta clase contén os atributos e métodos dun vehículo
 *
 * @author alba
 * @version 1.0
 * @see Principal
 */
public class Vehiculo {

    // declaramos os atributos
    private String marca;
    private String matricula;
    private int km;
    private LocalDate fecha;
    private String descricion;
    private float prezo;
    private String nome_prop;
    private String dni_prop;

// declaramos o constructor baleiro, é necesario ao declarar un constructor con argumentos
    public Vehiculo() {
    }

    // declaramos o constructor con todos os argumentos
    public Vehiculo(String marca, String matricula, int km, LocalDate fecha, String descricion, float prezo, String nome_prop, String dni_prop) {
        this.marca = marca;
        this.matricula = matricula;
        this.km = km;
        this.fecha = fecha;
        this.descricion = descricion;
        this.prezo = prezo;
        this.nome_prop = nome_prop;
        this.dni_prop = dni_prop;
    }

//declaramos os métodos get e set
    /**
     * Devolve a marca
     *
     * @return devolve un string coa marca do vehículo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Cambia o valor da marca
     *
     * @param marca String co valor da marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Devolve a matricula
     *
     * @return devolve o String da matrícula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Cambia a matricula
     *
     * @param matricula String coa matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Devolve os kilómetros
     *
     * @return devolve o enteiro dos kilómetros
     */
    public int getKm() {
        return km;
    }

    /**
     * Cambia os kilómetros de atributo
     *
     * @param km Enteiro cos kilómetros
     */
    public void setKm(int km) {
        this.km = km;
    }

    /**
     * Devolve a data
     *
     * @return Devolve un LocalDate coa data
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Modifica a data
     *
     * @param fecha LocalDate da data a modificar
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Devolve a descrición
     *
     * @return String da descrición a devolver
     */
    public String getDescricion() {
        return descricion;
    }

    /**
     * Modifica a descrición
     *
     * @param descricion String coa descrición a modificar
     */
    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    /**
     * Devolve o prezo
     *
     * @return Devovle o float do prezo
     */
    public float getPrezo() {
        return prezo;
    }

    /**
     * Modifica o prezo
     *
     * @param prezo Float do prezo a modificar
     */
    public void setPrezo(float prezo) {
        this.prezo = prezo;
    }

    /**
     * Devolve o nome
     *
     * @return devovle o nome dos propietarios
     */
    public String getNome_prop() {
        return nome_prop;
    }

    /**
     * Modifica o nome do propietario
     *
     * @param nome_prop String do nome do propietario
     */
    public void setNome_prop(String nome_prop) {
        this.nome_prop = nome_prop;
    }

    /**
     * Devolve o dni do propietario
     *
     * @return String do nome do propietario
     */
    public String getDni_prop() {
        return dni_prop;
    }

    /**
     * Modifica o dni
     *
     * @param dni_prop Parametro do dni do propietario
     */
    public void setDni_prop(String dni_prop) {
        this.dni_prop = dni_prop;
    }

    //declaramos o método get_Anios
    /**
     *
     * @return anos --> son os anos que ten o vehículo
     */
    public int get_Anios() {
        // declaramos data actual
        LocalDate agora = LocalDate.now();
        //declaramos  ano da data actual e da data de matriculación
        int anosAgora = agora.getYear();
        int anosData = fecha.getYear();
        //declaramos variable de obter o número de anos
        int anos = anosAgora - anosData;
        return anos;
    }

    /**
     * método para que me devuelva los datos del vehículo
     *
     * @return
     */
    @Override
    public String toString() {
        return "Os datos do Vehiculo son {" + "marca=" + marca + ", matricula=" + matricula + ", km=" + km + ", fecha=" + fecha + ", descricion=" + descricion + ", prezo=" + prezo + ", nome_prop=" + nome_prop + ", dni_prop=" + dni_prop + '}';
    }

}
