package Implementacion;

import Database.DatabaseException;
import Database.IndexedDatabase;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que implementa a clase IndexedDatabase, que se encarga de todas as
 * tarefas
 *
 * @author alba_
 */
public class DatabaseVehiculo extends IndexedDatabase<String, Vehiculo> {

    //insertamos o constructor:
    public DatabaseVehiculo(String filename) {//necesitamos o nome do ficheiro
        super(filename);//chama ao método da clase abstracta pai
    }

    //insertamos os métodos abstractos:
    /**
     * método que devolve a chave do Vehículo
     *
     * @param data
     * @return - key (matricula)
     */
    @Override
    public String getKey(Vehiculo data) {
        if (data == null) {
            return null;
        }
        return data.getMatricula();
    }

    /**
     * método que "elimina" unha fila do ficheiro. O que fai é engadir un "*" na matrícula 
     * para indicar que ese rexistro foi borrado
     * @param ras
     * @throws DatabaseException 
     */
    @Override
    protected void remove(RandomAccessFile ras) throws DatabaseException {
        try {
            ras.writeBytes("*");//insertamos un * na matrícula
        } catch (IOException ex) {
            throw new DatabaseException("DatabaseVehiculo remove: " + ex.getMessage());
        }
        
    }

    @Override
    protected Vehiculo read(RandomAccessFile ras) throws DatabaseException {
        try {
            String rexistro = ras.readLine();
            if (rexistro != null) {
                String[] datos = rexistro.split(";");
                return new Vehiculo(datos[0], datos[1], datos[2], datos[3]);
            }
            return null;
        } catch (EOFException e) {
            return null;
        } catch (IOException ex) {
            throw new DatabaseException("DatabaseVehiculo read: " + ex.getMessage());
        }
    }

    @Override
    protected void write(RandomAccessFile ras, Vehiculo data) throws DatabaseException {
        try {
            ras.writeBytes(data.getMatricula() + ";" + data.getMarca() + ";" + data.getModelo() + ";" + data.getPropietario() + "\n");
        } catch (IOException ex) {
            Logger.getLogger(DatabaseVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que comproba se está borrado un vehículo. Se a matrícula contén
     * un "*" significa que está borrado
     *
     * @param data
     * @return - true ou false
     */
    @Override
    protected boolean isDeleted(Vehiculo data) {
        if (data.getMatricula().contains("*")) {
            return true;
        }
        return false;
    }

}
