
package database;

import implementacion.Usuario;

/**
 * Interface que ten os métodos que deben implementarse nas clases que a usa
 * @author alba_
 */
public interface Storage {
    public Usuario get(String dni) throws Exception;
    public void insert(Usuario user) throws Exception;
    public void update(Usuario user) throws Exception;
    public void delete(String dni) throws Exception;
    
}
