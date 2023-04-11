
/**
 * clase a que pertencerán os xogadores participantes no xogo
 *
 * @author alba_
 */
public class Player {

    //engadimos os atributos de player
    private String nick;
    private Piece ficha;
    protected boolean xogadorAI;
    protected Game xogo;

    //engadimos o constructor cos catro parámetros
    public Player(String nick, Piece ficha, boolean xogadorAI, Game xogo) {
        this.nick = nick;
        this.ficha = ficha;
        this.xogadorAI = xogadorAI;
        this.xogo = xogo;
    }

    //engadimos os getter e setter de nick e ficha
//    public String getNick() {
//        return nick;
//    }
    public void setNick(String nick) {
        this.nick = nick;
    }

//    public Piece getFicha() {
//        return ficha;
//    }
    public void setFicha(Piece ficha) {
        this.ficha = ficha;
    }

    /************************************************/
    //TAREFA 3
    //Incorporamos os seguintes métodos:
    /**
     * método que asocia o Player cun Game (o necesitan os xogadores automáticos
     * para examinar o estado do xogo)
     *
     * @param game
     */
    public void setGame(Game game) {
        this.xogo = game;
    }

    /**
     * método que retorna true si o xogador é un bot
     *
     * @return
     */
    public boolean isAutomatic() {
        if (xogadorAI == true) {
            return true;
        }
        return false;

    }

    /**
     * método que retorna o nick do xogador
     *
     * @return
     */
    public String getNick() {
        return nick;
    }

    /**
     * método que retorna a ficha do xogador
     *
     * @return
     */
    public Piece getPiece() {
        return ficha;
    }
    
    /**
     * método que retorna o GameAction (a xogada) que decida o usuario
     * @return
     * @throws GameException 
     */
    public GameAction getPlay() throws GameException{
    //Como os xogadores poden ser de distintos tipos e o modo de indicar a súa 
    //xogada (xerar un GameAction) cambia, non é posible programar o algoritmo 
    //do seu método GameAction getPlay() throws GameException;
    return null;
    }

    @Override
    public String toString() {
        return "Xogador: " + "nick=" + nick + ", ficha=" + ficha;
    }
    
    /************************************************/
}
