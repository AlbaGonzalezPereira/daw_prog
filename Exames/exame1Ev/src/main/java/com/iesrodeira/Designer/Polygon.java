package com.iesrodeira.Designer;

import com.iesrodeira.Draw.Drawable;
import com.iesrodeira.Draw.Point;

/**
 *
 * @author alba_
 */
public class Polygon extends Figura {
    protected Point[] vertices; //array de vértices

    /**
     * Constructor co array de vértices de Polygon
     * @param vertices 
     */
    public Polygon(Point[] vertices) {
        this.vertices = vertices;
    }

    /**
     * creamos o constructor baleiro para usar despois nos polígonos con super();
     */
    public Polygon() {
    }
    
    
    
    /**
     * Método draw sobreescrito, heredado de Figura
     * @param drawable 
     */
    @Override
    public void draw(Drawable drawable) {
        
    }
    
    
}
