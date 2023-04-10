package com.iesrodeira.Designer;

import com.iesrodeira.Draw.Drawable;

/**
 *
 * @author alba_
 */
public class Design {
    private Figura[] figuras;
    private int contador;

    /**
     * Constructor que crea figuras ata un tope máximo
     * @param numFiguras 
     */
    public Design(int numFiguras) {
        figuras=new Figura[numFiguras];
        contador=0;
    }
    
    /**
     * método para engadir figuras
     * @param f 
     */
    public void engadirFiguras(Figura f){
        figuras[contador]=f; //para que engada a figura na posición
        contador++;
    
    }
    
    /**
     * método para eliminar figuras
     */
    public void eliminarFiguras(){
        contador=0; //poñemos o contador a 0
    }
    
    /**
     * método que vai a visualizar cada unha das figuras que se ten gardadas
     * @param drawable 
     */
    public void draw(Drawable drawable){
        for(int i =0; i<contador;i++){
            figuras[i].draw(drawable);//recorrer todas as figuras e debuxalas
        }
        drawable.show(); //chamamos ao método show para visualizar todas as figuras
    }
    
    
    
    
}
