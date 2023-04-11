
/**
 * interface que implementa a lóxica de xogo, e decir, levan a cabo as xogadas
 * segundo as regras do xogo
 *
 * @author alba_
 */
public interface GameEngine {

    public void setGame(Game game);
    //Asigna o game ao GameEngine (o GameEngine pertence a ese Game)

    public void reset();
    //Inicializa o GameEngine poñendo o xogo no estado inicial.

    public State play(GameAction move) throws GameException;
    //Realiza a xogada (GameAction) modificando e retornando o estado do xogo

    public int nextTurn();
    // Cambia o turno e devolve o índice correspondente ao novo turno

    public int getTurn();
    //Devolve o índice correspondente co turno activo

    public State getState();
    //Devolve o estado actual do xogo

}
