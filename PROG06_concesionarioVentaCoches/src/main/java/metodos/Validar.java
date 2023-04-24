package metodos;

/**
 *
 * @author alba_
 */
public class Validar {

    /**
     * Método para validar dni dunha persoa NNNNNNNNL mediante expresión regular
     * @param dni
     * @return
     */
    public static boolean validarDNI(String dni) {
        if (dni.toUpperCase().matches("[0-9]{8}[A-Z]{1}")) {
            return true;
        }
        return false;
    }

    /**
     * Método para validar a matrícula dun vehículo NNNNLLL mediante expresión regular
     * @param matricula
     * @return
     */
    public static boolean validarMatricula(String matricula) {
        if (matricula.toUpperCase().matches("[0-9]{4}[A-Z]{3}")) {
            return true;
        }
        return false;
    }

    /**
     * método para validar que os datos do propietario conteña alomenos un nome
     * e dous apelidos e non exceda de 40 caracteres
     * @param nombre
     * @return 
     */
    public static boolean validarDatosProp(String nombre) {
        //para eliminar los espacios al inicio y al final
        nombre = nombre.trim();
        if (nombre.length() > 40) {
            return false;
        }
               
        //comprobamos que o nome teña alomenos un nome e dous apelidos
        String[] nomApel=nombre.split(" ");
        //o método split() corta unha cadea onde atope o que lle poñamos dentro
        if(nomApel.length>=3)
            return true;
        return false;
        
        
    }

}
