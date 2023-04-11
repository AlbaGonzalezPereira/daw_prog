/**
 *  clase a que pertencerán os obxectos da aplicación representado estados erróneos
 * @author alba_
 */
public class GameAction {
    //engadimos os atributos
    Action accion;
    Player xogador;

    /**
     * constructor con dous parámetros
     * @param accion
     * @param xogador 
     */
    public GameAction(Action accion, Player xogador) {
        this.accion = accion;
        this.xogador = xogador;
    }
    
    
    
}
