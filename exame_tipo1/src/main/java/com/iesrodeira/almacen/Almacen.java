package com.iesrodeira.almacen;

/**
 *Clase do almacén
 * @author alba_
 */
public class Almacen {
   private final int MAX_ARTIGOS = 4096;
   private Artigo[] artigos;
   private static int numArtigos;

   /**
    * Creamos o construtor da clase almacén, inicializando numArtigos a 0, 
    * xa que de momento non hai e establecendo o máximo de artigos (4096)
    */
    public Almacen() {
        artigos=new Artigo[MAX_ARTIGOS];
        numArtigos=0;
    }

   
//    public static void sumArtigo(){
//           numArtigos++;
//}
    
    /**
     * Creamos o engadirArtigoAlmacen(Artigo artigo) para que cada vez que 
     * creemos un artigo novo, vaia sumando 1 a numAtigos
     * @param artigo 
     */
    public void engadirArtigoAlmacen(Artigo artigo){
        this.artigos[numArtigos]=artigo;
        numArtigos++;
    }
    
    public boolean haiSitio(){
        if (numArtigos < MAX_ARTIGOS)
            return true;
        System.out.println("Non hai sitio no almacén");
        return false;
    }

    public Artigo[] getArtigos() {
        return artigos;
    }

    public void setArtigos(Artigo[] artigos) {
        this.artigos = artigos;
    }

    public static int getNumArtigos() {
        return numArtigos;
    }

    public static void setNumArtigos(int numArtigos) {
        Almacen.numArtigos = numArtigos;
    }
    
}
