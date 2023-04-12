/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import java.io.IOException;
import csv.CSV;
import csv.CSVRow;
import utils.DataReader;
import utils.DataWriter;

public class CSVTest {
    private static final String DATAPATH=CSV.class.getResource("/resources").getPath();
    
    public static void main(String[] args) throws IOException {
        String header="Nome,Direccion,Telefono";
        CSV csvdata=new CSV(header);
        csvdata.addRow("Juan Gonzalez Crespo,Avenida de Lugo 132 4ºA, 675431122");
        csvdata.addRow("María Núñez Núñez,Rúa Leitariegos 23 Baixo, 675334512");
        System.out.println(csvdata);
 
        // DataReader está feita no package utils
        String[] info=DataReader.read(DATAPATH+"/"+"Publicacion.csv");
        System.out.println("\nProcesado CSV "+DATAPATH+"/"+"Publicacion.csv: ");
        CSV csvpublicacion=new CSV(info);
        System.out.println(csvpublicacion);
        
        System.out.println("\nCambiando o autor da primeira fila:");
        CSVRow row=csvpublicacion.getRow(0);
        row.setValue("autor","Eu son o autor");
        System.out.println(csvpublicacion);
        
        // O ficheiro se gardará na carpeta resources pero non en src/resources, se non en build/classes/resources
        System.out.println("\nGardando CSV en PublicacionSaida.csv na carpeta build/classes/resources");
        // DataWriter está feita no package utils
        DataWriter.write(DATAPATH+"/"+"PublicacionSaida.csv",csvpublicacion.getLines());
    }    
}
