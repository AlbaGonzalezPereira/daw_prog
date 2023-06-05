/**
 *
 * @author alba_
 */
public class Exercicio1 {

    public static void main(String[] args) {
        ImportCSV impCsv = new ImportCSV();
        try {
            impCsv.importPlantillas("Plantillas.csv");
        } catch (Exception ex) {
            System.out.println("Erro ao importar as plantillas" + ex.getMessage());
        }
    }
}
