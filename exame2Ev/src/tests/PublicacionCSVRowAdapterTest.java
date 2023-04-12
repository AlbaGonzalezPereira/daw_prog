/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import csv.CSVRow;
import csv.CSVRowAdapter;
import library.Publicacion;
import library.PublicacionCSVRowAdapter;

public class PublicacionCSVRowAdapterTest {
        public static void main(String[] args) {
        String header="isbn,titulo,autor,autor,xenero,editorial,lingua,paxinas";
        String book="978-1-4842-3819-6,Pro Android with Kotlin,Peter Späth,,Libro de Texto, Apress,Inglés,428";
        CSVRow rowbook=new CSVRow(header);
        rowbook.setLine(book);

        Publicacion p=new Publicacion("978-1-4842-4827-0","Building Microservices Applications");
        p.setAutores(new String[] {"Harsh Chawla","Hemant Kathuria"});
        p.setLingua("Inglés");
        p.setEditorial("Apress");
        p.setXenero("Libro de Texto");
        p.setPaxinas(273);
        
        CSVRowAdapter<Publicacion> adapter=new PublicacionCSVRowAdapter();
        adapter.setRow(rowbook);
        System.out.println(adapter.getObject());
        
        adapter.setRow(book);
        System.out.println(adapter.getObject());

        adapter.setObject(p);
        System.out.println(adapter.getHeader());
        System.out.println(adapter.getRow());
        
    }
}
