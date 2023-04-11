package funcions;

/**
 *Interface Builder que dispón un método build() que permite construir e retornar un obxecto
 * @author alba_
 */
interface Builder<T> {
    public T build() throws VerboseException;
    
}
