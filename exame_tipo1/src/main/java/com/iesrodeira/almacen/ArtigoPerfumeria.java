
package com.iesrodeira.almacen;

/**
 *
 * @author alba_
 */
public class ArtigoPerfumeria extends Artigo{

    public ArtigoPerfumeria(String codigo, String denominacion, String descricion, double prezo) {
        super(codigo, denominacion, descricion, prezo);
    }

  

    @Override
    public String toString() {
         return super.toString()+"}";
    }
    
    
    
    
    
}
