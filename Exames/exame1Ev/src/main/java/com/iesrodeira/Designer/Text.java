package com.iesrodeira.Designer;

import com.iesrodeira.Draw.Drawable;
import com.iesrodeira.Draw.Drawable.Direction;
import com.iesrodeira.Draw.Point;

/**
 *
 * @author alba_
 */

public class Text extends Figura {
    private String texto;
    private Point pos;
    private Direction direccion;

    /**
     * Constructor con 3 argumentos
     * @param texto
     * @param pos
     * @param direccion 
     */
    public Text(String texto, Point pos, Direction direccion) {
        this.texto = texto;
        this.pos = pos;
        this.direccion = direccion;
    }

    /**
     * Constructor con 2 argumentos. A dirección é LEFTRIGHT
     * @param texto
     * @param pos 
     */
    public Text(String texto, Point pos) {
        this.texto = texto;
        this.pos = pos;
        this.direccion=Direction.LEFTRIGHT;
        
    }
    
    /**
     * Método sobreescrito que debuxa un Drawable
     * @param drawable 
     */
    @Override
    public void draw(Drawable drawable) {
        drawable.drawText(pos, texto, direccion); //chamamos ao método drawText da clase Drawable
    }
    
    
}
