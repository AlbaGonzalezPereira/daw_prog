package com.iesrodeira.Designer;

import com.iesrodeira.Draw.Point;

/**
 *
 * @author alba_
 */
public class Rectangle extends Polygon {

    /**
     * Constructor cun punto e dous lados
     * @param p
     * @param lado1 - altura do rectángulo (suma de filas)
     * @param lado2  - ancho do rectángulo (suma de columnas)
     */
    public Rectangle(Point p, int lado1, int lado2) {
        super();
        vertices[0]=p;
        //int punto2 = p.getY()+lado1;
        vertices[1]=new Point(p.getY()+lado1, p.getX());
        vertices[2]=new Point(p.getY()+lado1, p.getX()+lado2);
        vertices[3]=new Point(p.getY(), p.getX()+lado2);
        
    }
    
    
}
