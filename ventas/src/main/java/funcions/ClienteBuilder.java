package funcions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * Clase que implanta o patrón Builder para os obxectos Clientes
 *
 * @author alba_
 */
public class ClienteBuilder implements Builder<Cliente> {

    private String dni;
    private String nome;
    private String apelidos;
    private String direccion;
    private String telefono;
    private LocalDate data_nacem;
    private String localidade;
    private String email;
    private int cp;

    private VerboseException ve;

    /**
     * ***********************************************************************
     */
    /**
     * ************SETTER QUE COMPROBAN SE OS DATOS SON CORRECTOS*************
     */
    public boolean setDni(String dni) {
        if (dniVerdadeiro() == true) {
            this.dni = dni;
            return true;
        }
        return false;
    }

    public boolean setNome(String nome) {
        if (nomeVerdadeiro() == true) {
            this.nome = nome;
            return true;
        }
        return false;
    }

    public boolean setApelidos(String apelidos) {
        if (apelidosVerdadeiro() == true) {
            this.nome = nome;
            return true;
        }
        return false;
    }

    public boolean setDireccion(String direccion) {
        if (direccionVerdadeiro() == true) {
            this.direccion = direccion;
            return true;
        }
        return false;
    }

    public boolean setTelefono(String telefono) {
        if (telefonoVerdadeiro() == true) {
            this.telefono = telefono;
            return true;
        }
        return false;
    }

    public boolean setData_nacem(LocalDate data_nacem) {
        if (dataVerdadeiro() == true) {
            this.data_nacem = data_nacem;
            return true;
        }
        return false;
    }

    public boolean setLocalidade(String localidade) {
        if (localidadeVerdadeiro() == true) {
            this.localidade = localidade;
            return true;
        }
        return false;
    }

    public boolean setEmail(String email) {
        if (emailVerdadeiro() == true) {
            this.email = email;
            return true;
        }
        return false;
    }

    public boolean setCp(int cp) {
        if (cpVerdadeiro() == true) {
            this.cp = cp;
            return true;
        }
        return false;
    }

    /**
     * ***********************************************************************
     */
    /**
     * Método que constrúe un Obxecto Cliente e lanza unha VerboseException se hai erros
     *
     * @return
     */
    @Override
    public Cliente build() throws VerboseException {
        Cliente cl;//declaramos un novo cliente

        reset();//Limpamos os error ao comezo
        //chamamos aos métodos para comprobar que son correctos
        //se algún da un erro, engade unha mensaxe á VerboseExceptiendo creándoa se non existe
        //para crear un obxecto Cliente non debe haber ningún erro
        apelidosVerdadeiro();
        cpVerdadeiro();
        dataVerdadeiro();
        direccionVerdadeiro();
        dniVerdadeiro();
        emailVerdadeiro();
        localidadeVerdadeiro();
        nomeVerdadeiro();
        telefonoVerdadeiro();

        if (ve == null) {
            cl = new Cliente(this.dni, this.nome, this.apelidos);
            return cl;
        } else {
            notifyErrors();
        }
        return null;
    }

    /**
     * método que limpa os erros rexistrados ata o momento
     */
    public void reset() {
        ve = null; //inicializamos a null
    }

    /**
     * método que lanza a excepción cando hai algún erro
     *
     * @throws VerboseException
     */
    public void notifyErrors() throws VerboseException {
        if (ve != null) {
            throw ve;
        }
    }

    /**
     * ***********************************************************************
     */
    /**
     * ************MÉTODOS PARA COMPROBAR DATOS INTRODUCIDOS******************
     */
    private boolean dniVerdadeiro() {
        if (this.dni.matches("[0-9]{8}[A-Z]")) {
            return true;
        }
        if (ve != null) {
            ve = new VerboseException("Excepción creada");
        }
        ve.addMensaxe(Verbosity.INFO, "O dni non é correcto");
        return false;
    }

    private boolean nomeVerdadeiro() {
        if (nome.matches("^([A-Za-zÑñÁáÉéÍíÓóÚú]+['\\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+)(\\s+([A-Za-zÑñÁáÉéÍíÓóÚú]+['\\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+))*$")) {
            return true;
        }
        if (ve != null) {
            ve = new VerboseException("Excepción creada");
        }
        ve.addMensaxe(Verbosity.INFO, "O nome introducido é incorrecto");
        return false;
    }

    private boolean apelidosVerdadeiro() {
        if (apelidos.matches("^([A-Za-zÑñÁáÉéÍíÓóÚú]+['\\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+)(\\s+([A-Za-zÑñÁáÉéÍíÓóÚú]+['\\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+))*$")) {
            return true;
        }
        if (ve != null) {
            ve = new VerboseException("Excepción creada");
        }
        ve.addMensaxe(Verbosity.INFO, "O apelido introducido é incorrecto");
        return false;
    }

    private boolean direccionVerdadeiro() {
        if (direccion.matches("^([A-Za-zÑñÁáÉéÍíÓóÚú]+['\\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+)(\\s+([A-Za-zÑñÁáÉéÍíÓóÚú]+['\\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+))*$")) {
            return true;
        }
        if (ve != null) {
            ve = new VerboseException("Excepción creada");
        }
        ve.addMensaxe(Verbosity.INFO, "A dirección introducida é incorrecta");
        return false;
    }

    private boolean localidadeVerdadeiro() {
        if (localidade.matches("^([A-Za-zÑñÁáÉéÍíÓóÚú]+['\\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+)(\\s+([A-Za-zÑñÁáÉéÍíÓóÚú]+['\\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+))*$")) {
            return true;
        }
        if (ve != null) {
            ve = new VerboseException("Excepción creada");
        }
        ve.addMensaxe(Verbosity.INFO, "A localidade é incorrecta");
        return false;
    }

    private boolean telefonoVerdadeiro() {
        if (this.telefono.matches("[0-9]{9}")) {
            return true;
        }
        if (ve != null) {
            ve = new VerboseException("Excepción creada");
        }
        ve.addMensaxe(Verbosity.INFO, "O teléfono introducido non é correcto");
        return false;
    }

    private boolean cpVerdadeiro() {
        if (String.valueOf(this.cp).matches("(([1-4][0-9][0-9][0-9][0-9])|(0(?=[1-9][0-9][0-9][0-9]))|(5(?=[0-2][0-9][0-9][0-9])))")) {
            return true;
        }
        if (ve != null) {
            ve = new VerboseException("Excepción creada");
        }
        ve.addMensaxe(Verbosity.INFO, "O CP introducido non é correcto");
        return false;
    }

    private boolean emailVerdadeiro() {
        if (this.email.matches("[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]+")) {
            return true;
        }
        if (ve != null) {
            ve = new VerboseException("Excepción creada");
        }
        ve.addMensaxe(Verbosity.INFO, "O email introducido non é correcto");
        return false;
    }

    private boolean dataVerdadeiro() {
        if (data_nacem.isBefore(LocalDate.of(2006, Month.JANUARY, 1))) {
            return true;
        }
        if (ve != null) {
            ve = new VerboseException("Excepción creada");
        }
        ve.addMensaxe(Verbosity.INFO, "O data introducida non é correcta");
        return false;
    }
    /**
     * ***********************************************************************
     */

}
