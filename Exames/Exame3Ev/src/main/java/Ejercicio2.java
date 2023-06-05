import database.DB;

/**
 *
 * @author alba_
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        try (DB baseDatos = DB.open()){
            ImportCSVDB impDB = new ImportCSVDB();
            impDB.importPlantillas("Plantillas.csv");
        } catch (Exception ex) {
            System.out.println("Erro ao importar os datos á base de datos" + ex.getMessage());
        }        
    }    
}
