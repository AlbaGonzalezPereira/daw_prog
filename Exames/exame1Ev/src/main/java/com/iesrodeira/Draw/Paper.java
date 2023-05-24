package com.iesrodeira.Draw;

/**
 * clase final
 *
 * @author alba_
 */
public final class Paper extends Drawable {

    private char[][] dibujo; //declaramos un array de chars

    /**
     * Constructor cos parámetros x e y
     *
     * @param y - fila
     * @param x - columna
     */
    public Paper(int y, int x) {
        dibujo = new char[y][x]; //creamos el char de y filas por x columnas
        clear();//chamamos ao método clear
    }

    /**
     * Método clear sobreescrito Inicializa a ' ' ao empezar o taboleiro
     */
    @Override //sobreescribimos o método
    public void clear() {
        for (int i = 0; i < dibujo.length; i++) {
            for (int j = 0; j < dibujo[i].length; j++) {
                dibujo[i][j] = ' '; //inicializamos a ' '
            }
        }
    }

    /**
     * Método show sobreescrito que amosa o taboleiro baleiro
     */
    @Override //sobreescribimos o método
    public void show() {
        for (int i = 0; i < dibujo.length; i++) {
            for (int j = 0; j < dibujo[i].length; j++) {
                System.out.print(dibujo[i][j]); //imprimimos as filas
            }
            System.out.println(""); //para que non imprima todo seguido
        }

    }

    /**
     * método que debuxa unha liña horizontal
     *
     * @param y - fila da liña
     * @param x - columna do punto inicial
     * @param x1 - columna do punto final
     * @param cor - a cor da liña, que se ignora neste método
     */
    @Override //sobreescribimos o método
    protected void drawLineHorizontal(int y, int x, int x1, int cor) {
        while (x <= x1) {
            dibujo[y][x] = '*';
            x++;
        }

    }

    /**
     * Método que debuxa unha vertica
     *
     * @param y - fila punto inicial
     * @param x - columna
     * @param y1 - fila punto final
     * @param cor - cor da liña, ignórase
     */
    @Override //sobreescribimos o método
    protected void drawLineVertical(int y, int x, int y1, int cor) {
        while (y <= y1) {
            dibujo[y][x] = '*';
            y++;
        }

    }

    /**
     * Método que pon un punto '*' no punto indicado
     *
     * @param y
     * @param x
     * @param cor
     */
    @Override //método sobreescrito
    public void point(int y, int x, int cor) {
        dibujo[y][x] = '*';
    }

    /**
     * Método que debuxa un texto segundo a dirección indicada
     *
     * @param y - fila
     * @param x - columna
     * @param text - texto
     * @param direction - dirección de pintado de texto
     */
    @Override //método sobreescrito
    public void drawText(int y, int x, String text, Direction direction) {
        for (int i = 0; i < text.length(); i++) {
            //poñemos a primeira letra do texto
            dibujo[y][x] = text.charAt(i);
            //agora comprobamos direccións para saber para onde escribirá o texto
            if (null != direction) {
                switch (direction) {
                    case LEFTRIGHT:
                        x++;
                        break;
                    case RIGHTLEFT:
                        x--;
                        break;
                    case DOWNUP:
                        y--;
                        break;
                    case UPDOWN:
                        y++;
                        break;

                }
            }
        }

    }

}
