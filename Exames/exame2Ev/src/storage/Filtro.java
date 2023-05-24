/*************************EXERCICIO 4.2 - 2AVALIACION ***************************************/

package storage;

/**
 * interface que é capaz de indicar se resulta aceptable ou non un obxecto dun tipo calquera
 * @author alba_
 */
public interface Filtro<T> {//indicamos que fai uso de tipos xenéricos
    boolean match(T obxecto);
}
