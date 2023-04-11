
/**
 * clase, que non pode ser instanciada, que representa un xogo
 * @author alba_
 */
public abstract class Game {
    //engadimos os atributos accesibles desde a propia clase e clases herdadas
    protected Ui interfaz;
    protected GameEngine motorXogo;
    protected Player[] conxuntoXog;
    protected PlayEventHandler xestorEvent;
    
    //engadimos os métodos:
    /***********************************************/
    /**
     * método que se encarga de inicializar o motor do xogo, os xogadores e a interface de usuario
     */
    public void start(){
    
    }
    
    /**
     * método que reinicia o motor do xogo e a interface
     * @throws GameException 
     */
    public void reset() throws GameException{
        if((motorXogo==null)||(interfaz==null))
            throw new GameException("Non se pode resetear");
        motorXogo.reset();
        interfaz.reset();
    }
    
    /**
     * método que cambia o turno e retorna o xogador “activo”, é dicir, o novo xogador
     * @return 
     */
    public Player nextTurn(){
        return conxuntoXog[motorXogo.nextTurn()];
    }
    
    /**
     * método para obter o xogador en turno
     * @return 
     */
     public Player getCurrentPlayer(){
         return conxuntoXog[motorXogo.getTurn()];
     }
     
     /**
      * método que amosa no Ui o resultado do xogo
      * @throws GameException 
      */
      protected void result() throws GameException{
          if((motorXogo.getState()==State.RUNNING)||(motorXogo.getState()==State.STOPPED) || (motorXogo.getState()==State.ENDED)) 
              throw new GameException("O xogo está " + motorXogo.getState());
          interfaz.showMessage("O xogo rematou, o resultado é", motorXogo.getState().toString());
      }
     
     /***********************************************/
      //TAREFA 3
      //engadimos os seguintes métodos públicos
      /**
       * método que retorna o estado do xogo
       * @return 
       */
      public State getState(){
          return motorXogo.getState();
      }
    
      /**
       * método que realiza a xogada e retorna o estado do xogo 
       * @param move
       * @return
       * @throws GameException 
       */
      public State play(GameAction move) throws GameException{
          return motorXogo.play(move);
      }
      
      /**
       * método que visualiza na pantalla o estado do xogo
       * @throws GameException 
       */
      public void refreshUI() throws GameException{
          if(interfaz==null) throw new GameException("Non se deseñou ningunha interface");
          interfaz.refresh();
      }
      /**********************************************/
}
