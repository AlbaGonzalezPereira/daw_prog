package com.iesrodeira.Draw;

/**
 *
 * @author alba_
 */

public class Point {
    int y; //fila
    int x; //columna

    /**
     * contructor con dous parámetros
     * @param y
     * @param c 
     */
    public Point(int y, int c) {
        this.y = y;
        this.x = c;
    }

    //Representación dun point como String coa forma (y,c)
    @Override
    public String toString() {
        return "(" + y + "," + x + ")";
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    
}
    
    
    

