/*************************EXERCICIO 4.1 - 2AVALIACION ***************************************/

package storage;

import java.util.Iterator;

/**
 * interface que é capaz de xestionar o almacenamento de calquera clase de obxectos.
 * é iterable, polo tanto, herda de Iterable
 * Fai uso de tipos xenéricos.
 * Pode ser implantado de moitos xeitos facendo uso de distintas estruturas.
 * Os seus métodos non son implantables
 * @author alba_
 */
public interface Almacen<T> extends Iterable<T> {//indicamos que fai uso de tipos xenéricos
    
    /**********************insertamos os métodos********************************/
    
    public boolean engadir(T obxecto) throws Exception;
    
    public T[] cargar(Filtro f, T[] informacion) throws Exception;
    
    public T[] cargar(T[] informacion)throws Exception;
    
    public int eliminar(Filtro f) throws Exception;
    
    public int eliminar(T obxecto) throws Exception;
    
    public boolean modificar(T obxecto) throws Exception;
    
    public boolean gardar(T obxecto) throws Exception;
    
    
    
    
}
