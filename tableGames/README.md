## Xogos de Taboleiro
O obxecto deste exercicio é programar os seguintes xogos que teñen en común o emprego de un taboleiro de xogo de **n** filas e **m** columnas, e que poden utilizar fichas para xogar:
* Reversi (Otello)
* 4 en Raia
* Buscaminas

Todos estes xogos teñen xogadores que efectúan xogadas que cambian o estado do xogo segundo unhas regras.

Intentaremos desenvolver estes xogos compartindo a maior cantidade de código posible e intentando separar a lóxica do xogo (motor do xogo) da súa presentación (entrada e saída de información). Deste xeito, si a presentación de dous xogos é similar, simplemente cambiando o motor do xogo, cambiaríamos de xogo. Polo tanto desenvolveremos as
seguintes clases:

**GameException**

    Será a clase a que pertencerán os obxectos da aplicación representado estados erróneos.
**GameAction**

    Será a clase a que pertencerán as xogadas (eventos do xogo) que se realicen. Unha xogada consistirá nunha *Action* (acción do xogo) e do xogador (*Player*) que a realice. Inicialmente termos dous tipos de Action, CLICK e END: “CLICK” que representa un “click” do rato, e “END” que indica que se finaliza o xogo.

**Player**

    Será a clase a que pertencerán os xogadores participantes no xogo. Un Player ten:
    
    como características unicamente accesibles dende a propia clase:
        • nick de tipo String
        • ficha coa que xoga que é un obxecto de tipo Piece 

    como características accesibles dende a propia clase ou clases heredadas:
        • si é un xogador automático (un bot) ou non de tipo boolean
        • obxecto ``Game`` (o xogo) ao que están xogando.

**Piece**

    Será a clase a que pertencerán as fichas de xogo. Unha Piece ten como características unicamente accesibles dende a proñia clase:
        • id de tipo char. Identificará a ficha e será a súa representación nas Ui de consola.
        • image de tipo String, será a URI da icona que representa a ficha nas Ui Gráficas.

**Table**
    Un obxecto da clase Table representa un taboleiro de xogo que pode almacenar fichas (Piece) de xogo. Un Table está composto dun array de Piece[][] de n filas por m columnas unicamente accesible dende a propia clase, e dispón da seguinte funcionalidade:

        • Obter a ficha da fila f, columna c: public Piece get(int f,int c);
        • Poñer unha ficha na fila f, columna c: public void put(int f,int c,Piece ficha);
        • Quitar a ficha da fila f, columna c: public Piece remove(int f,int c);
        • Retornará a ficha eliminada do taboleiro
        • Limpar o taboleiro: public void reset();

**State**

    Será a clase a que pertencerán os obxectos que indiquen o estado no que se atopa o xogo. Os estados poden ser: STOPPED,RUNNING,ENDED,WIN,LOST e TIE.

**Ui**

    Un “Ui” é calquera obxecto que dispoña da seguinte funcionalidade pública:
        • public void setGame(Game game);
        • Asigna o game a Ui (a Ui pertence a ese Game)
        • public void start(PlayEventHandler handler) throws GameException;
        • Inicia a Ui utilizando o handler para xestionar os eventos.
        • public void reset() throws GameException;
        • Inicializa a Ui
        • public void refresh() throws GameException;
        • Repinta a Ui
        • public void showMessage(String title,String msg);
        • Amosa a mensaxe msg con titulo title na Ui
        • public String read(String msg);
        • Amosa msg na Ui e retorna o String introducido polo usuario.

**GameEngine**

        Os “GameEngine” son os obxectos que implementan a lóxica de xogo, e decir, levan a cabo as xogadas segundo as regras do xogo. Un “GameEngine” é calquera obxecto que dispoña da seguinte funcionalidade pública:

            • public void setGame(Game game);
            • Asigna o game ao GameEngine (o GameEngine pertence a ese Game)
            • public void reset();
            • Inicializa o GameEngine poñendo o xogo no estado inicial.
            • public State play(GameAction move) throws GameException;
            • Realiza a xogada (GameAction) modificando e retornando o estado do xogo
            • public int nextTurn();
            • Cambia o turno e devolve o índice correspondente ao novo turno
            • public int getTurn();
            • Devolve o índice correspondente co turno activo
            • public State getState();
            • Devolve o estado actual do xogo

**PlayEventHandler**

    O “PlayEventHandler” é o obxecto que se encarga de recibir a acción do usuario (GameAction) e xestionala de acordo as regras do xogo (para o que utilizará o GameEngine que se esté a utilizar). Ademáis si a interface é de consola, creará o bucle que recollerá as entradas do usuario e as despachará como eventos GameAction ao handler.

    Un “PlayEventHandler” é calquera obxecto que dispoña da seguinte funcionalidade pública:

        • public void eventLoop();
        • Crea un bucle mentres o estado do xogo sexa RUNNING que se encarga de recoller a xogada do usuario (GameAction) e
        despachala ao handler (handleEvent)
        • public void handleEvent(GameAction move);
        • Recibe unha acción do usuario (GameAction) e se encarga de que se leve a cabo segundo as regras do engine utilizado.

**Game**

    Un xogo será un obxecto pertencente a clase Game.

    Os obxectos Game terán como atributos accesibles dende a propia clase ou clases herdadas:
    
        • unha interface de xogo (Ui) (que pode ser a consola, unha GUI ou outro tipo de interface) que
        presentará ao usuario o estado do xogo e permitirá que os xogadores realicen as xogadas.
        • Un “motor do xogo” (GameEngine) que variará o estado do xogo segundo a xogada e as regras
        propias do xogo.
        • Un conxunto de Player, que son os xogadores que interveñen no xogo.
        • Un “xestor de eventos” (PlayEventHandler). A realización das xogadas é o máis problemático, xa que o xeito de introducir a información cambia segundo o tipo de Ui que esteamos a utilizari. Para “unificar” o xeito de introducir a información, utilizaremos un obxecto da clase PlayEventHandler, que no caso da consola establecerá un bucle no que se recollerá a xogada do usuario que ten o turno mentres non remate o xogo despachándoa ao xestor de eventos. No caso dunha contorna gráfica, simplemente se “instalará” o xestor de eventos que xestionará a xogada do usuario xa que o bucle que recolle os eventos e os despacha xa forma parte da propia Ui.

    As accións que é capaz de levar a cabo un Game son:

        • Iniciar o xogo: public void start();
        • Este método se encargará de inicializar o motor do xogo, os xogadores e a interface de usuario. Tanto a interfaz de usuario
        (Ui), como os xogadores (Player) e o motor do xogo (GameEngine) necesitarán acceso ao obxecto Game ao que
        pertencen.
        • reiniciar o xogo: public void reset() throws GameException();
        • Reiniciará o motor do xogo e a interface.
        • Pasar ao seguinte turno: public Player nextTurn();
        • Cambia o turno e retorna o xogador “activo”
        • Obter o xogador en turno: public Player getCurrentPlayer();
        • Amosar no Ui o resultado do xogo: protected void result() throws GameException;