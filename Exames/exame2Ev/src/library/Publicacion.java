/*************************EXERCICIO 1 - 2AVALIACION ***************************************/

package library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Clase que pode ser comparable con outra Publicacion por titulo, para elo
 * implementamos a interface Comparable<Publicacion> para poder comparar dúas Publicacions
 * @author alba
 */

public class Publicacion implements Comparable<Publicacion> {//implementamos a interface Comparable
    //declaramos os atributos da clase:
    private final String isbn;
    private final String titulo;
    private String xenero;
    private String editorial;
    private String lingua;
    private int paxinas;
    private ArrayList<String> autores;

    /**
     * declaramos o constructor con dous argumentos
     * @param isbn
     * @param titulo 
     */
    public Publicacion(String isbn, String titulo) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autores=new ArrayList<>();//inicializamos o arraylist
    }
    
    /**************************insertamos os getters***************************/
    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getXenero() {
        return xenero;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getLingua() {
        return lingua;
    }

    public int getPaxinas() {
        return paxinas;
    }
    
        
    /**************************insertamos os setters***************************/
    public void setXenero(String xenero) {
        this.xenero = xenero;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public void setPaxinas(int paxinas) {
        this.paxinas = paxinas;
    }
    
    /*********************insertamos os seguintes métodos***************************/
    /**
     * método que engadirá o autor como autor da Publicación cos seus autores existentes
     * @param autor - autor que queremos engadir
     */
    public void addAutor(String autor){
        autores.add(autor);   
    }
    
    /**
     * método que elimina un autor indicado da Publicacion. Se o autor non existe, non fai nada
     * @param autor - autor que queremos eliminar
     */
    public void delAutor(String autor){
        autores.remove(autor);    
    }
    
    /**
     * método que retorna un String[] cos autores da Publicacion
     * @return - String[]
     */
    public String[] getAutores(){
        //return (String[])autores.toArray(); //podemos facer un casting para que o interprete ben
        return autores.toArray(new String[0]); //outro xeito
    }
    
    /**
     * método que poñerá os autores indicados como autores da Publicación
     * @param autores - autores da Publicacion
     */
    public void setAutores(String[] autores){
        this.autores.clear();//eliminamos primeiro os autores da Publicacion
//      //1. forma simple. Recorremos os autores[] e os engadimos:
//        for (int i = 0; i < autores.length; i++) {
//            this.autores.add(autores[i]);
//        }
        
        //2. outra forma:
//        Arrays.asList(autores); //para pasar un array de autores a unha lista de autores 
        this.autores.addAll(Arrays.asList(autores));  //pasamos un array a unha lista 
    }
    
    /**
     * método que poñerá o autor indicado como autor único da Publicacion 
     * @param autor 
     */
    public void setAutor(String autor){
        this.autores.clear(); //elimina os autores que houbera
        this.autores.add(autor);//engade o autor    
    }
       
    /**
     * método que retornará o autor da Publicacion do primeiro lugar ou null 
     * se non temos ningún autor
     * @return - devolve o primeiro autor ou null
     */
    public String getAutor(){
        if (!this.autores.isEmpty()) //comprobamos se non está baleiro
            return this.autores.get(0);
        return null; //se está baleiro devolverá null   
    }
        
    /******************************método compareTo*******************************/ 
    /**
     * método que compara dúas Publicacións por título e devolve 0 se son iguais,
     * -1 se é minor e 1 se é maior
     * @param o - outra publicación
     * @return - devolve un int (0, 1 ou -1)
     */
    @Override
    public int compareTo(Publicacion o) {
        return titulo.compareTo(o.titulo);//xa devolve se é maior, menor ou igual        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.isbn);
        return hash;
    }

    /******************************método equals*******************************/ 
    /**
     * método que di se dous obxectos Publicación son iguais se os seus isbn son iguais
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Publicacion other = (Publicacion) obj;
        return Objects.equals(this.isbn, other.isbn);
    }

    /******************************método to String*******************************/ 
    /**
     * método que fai a representación como String dunha Publicación
     * @return 
     */
    @Override
    public String toString() {
        return "isbn=" + isbn + ", titulo=" + titulo + ", xenero=" + xenero + ", editorial=" 
                + editorial + ", lingua=" + lingua + ", paxinas=" + paxinas + ", autores=" + autores;
    }
    
   
}//fin class
