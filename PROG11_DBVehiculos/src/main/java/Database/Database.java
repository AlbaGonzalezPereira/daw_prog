package Database;

/**
 * Clase que define unha API de acceso a datos
 * @author alba
 * @param <R> - Tipo de datos a xestionar na Base de Datos (Clase do obxecto que queremos xestionar)
 * @param <T> - Tipo de datos para a chave
 */
public interface Database<R,T> {
    /**
     * Inserta un novo rexistro na Base de Datos
     * @param data Información a insertar na base de datos
     * @return - número de elementos insertados
     * @throws DatabaseException  
     * 
     * O rexistro a insertar non debe existir. Si existe, se lanzará unha DatabaseException coa
     * mensaxe "O rexistro xa existe"
     */
    public int insert(R data) throws DatabaseException;
    
    /**
     * Actualiza un rexistro existente na Base de datos
     * @param data Información a Actualizar
     * @return - número de elementos actualizados
     * @throws DatabaseException 
     * 
     * O rexistro a actualizar debe existir. Si non existe, se lanzará unha DatabaseException coa
     * mensaxe "O rexistro non existe"
     */
    public int update(R data) throws DatabaseException;
    
    
    /**
     * Inserta (si non existe) ou actualiza (si existe) un rexistro na base de datos
     * @param data Información a actualizar / insertar
     * @return - número de elementos insertados ou actualizados
     * @throws DatabaseException 
     */
    public int insertOrUpdate(R data) throws DatabaseException;
    
    /**
     * Elimina un rexistro da base de datos
     * @param data - Rexistro a eliminar
     * @throws DatabaseException 
     * 
     * Lanza DatabaseException coa mensaxe "O rexistro non existe" en caso de non existir
     */
    public void delete(R data) throws DatabaseException;
    
    
    /**
     * Elimina un rexistro ou varios da bse de datos
     * @param c Criterio que deben cumplir os rexistros a ser eliminados
     * @return Un array coa información dos rexistros eliminados. 
     * @throws DatabaseException 
     * 
     * Si non se elimina ningún rexistro, retornará null en lugar dun array
     */
    public R[] delete(Criteria<R> c) throws DatabaseException;
    
    /**
     * Consulta rexistros na base de datos
     * @param c Criterio que deben cumplir o rexistro
     * @return Un array cos rexistros que cumplen o criterio
     * @throws DatabaseException 
     * 
     * Si ningún rexistro cumple o criterio retornará null.
     */
    public R[] select(Criteria<R> c) throws DatabaseException;
    
    public R select (T key) throws DatabaseException;
}
