
/**
 * interface que dispón da seguinte funcionalidade pública
 * @author alba_
 */
public interface Ui {

    public void setGame(Game game);
    //Asigna o game a Ui (a Ui pertence a ese Game)

    public void start(PlayEventHandler handler) throws GameException;
    //Inicia a Ui utilizando o handler para xestionar os eventos.

    public void reset() throws GameException;
    //Inicializa a Ui

    public void refresh() throws GameException;
    //Repinta a Ui

    public void showMessage(String title, String msg);
    //Amosa a mensaxe msg con título title na Ui

    public String read(String msg);
    //Amosa msg na Ui e retorna o String introducido polo usuario.

}
