package tests;

import java.util.Arrays;
import java.util.List;
import csv.CSVRow;

public class CSVRowTest {
    // Contemplamos un máximo de tres autores.
    static String strheader="isbn,titulo,autor,autor,autor,xenero,editorial,lingua,paxinas";
    static String[] header={"isbn","titulo","autor","autor","autor","xenero","editorial","lingua","paxinas"};
    static List<String> lheader=Arrays.asList(header);
    static String testline="978-1-4842-4827-0,Building Microservices Applications on Microsoft Azure,"
                + "Harsh Chawla,Hemant Kathuria,,Libro de Texto,Apress,Inglés,618";

    public static void main(String[] args) {
        System.out.println("Test con constructor String");
        CSVRow row=new CSVRow(strheader);
        showTest(row);
        System.out.println("\nTest con constructor Array");
        row=new CSVRow(header);
        showTest(row);
        System.out.println("\nTest con constructor List");
        row=new CSVRow(lheader);
        showTest(row);
    }
    
    private static void showTest(CSVRow row) {
        System.out.println("Row Header: "+row.getHeader());
        row.addValue("isbn","00-0000-00-00");
        row.addValue("titulo","Libro de Proba");
        row.addValue("autor","Autor de Proba 1");
        row.addValue("xenero","Test de CSVRow");
        row.addValue("lingua","galego");
        row.addValue("autor","Autor de Proba 2");
        row.addValue("paxinas","0");
        row.addValue("autor","Autor de Proba 3");
        System.out.println("Row Data: "+row);
        System.out.println("Autores: "+Arrays.toString(row.getValues("Autor")));
        System.out.println("Titulo:"+row.getValue("titulo"));
        System.out.println("Editorial:"+row.getValue("editorial"));
        System.out.println("--> Cambiando autores");
        row.setValue("autor",new String[] {"autor1","autor2"});
        System.out.println("Row Data: "+row);
        System.out.println("Autores: "+Arrays.toString(row.getValues("autor")));
        System.out.println("Titulo:"+row.getValue("titulo"));
        System.out.println("Editorial:"+row.getValue("editorial"));
        System.out.println("--> Poñendo información a partir de String");
        row.setLine(testline);
        System.out.println("Row Data: "+row);
        System.out.println("Autores: "+Arrays.toString(row.getValues("autor")));
        System.out.println("Titulo:"+row.getValue("Titulo"));
        System.out.println("Editorial:"+row.getValue("eDitoRial"));

        try {
            System.out.println("Campo Inexistente: "+row.getValue("blabla"));
        } catch(IllegalArgumentException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
