
/**
 * Clase que conterá información sobre o titular
 * @author alba_
 */
public class Persona implements Imprimible {
    //engadimos os atributos
    private String nombre;
    private String apellidos;
    private String DNI;

    //engadimos constructor con parámetros
    public Persona(String nombre, String apellidos, String DNI) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
    }

    //engadimos getters e setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    //implementamos o método devolverInfoString()
    @Override
    public String devolverInfoString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", DNI=" + DNI + '}';
    }

    
    
    
    
}
