
/**
 * clase que extende de GameAction que representa un click do rato sobre unha fila e columna do taboleiro
 * @author alba_
 */
public class ClickAction extends GameAction{
    //para solicitar as coordenadas onde se fai o click
    private int coordX;
    private int coordY;

    public ClickAction(Player xogador) {
        super(Action.CLICK, xogador);
    }

    //engadimos os get, para obter as coordenadas onde se fai o click
    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }
    
    
    
    
}
