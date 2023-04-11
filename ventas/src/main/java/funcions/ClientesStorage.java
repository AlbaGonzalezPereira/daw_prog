package funcions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;
import java.util.function.Predicate;

/**
 *Clase para xestionar o almacenamento dos obxectos Cliente
 * @author alba_
 */
public class ClientesStorage implements Storage<String, Cliente>{
    TreeMap<String,Cliente> almacenClientes=new TreeMap<>();

    /**
     * método que almacena un cliente e devolve o antigo se xa existe
     * @param obxecto
     * @return
     * @throws VerboseException 
     */
    @Override
    public Cliente store(Cliente obxecto) throws VerboseException {
        if(obxecto==null)
            throw new VerboseException("ERROR: ", "Cliente mal introducido");
        if(almacenClientes.containsKey(obxecto.getDni()))
            return almacenClientes.get(obxecto.getDni());
        else
            return almacenClientes.put(obxecto.getDni(), obxecto);
    }

    @Override
    public Cliente delete(String valor) throws VerboseException {
        if(valor==null)
            throw new VerboseException("ERROR: ", "Non existe ese dni");
        if(almacenClientes.containsKey(valor))
            return almacenClientes.remove(valor);
        else
            return null;
        
    }

    @Override
    public Cliente[] remove(Predicate<Cliente> p) throws VerboseException {
        //ArrayList<Cliente> eliminados = new ArrayList<>();
        Cliente[] eliminado = search(p);
        for (int i = 0; i < eliminado.length; i++) {
            almacenClientes.remove(eliminado[i].getDni());  
        }
        return eliminado;
        
    }

    @Override
    public Cliente[] search(Predicate<Cliente> p) throws VerboseException {
        ArrayList<Cliente> buscados = new ArrayList<>();
        Collection<Cliente> valores=almacenClientes.values();
        for (Cliente valor : valores) {
            if(p.test(valor)){
                buscados.add(valor);
            }
            
        }
        return buscados.toArray(new Cliente[0]); //non entendo esta liña de código
    }

    @Override
    public Cliente find(String valor) throws VerboseException {
        if(almacenClientes.containsValue(valor))
            return almacenClientes.get(valor);//cando non o atopa xa devolve null
        return null;
        
                   
    }

    @Override
    public Cliente[] all() {
        Collection<Cliente> todosValores=almacenClientes.values();
        return todosValores.toArray(new Cliente[0]);
        
    }
    
}
