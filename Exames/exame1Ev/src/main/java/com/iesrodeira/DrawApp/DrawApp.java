package com.iesrodeira.DrawApp;

import com.iesrodeira.Designer.Design;
import com.iesrodeira.Designer.Rectangle;
import com.iesrodeira.Designer.Square;
import com.iesrodeira.Designer.Text;
import com.iesrodeira.Draw.Drawable.Direction;
import com.iesrodeira.Draw.Paper;
import com.iesrodeira.Draw.Point;
import java.util.Scanner;

/**
 * Clase principal
 *
 * @author alba_
 */
public class DrawApp {

    static Scanner sc = new Scanner(System.in);
    static Design design = new Design(10);

    public static void main(String[] args) {
        //creamos un Design cunha capacidade de 10 figuras. Constructor co parámetro de numFiguras
        //Design design = new Design(10);
        //Scanner sc = new Scanner(System.in);
        int opcion, fila, columna, opcion2, altura, base, lado;
        Point coordenada;
        String texto;
        Direction dir;
        do {

            System.out.println(
                    "1. Pintar Texto \n" //almacenar texto
                    + "2. Pintar Rectángulo \n"
                    + "3. Pintar Cadrado \n"
                    + "4. Amosar Debuxo \n"
                    + "5. Limpar Debuxo \n"
                    + "6. Saír \n"
                    + "");
            System.out.println("Elixe unha opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: //pintar texto
                    
                    //se podría crear un método que solicite coordenadas y devuelva un punto
                    /************************************************/
                    System.out.println("Introduza unha coordenada: ");
                    System.out.println("Introduza a fila: ");
                    fila = sc.nextInt();
                    System.out.println("Introduza a columna: ");
                    columna = sc.nextInt();
                    coordenada = new Point(fila, columna);
                    sc.nextLine();//para limpar o buffer
                    /***********************************************/
                    
                    System.out.println("Introduza o texto: ");
                    texto = sc.nextLine();
                    System.out.println("Elixe a dirección que desexe: ");
                    System.out.println(
                            "1. LEFTRIGHT, \n"
                            + "2. RIGHTLEFT, \n"
                            + "3. UPDOWN, \n"
                            + "4. DOWNUP \n"
                            + "");
                    opcion2 = sc.nextInt();
                    switch (opcion2) {
                        case 1:
                            dir = Direction.LEFTRIGHT;
                            break;
                        case 2:
                            dir = Direction.RIGHTLEFT;
                            break;
                        case 3:
                            dir = Direction.UPDOWN;
                            break;
                        default:
                            dir = Direction.DOWNUP;
                            break;
                    }
                    //engadimos a Figura Text a design
                    design.engadirFiguras(new Text(texto, coordenada, dir));

                    break;

                case 2: //pintar rectángulo
                    System.out.println("Introduza unha coordenada: ");
                    System.out.println("Introduza a fila: ");
                    fila = sc.nextInt();
                    System.out.println("Introduza a columna: ");
                    columna = sc.nextInt();
                    coordenada = new Point(fila, columna);
                    System.out.println("Introduza a altura do rectángulo: ");
                    altura = sc.nextInt();
                    System.out.println("Introduza a base do rectángulo");
                    base = sc.nextInt();
                    design.engadirFiguras(new Rectangle(coordenada, altura, base));
                    break;

                case 3://pintar cadrado
                    System.out.println("Introduza unha coordenada: ");
                    System.out.println("Introduza a fila: ");
                    fila = sc.nextInt();
                    System.out.println("Introduza a columna: ");
                    columna = sc.nextInt();
                    coordenada = new Point(fila, columna);
                    System.out.println("Introduza o lado do cadrado: ");
                    lado = sc.nextInt();
                    design.engadirFiguras(new Square(coordenada, lado));
                    break;

                case 4: //amosar debuxo
                    //visualizar na pantalla o Design cun Paper de 25 filas e 80 columnas
                    design.draw(new Paper(25, 80));
                    break;

                case 5://limpar debuxo
                    //elimina todas as figuras do design
                    design.eliminarFiguras();
                    break;

                default:
                    System.out.println("A opción introducida non é válida");

            }

        } while (opcion != 6);
    }

}
