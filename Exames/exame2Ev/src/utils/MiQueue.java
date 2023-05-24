/*************************EXERCICIO 2 - 2AVALIACION ***************************************/

package utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

/**
 * clase que ten unha estructura tipo FIFO, na que o elemento que se lee do Queue 
 * é o que leva almacenado máis tempo.
 * Tratarase dunha clase que hereda de ArrayList e que implementa a clase Queue
 * @author alba_
 */
public class MiQueue<T> extends ArrayList<T> implements Queue<T> {

    //engadimos o método add(T e) xa que non se engade automaticamente ao estar heredado. 
    //Hai que engadilo a man
    /**
     * method that inserts the specified element into this queue if it is possible to do so 
     * immediately without violating capacity restrictions, returning true upon success 
     * and throwing an IllegalStateException if no space is currently available.
     * @param e
     * @return 
     */
    @Override
    public boolean add(T e) {       
        if(e==null)
            throw new NullPointerException("Esta Queue non acepta valores nulos");    
        return super.add(e); 
    }
    
    /**
     * method that inserts the specified element into this queue if it is possible 
     * to do so immediately without violating capacity restrictions.
     * @param e
     * @return 
     */
    @Override
    public boolean offer(T e) {
        return add(e); //chamamos ao método anterior sobreescrito
    }

    /**
     * method that retrieves and removes the head of this queue.
     * @return 
     */
    @Override
    public T remove() {
        return remove(0);        
    }

    /**
     * method that retrieves and removes the head of this queue, or returns null 
     * if this queue is empty.
     * @return 
     */
    @Override
    public T poll() {
        if(!isEmpty())
            return remove(); //chama ao método de enriba
            //return remove(0); //se queremos utilizar o método remove do pai
        return null;        
    }

    /**
     * method that retrieves, but does not remove, the head of this queue.
     * @return 
     */
    @Override
    public T element() {
        return get(0);
    }

    /**
     * method that retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     * @return 
     */
    @Override
    public T peek() {
        if(!isEmpty())
            return element(); //usamos o método anterior para que devolva a cabeza da cola
            //return get(0); //sería doutro xeito
        return null;          
    }

    /**
     * método que nos permite percorrer os elementos mediante un iterator e ir eliminando 
     * da cola os elementos.
     * ArrayList xa implementa este método pero debemos modificalo
     * @return 
     */
    @Override
    public Iterator<T> iterator() {
        MiQueue<T> that=this;
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {//para saber se hai seguinte
                if(!isEmpty()) // poderíamos usar tamén if(size()>0)
                    return true;
                return false;
            }

            @Override
            public T next() { //ten que ir eliminando
                return that.remove();
            }
        };
    }
    

}//fin class
