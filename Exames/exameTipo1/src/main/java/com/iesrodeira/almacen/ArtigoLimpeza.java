package com.iesrodeira.almacen;

/**
 *
 * @author alba_
 */
public class ArtigoLimpeza extends Artigo {
    private boolean toxico;

    public ArtigoLimpeza(boolean toxico, String codigo, String denominacion, String descricion, double prezo) {
        super(codigo, denominacion, descricion, prezo);
        this.toxico = toxico;
    }

   

    public boolean isToxico() {
        return toxico;
    }

    public void setToxico(boolean toxico) {
        this.toxico = toxico;
    }

    @Override
    public String toString() {
        return super.toString()+" " + "toxico=" + toxico + '}';
    }
    
    
    
    
    
}
