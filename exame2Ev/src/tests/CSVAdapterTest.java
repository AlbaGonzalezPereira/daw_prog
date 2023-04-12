package tests;

import csv.*;
//import csv.CSV;
//import csv.CSVAdapter;
import csv.CSVRow;
import utils.DataReader;
import java.io.IOException;
import library.*;
//import library.Publicacion;
//import library.PublicacionCSVRowAdapter;


public class CSVAdapterTest {
    private static final String DATAPATH=CSV.class.getResource("/resources").getPath();

    
    public static void main(String[] args) throws IOException {
        CSVAdapter<Publicacion> csvadapter=new CSVAdapter<>(new PublicacionCSVRowAdapter());
        
        // Creamos unha Publicación con dous autores
        Publicacion p=new Publicacion("978-1-4842-4827-0","Building Microservices Applications");
        p.setAutores(new String[] {"Harsh Chawla","Hemant Kathuria"});
        p.setLingua("Inglés");
        p.setEditorial("Apress");
        p.setXenero("Libro de Texto");
        p.setPaxinas(273);
        
        System.out.println("Obtendo CSV a partir do obxecto:\n\t"+p);
        csvadapter.addObject(p);
        System.out.println(csvadapter.getCSV());
        
        
        System.out.println("\nModificando ISBN da primeira fila do CSV");
        CSV csv=csvadapter.getCSV();
        CSVRow row=csv.getRow(0);
        row.setValue("isbn","************");
        System.out.println(csvadapter.getCSV());
        
        System.out.println("\nVisualizando a Lista de Obxectos almacenados: ");
        csvadapter.forEach(pub->System.out.println(pub));
        
        System.out.println("\nLimpando CSV:");
        csvadapter.clear();
        System.out.println(csvadapter.getCSV());

        System.out.println("\nObtendo CSV a partir dun ficheiro CSV:");
        // DataReader está feita no package utils
        String[] info=DataReader.read(DATAPATH+"/"+"Publicacion.csv");
        csvadapter.setCSV(info);
        System.out.println(csvadapter.getCSV());
        
        System.out.println("\nLista de Obxectos definidos polo CSV:");
        csvadapter.forEach(pub->System.out.println(pub));
        
        System.out.println("\nCreando Obxectos a partir dun array coas liñas de texto do CSV :");
        csvadapter=new CSVAdapter<>(info,new PublicacionCSVRowAdapter());
        csvadapter.forEach(pub->System.out.println(pub));
        
        System.out.println("\nO Ficheiro CSV producido polas liñas de texto do CSV:");
        System.out.println(csvadapter.getCSV());
    }
}
