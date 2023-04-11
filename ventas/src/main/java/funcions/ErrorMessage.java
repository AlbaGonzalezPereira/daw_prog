package funcions;

import java.util.ArrayList;

/**
 * clase capaz de almacenar erros
 *
 * @author alba_
 */
class ErrorMessage {

    //engadimos os atributos
    String id;
   String description;
    ArrayList<ErrorMessage> details;

    /**
     * Constructor accesible dende calquera parte, recibirá un String id que se
     * almacenará no atributo id, e un String que se almacenará no atributo
     * description
     *
     * @param id
     * @param description
     */
    public ErrorMessage(String id, String description) {
        this.id = id;
        this.description = description;
        //atributo no que poderán existir varios obxectos ErrorMessage co mesmo valor de id.
        details = new ArrayList<>();//inicializamos o arrayList
    }

    /**
     * constructor sobrecargado que non recibe o id
     *
     * @param description
     */
    public ErrorMessage(String description) {
        this.description = description;
        this.id = "1I";//inicializamos o id ao dado
        details = new ArrayList<>();//inicializamos o arrayList
    }

    /**
     * método que ue engadirá unha mensaxe con unha id que
dependerá do Verbosity
     * @param level
     * @param msg 
     */
    public void addDetail(Verbosity level, String msg) {
        if (null != level) switch (level) {
            case INFO:
                throw new IllegalArgumentException("Este erro e de nivel INFO.\n"
                        + "So é válido para o obxecto VerboseException");
            case ERR:
                ErrorMessage em = new ErrorMessage(id.replace('I', 'E'), msg);
                details.add(em);
                break;
            case DEBUG:
                details.add(new ErrorMessage(id.replace('I', 'D'), msg));
                break;
            default:
                break;
        }
           

    }

}
