
/**
 * Clase que representa un taboleiro de xogo que pode almacenar fichas (Piece) de xogo
 * @author alba_
 */
public class Table {
    private Piece[][] pezas;
    
    

    /**
     * constructor para que cree un obxecto de de n filas por m columnas
     * @param filas
     * @param columnas 
     */
    //
    public Table(int filas, int columnas) {
        pezas = new Piece[filas][columnas];
    }
    
    /**
     * método que devolve unha peza na posición dada 
     * @param f
     * @param c
     * @return 
     */
    public Piece get(int f,int c){
       return pezas[f][c];
    }
    
    /**
     * método para poñer unha ficha na fila f, columna c
     * @param f
     * @param c
     * @param ficha 
     */
    public void put(int f,int c,Piece ficha){
        pezas[f][c]=ficha;
    
    }
    
    /**
     * método quitar a ficha da fila f, columna c
     * @param f
     * @param c
     * @return 
     */
    public Piece remove(int f,int c){
        Piece ficha=pezas[f][c];
        pezas[f][c]=null;
        return ficha;
            }
    /**
     * método para Limpar o taboleiro
     */
    public void reset(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                pezas[i][j]=null;
            }
            
        }
       
    
    }
    
}
