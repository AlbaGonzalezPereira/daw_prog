
/**
 * interface que recibe a acción do usuario (GameAction) e a xestiona de
acordo as regras do xogo
 * @author alba_
 */
public interface PlayEventHandler {
    
    /**
     * método que crea un bucle mentres o estado do xogo sexa RUNNING que se encarga de recoller a xogada do usuario (GameAction) e
despachala ao handler (handleEvent)
     */
    public void eventLoop();
    
    /**
     * método que recibe unha acción do usuario (GameAction) e se encarga de que se leve a cabo segundo as regras do engine utilizado
     * @param move 
     */
    public void handleEvent(GameAction move);
}
