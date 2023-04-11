package funcions;

/**
 *Clase interfaz cos métodos getStock, addStrock, setStock
 * @author alba_
 */
public interface Stock {
    //engadimos os métodos:
    Integer getStock(String codigo);
    void addStock(String codigo, Integer num) throws VerboseException;
    void setStock(String codigo, Integer num) throws VerboseException;
    
    
}
