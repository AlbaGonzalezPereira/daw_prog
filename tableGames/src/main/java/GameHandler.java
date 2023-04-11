
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alba_
 */
public class GameHandler implements PlayEventHandler {

    Game xogo;

    @Override
    public void eventLoop() {
        while (xogo.getState() == State.RUNNING) {
            Player xogador = xogo.getCurrentPlayer();
            try {
                //xogador.getPlay();
                handleEvent(xogador.getPlay());
            } catch (GameException ex) {
                Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void handleEvent(GameAction move) {
        try {
            if(xogo.play(move)==State.RUNNING){
                Player xogadorActivo=xogo.nextTurn();
                while((xogo.play(move)==State.RUNNING)&&xogadorActivo.isAutomatic()){
                    xogo.refreshUI();
                    xogadorActivo.getPlay();
                    if(xogo.play(move)==State.RUNNING){
                    Player seguinteXogador=xogo.nextTurn();
                    }
                }
            }
            xogo.refreshUI();
            
            if(xogo.getState()!=State.RUNNING){
                xogo.result();
            }
            
        } catch (GameException ex) {
            Logger.getLogger(GameHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

}
