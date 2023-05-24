/*************************EXERCICIO 3 - 2AVALIACION ***************************************/

package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * clase que é capaz de dividir un String nun conxunto de Strings (Tokens), tomando 
 unha cadea de texto como separator.
 * Clase Iterable que permite recorrer os tokens
 * @author alba_
 */
public class Tokenizer implements Iterable<String>{
    private String separator;
    private ArrayList<String> tokens;
    private String cadea;

    /**
     * constructor baleiro que ten como separator unha ","
     */
    public Tokenizer() {
        this(","); //chamamos ao constructor con argumentos para non duplicar código    
    }

    /**
     * constructor con un argumento que o separator a utilizar
     * @param separador 
     */
    public Tokenizer(String separador) {
        this.separator = separador;
        this.tokens = new ArrayList<>();
        this.cadea = null;
    }
    
    /****************************insertamos os métodos******************************/
    /**
     * método privado, é dicir, só o podemos chamar dentro da mesma clase, que vai cortar
     * a cadea en trozos (tokens) sen espazos nin comiñas.
     */
    private void scanData(){ 
        //Solución básica:
        String[] tk = cadea.split(this.separator);
        for (int i = 0; i < tk.length; i++) {//recorremos o array
            this.tokens.add(tk[i].trim()); //usamos o método trim() para que nos elimine os espazos  
        }
        //Outro xeito:
        //tokens.addAll(Arrays.asList(cadea.split(this.separator))); //non podemos facer o método trim()   
    }
    
    /**
     * método que permite indicar o String que se vai "tokenizar"
     * @param data - String a tokenizar
     */
    public void setString(String data){
        cadea = data.replaceAll("\n", "");//para limpar os saltos de liña por ""
        scanData(); //chamamos ao método scanData() para que divida data    
    }
    
    /**
     * método que cambia o separador
     * @param separator 
     */
    public void setSeparator(String separator){
        this.separator = separator;    
    }
    
    /**
     * método que devolve o String orixinal "tokenizado". Retornará null se non temos
     * ningún String dividido
     * @return 
     */
    public String getString(){
        if (tokens.size()>0) //comprobamos que foi tokenizado
            return cadea;
        return null; //se non hai cadeas divididas       
    }
    
    /**
     * método que retorna un String[] cos Tokens que compoñen o String
     * @return 
     */
    public String[] getTokens(){
        return tokens.toArray(new String[0]);   
    }
    
    /**
     * método devolve un token número idx do String. Se non existe devolve null
     * @param idx
     * @return 
     */
    public String getTokens(int idx){
        if(idx < tokens.size())
            return tokens.get(idx);  
        return null;
    } 
    
    /**
     * método que devolve o número de tokens no que se dividiu o String
     * @return 
     */
    public int numTokens(){
        return tokens.size();
    }

    /**
     * método que permite recorrer os Tokens nos que se divide o String
     * @return 
     */
    @Override
    public Iterator<String> iterator() {
        return tokens.iterator();        
    }
    
    
}//fin class
