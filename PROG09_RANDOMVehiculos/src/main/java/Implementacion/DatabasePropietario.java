package Implementacion;

import Database.DatabaseException;
import Database.IndexedDatabase;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alba_
 */
public class DatabasePropietario extends IndexedDatabase<String, Propietario> {
    
    //insertamos o constructor:
    public DatabasePropietario(String filename) {
        super(filename);
    }

    //insertamos métodos abstractos:
    @Override
    public String getKey(Propietario data) {
        if (data == null) {
            return null;
        }
        return data.getDni();
    }

    @Override
    protected void remove(RandomAccessFile ras) throws DatabaseException {
        try {
            ras.writeBytes("*");//insertamos un * no dni
        } catch (IOException ex) {
            throw new DatabaseException("DatabasePropietario remove: " + ex.getMessage());
        }
    }

    @Override
    protected Propietario read(RandomAccessFile ras) throws DatabaseException {
        try {
            String rexistro = ras.readLine();
            if (rexistro != null) {
                String[] datos = rexistro.split(";");
                return new Propietario(datos[0], datos[1], datos[2]);
            }
            return null;
        } catch (EOFException e) {
            return null;
        } catch (IOException ex) {
            throw new DatabaseException("DatabasePropietario read: " + ex.getMessage());
        }
    }

    @Override
    protected void write(RandomAccessFile ras, Propietario data) throws DatabaseException {
        try {
            ras.writeBytes(data.getDni() + ";" + data.getNome() + ";" + data.getApelidos() + "\n");
        } catch (IOException ex) {
            Logger.getLogger(DatabaseVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected boolean isDeleted(Propietario data) {
        if (data.getDni().contains("*")) {
            return true;
        }
        return false;
    }
    
}
