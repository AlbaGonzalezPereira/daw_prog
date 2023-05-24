/*************************EXERCICIO 5 - 2AVALIACION ***************************************/
//Clase sen rematar
package csv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import utils.Tokenizer;

/**
 * Clase que xestiona unha liña de datos dun ficheiro csv
 * @author alba_
 */
public class CSVRow {
    //declaramos os atributos:
    private ArrayList<String> cabecera = new ArrayList<>();;//ArrayList de String
    //creamos un HashMap que terá unha chave que será un String e un valor que será un ArrayList
    private HashMap<String,ArrayList<String>> row = new HashMap<>();//permite almacenar e recuperar os datos rapidamente

    /**************************insertamos constructores*************************/
    /**
     * constructor que recibe un String que define a cabeceira do CSV, que debe dividir 
     * o String utilizando “,” como separador
     * @param header 
     */
    public CSVRow(String header) {
        header=header.toLowerCase();//para que pase todo a minúsculas e xa non teña que distinguir
//        this.cabecera = new ArrayList<>();//inicializamos cabecera
        Tokenizer tk = new Tokenizer(); //por defecto era ","
        tk.setString(header);//tokenizamos o header
        this.cabecera.addAll(Arrays.asList(tk.getTokens()));
    }

    /**
     * constructor que recibe un ArrayList cos nomes das columnas, que utilizaremos para 
     * inicializar a estrutura de datos que almacenará a información de cada campo
     * @param header 
     */
    public CSVRow(List<String> header) {
        this.cabecera.addAll(header);
//        //poderiamos facelo cun fore
//        for (String h : header) {
//            cabecera.add(h);
//        }
    }

    /**
     * constructor que recibe un String[] cos nomes das columnas, que utilizaremos para 
     * inicializar a estrutura de datos que almacenará a información de cada campo.
     * @param header 
     */
    public CSVRow(String[] header) {
        this.cabecera.addAll(Arrays.asList(header));
//        //poderiamos facelo asi:
//        for (int i = 0; i < header.length; i++) {
//            cabecera.add(header[i]);            
//        }
    }

/******************************insertamos os métodos****************************/
/**
 * método que devolve un String representando a cabeceira do CSV. Cada elemento 
 * aparecerá entre comiñas e sen espazos no inicio e final de cada String: 
 * “isbn”, “titulo”, “autor”, “autor”, “xenero”, “editorial”, “lingua”.
 * @return 
 */    
    public String getHeader(){
        String header = "";
        for (String h : cabecera) {
//            header += '"' + h + '"' + " "; 
              header += '"' + h + '"';
        }
        //outro xeito:
//        header=header.trim();
//        header=header.replaceAll(" ", ", ");
        return String.join(", ", header);
    }
    
    /**
     * método que recibe unha liña de datos do CSV. Debe separar os valores 
     * utilizando “,” como separador e almacenar a información asociada a columna 
     * correspondente. Si liña de datos ten distinto número de elementos que a 
     * cabeceira se producirá unha IllegalArgumentException coa mensaxe “Liña de 
     * datos errónea”.
     * @param data 
     */
    public void setLine(String data){
        //creamos un obxecto Tokenizer para cortar o string
        Tokenizer tk = new Tokenizer(); //por defecto era ","
        tk.setString(data);//tokenizamos o String
        
        //se o número de datos é diferente:
        if(tk.numTokens()!=cabecera.size()){
            throw new IllegalArgumentException("Liña de datos errónea");
        }
        
        int f = 0; //declaramos o primeiro índice
        for (String toks : tk) {//recorremos todos los tk de antes
            String valorCabecera = cabecera.get(f);//recolle o nome da cabeceira 
            ArrayList<String> datos = row.get(valorCabecera.toLowerCase()); //temos o arraylist
            if(!toks.isBlank()) //comprobamos que no estea en blanco
                datos.add(toks);//engadimos toks ao arraylist
            f++; //aumentamos o índice       
        }       
    }
    
    /**
     * método que retorna un array con todos os valores asociados a un campo. Si 
     * o campo non existe lanza unha IllegalArgumentException coa mensaxe axeitada.
     * @param field
     * @return 
     */
    public String[] getValues(String field){
        if(!cabecera.contains(field)){
            throw new IllegalArgumentException("Non existe ese campo");
        }
        return null;
    
    }
    
    
    
    
    
    
}
