package tests;

import utils.Tokenizer;

public class TokenizerTest {
    public static void main(String[] args) {
        Tokenizer tk=new Tokenizer();
        System.out.println("Test 1 - Basico");
        for(String s:tk) System.out.println("TOKEN: "+s);
        tk.setString("frase, isto\n é, como\n non, unha frase");
        for(String s:tk) System.out.println("\tTOKEN: "+s);
        tk.setString(null);
        for(String s:tk) System.out.println("\tTOKEN: "+s);
        System.out.println();
        tk.setString("varias,palabras,separadas por varias, comas");
        tk.forEach(t->System.out.println("\tTOKEN: "+t));
        
        
        System.out.println("\nTest 2 - Avanzado");
        tk.setString("frase, \"isto é, como non, unha frase\", de exemplo");
        tk.forEach(s->System.out.println("\tTOKEN: "+s));
        
        System.out.println("\nTest 3 - Completo");
        tk.setString("frase,\"isto é (\"imos, a ver...\"), algo\",\"estupendo\"");
        for(String s:tk) System.out.println("\tTOKEN: "+s);
    }       
}
