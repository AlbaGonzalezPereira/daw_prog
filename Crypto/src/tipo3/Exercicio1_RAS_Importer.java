package tipo3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class Exercicio1_RAS_Importer implements Importer {
    public void importData() {
        TreeMap<String,Long> index=new TreeMap<>();
        //cando importemos os datos a resultados tamén temos que importar os índices
        try (BufferedReader rdr=new BufferedReader(new FileReader("datos.txt"));//crea o arquivo datos.txt
             RandomAccessFile ras=new RandomAccessFile("resultados.txt","rws");//crea o ras
             DataOutputStream out=new DataOutputStream(new FileOutputStream("resultados.idx"))) {//onde garda o índice
             String line=rdr.readLine();
             while(line != null){
                 Usuario u = Usuario.fromString(line);//lemos a liña e obtemos o usuario
                 long ind = ras.getFilePointer();//para que nos colla o índice antes de escribir
                 //escribimos no ficheiro ras
                 ras.writeUTF(u.getDni());
                 ras.writeUTF(u.getNome());
                 ras.writeUTF(String.valueOf(u.getIdade()));
                 ras.getFilePointer();
                 index.put(u.getDni(),ind);//collemos o dni e o ind, o temos en memoria
                 line=rdr.readLine();//lemos outra liña             
             }
            //collemos todos os dni do Treemap index
             Set<String> dnis = index.keySet();
             for (String dni : dnis) {//os recorremos
                 out.writeUTF(dni);//escribo o dni
                 out.writeLong(index.get(dni));//escribimos o índice
            }
           
        } catch(Exception ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Exercicio1_RAS_Importer importer=new Exercicio1_RAS_Importer();
        importer.importData();
    }
}
