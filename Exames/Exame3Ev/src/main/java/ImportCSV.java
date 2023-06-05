
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author alba_
 */
public class ImportCSV implements Importable {

    @Override
    public void importPlantillas(String filename) throws Exception {
        try(BufferedReader ler = new BufferedReader(new FileReader(filename));
            RandomAccessFile ras = new RandomAccessFile(new File("traballadores.dat"), "rws");  
            RandomAccessFile ras2 = new RandomAccessFile(new File("empresas.dat"), "rws");){
            ArrayList<String> cifs = new ArrayList<>();//creamos un arraylist de cifs
            ler.readLine();//lemos a cabeceira pero non a recollemos
            String linea = ler.readLine();
            while(linea !=null){
                String[] lineas = linea.split(","); //troceamos e gardamos
                if(!lineas[0].startsWith("*")){//comprobamos se empeza por "*"
                    if(!(lineas.length==3 || lineas.length==6)) throw new Exception("Os datos non son correctos");
                    if(lineas.length == 3){
                        //engadimos os datos a traballadores.dat
                        ras.writeUTF(lineas[0]);
                        ras.writeUTF(lineas[1]);
                        ras.writeUTF(lineas[2]); 
                        ras.writeUTF("*"); //traballador en paro
                    }else{
                        ras.writeUTF(lineas[0]);
                        ras.writeUTF(lineas[1]);
                        ras.writeUTF(lineas[2]);
                        ras.writeUTF(lineas[3]);//traballador empresa
                        //engadimos os datos a empresas.dat
                        if(!cifs.contains(lineas[3])){//se non contén o cif o engadimos
                            cifs.add(lineas[3]); //engadimos o cif ao arrayList
                            ras2.writeUTF(lineas[3]);
                            ras2.writeUTF(lineas[4]);
                            ras2.writeUTF(lineas[5]); 
                        }
                    }
                    
                }
                ler.readLine();//lemos outra liña
            }   
        }
        
    }
    
}
