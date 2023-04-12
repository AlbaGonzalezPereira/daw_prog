package tests;

import java.io.IOException;
import library.Publicacion;
import storage.ArrayListAlmacen;

public class AlmacenArrayListTest {
    public static void main(String[] args) throws IOException, Exception {
        Publicacion[] pubs={
            new Publicacion("978-1-4842-4827-0","Building Microservices Applications"),
            new Publicacion("84-7897-429-6","Java 2"),
            new Publicacion("84-9103-064-5","Antoni Gaudí. Biografía Ilustrada"),
            new Publicacion("84-2067-420-9","El Guardián Entre el Centeno")
        };

        System.out.println("Creando AlmacenArrayList e almacenando publicacións");
        // TODO
        //
        System.out.println("\nListado de Publicacións no almacen:");
        // TODO
        //
        
        System.out.println("\nListado de Publicacións con 'Gaudí' no título:");
        // TODO
        //
        
        System.out.println("\nModificación de 'Java 2' por 'Aprendendo Java' e listado dos libros ordeados por título:");
        // TODO
        //
    }
}
