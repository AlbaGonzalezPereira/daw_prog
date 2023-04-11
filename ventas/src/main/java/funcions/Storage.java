package funcions;

import java.util.function.Predicate;

/**
 *Interface que permite almacenar obxectos, eliminalos ou recuperalos
 * @author alba_
 */
public interface Storage<K,V> {
    public V store(V obxecto) throws VerboseException;
    public V delete(K valor) throws VerboseException;
    public V[] remove(Predicate<V> p) throws VerboseException;
    public V[] search(Predicate<V> p) throws VerboseException;
    public V find(K valor) throws VerboseException;
    public V[] all();
    
}
