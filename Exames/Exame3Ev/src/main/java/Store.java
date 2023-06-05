
import java.io.Closeable;

/**
 *
 * @author alba_
 */

public interface Store extends AutoCloseable {
    public Traballador[] getTraballadores() throws Exception;
    public Empresa[] getEmpresas() throws Exception;
    public Traballador[] getTraballadores (String cif) throws Exception;
    public Traballador getTraballador(String dni) throws Exception;
    public Empresa getEmpresa(String cif) throws Exception;
    public Traballador[] getTraballadoresParo() throws Exception;
    
}
