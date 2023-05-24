package com.iesrodeira.Draw;

/**
 *
 * @author alba_
 */

public class Drawable {
    public enum Direction { LEFTRIGHT,RIGHTLEFT,UPDOWN,DOWNUP };
        
    /**
    *   Debuxa un punto nas coordenadas (fila,columna) na cor cor.Si as coordenadas quedan fora do área de debuxo
    *	simplemente non fai nada.
    * 
    * @param y - Fila
    * @param x  - Columna
    * @param cor - Cor do punto
    */
    public void point(int y,int x,int cor) {
        System.out.println("Debuxando un punto en "+new Point(y,x)+" na cor "+cor);
    }

        
    /**
    *	Debuxa o punto p na cor cor.Si as coordenadas do punto quedan fora do área de debuxo
    *   simplemente non fai nada.
    * 
    * @param p      - Coordenada do punto
    * @param cor    - cor do punto
    */
    public void point(Point p,int cor) {
        point(p.y,p.x,cor);
    }
        
        
    /**
    *   Debuxa o texto text a partir das coordenadas (fila,columna).
    * Si as coordenadas quedan fora do área de debuxo simplemente non fai nada
    * O texto se debuxa segundo a dirección especificada.
    * 
    * @param y - Fila
    * @param x  - Columna
    * @param text   - Texto a debuxar
    * @param direction - Dirección de pintado do texto
    */
    public void drawText(int y,int x,String text,Direction direction) {
        System.out.print("Debuxando '"+text+" dende "+new Point(y,x)+" na dirección "+direction);   
    }
        
            
    /**
    *   Debuxa o texto text a partir do punto p.
    *   Si as coordenadas quedan fora do área de debuxo simplemente non fai nada
    *   O texto se debuxa segundo a dirección especificada.
    * 
    * @param p  - Coordenada de inicio de debuxo do texto
    * @param text   - Texto a debuxar 
    * @param direction - Dirección de pintado do texto
    */
    public void drawText(Point p,String text,Direction direction) {
        drawText(p.y,p.x,text,direction);
    }
    
    /**
    *	Debuxa o texto text a partir das coordenadas (fila,columna).
    * Si as coordenadas quedan fora do área de debuxo simplemente non fai nada
    *
    * @param y - Fila
    * @param x - Columna
    * @param text - Texto a debuxar
    */
    public void drawText(int y,int x,String text) {
        drawText(y,x,text,Direction.LEFTRIGHT);
    }
        
    /**
    *   Debuxa o texto text a partir do punto p.
    * Si as coordenadas quedan fora do área de debuxo simplemente non fai nada
    *
    * @param p - Coordenada de inicio de debuxo do texto
    * @param text  - Texto a debuxar
    */
    public void drawText(Point p,String text) {
        drawText(p.y,p.x,text);
    }

    /**
     * Debuxa unha liÃ±a dende as coordenadas (y,x) (fila,columna) ata as coordenadas
     * (y1,x1) na cor especificada.As corrdendadas fora do Ã¡rea de debuxo simplemente se ignoran
     * 
     * @param y - Fila do punto inicial da liÃ±a
     * @param x - Columna do punto inicial da liÃ±a
     * @param y1 - Fila do punto final da liÃ±a
     * @param x1 - Columna do punto final da liÃ±a
     * @param cor - Cor da liña
     */
    public void drawLine(int y,int x,int y1,int x1,int cor) {
        if (y==y1) {
            if (x<=x1)  drawLineHorizontal(y,x,x1,cor);
            else        drawLineHorizontal(y,x1,x,cor);
        }
        else if (x==x1) {
            if (y<=y1)  drawLineVertical(y,x,y1,cor);
            else        drawLineVertical(y1,x,y,cor);
        }
        else {
            System.out.println("Debuxando unha liña de cor "+cor+" dende "+new Point(y,x)+" a "+new Point(y1,x1));
        }
    }    
        
    /**
     * Debuxa unha liña dende o Punto origin, ao punto dest na cor especificada.
     * As corrdendadas fora do área de debuxo simplemente se ignoran
     * 
     * @param origin - Coordenadas do punto orixe da liña
     * @param dest - Coordenadas do punto destiÃ±o da liña
     * @param cor - Cor da liña
     */
    public void drawLine(Point origin,Point dest,int cor) {
        drawLine(origin.y,origin.x,dest.y,dest.x,cor);
    }
        
    /**
     *      Debuxa unha liña horizontal dende (y,x)  (fila.columna) ata a columna x1 na cor
     *      especificada en cor.As coordenadas fora do área de debuxo simplemente se ignoran.
     * 
     * @param y  - Fila da liña
     * @param x  - Columna do punto inicial da liña
     * @param x1 - Columna do punto final da liña
     * @param cor - Cor da liña
     */
    protected void drawLineHorizontal(int y,int x,int x1,int cor) {
        throw new UnsupportedOperationException("Non implementada");
    }
        
    /**
     *      Debuxa unha liÃ±a vertical dende (y,x)  (fila.columna) ata a fila y1 na cor
     *      especificada en cor.As coordenadas fora do área de debuxo simplemente se ignoran.
     * @param y - Fila do punto inicial da liña
     * @param x - Columna da liña
     * @param y1 - Fila do punto final da liña
     * @param cor - Cor da liña
     */
    protected void drawLineVertical(int y,int x,int y1,int cor) {
        throw new UnsupportedOperationException("Non implementada");
    }
    
    /**
     * Limpa o área de debuxo
     */
    public void clear() {
        throw new UnsupportedOperationException("Non implementada");
    }
    
    /**
     * Amosa o debuxo
     */
    public void show() {
        throw new UnsupportedOperationException("Non implementada");
    }
}

