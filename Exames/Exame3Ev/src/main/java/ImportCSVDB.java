


import database.DB;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author alba_
 */
public class ImportCSVDB implements Importable {

    @Override
    public void importPlantillas(String filename) throws Exception {
        try ( BufferedReader ler = new BufferedReader(new FileReader(filename));) {
            ArrayList<String> cifs = new ArrayList<>();//creamos un arraylist de cifs
            ler.readLine();//lemos a cabeceira pero non a recollemos
            String linea = ler.readLine();
            while (linea != null) {
                String[] lineas = linea.split(","); //troceamos e gardamos
                if (!lineas[0].startsWith("*")) {//comprobamos se empeza por "*"
                    if (!(lineas.length == 3 || lineas.length == 6)) {
                        throw new Exception("Os datos non son correctos");
                    }
                    if (lineas.length == 3) {
                        String sql = "INSERT INTO traballadores(dni,nome,apelidos,cif) VALUES (?,?,?,?)";
                        try ( Connection con = DB.getConnection();  PreparedStatement stmt = con.prepareStatement(sql);) {
                            //engadimos os datos a traballadores.dat
                            stmt.setString(1, lineas[0]);
                            stmt.setString(2, lineas[1]);
                            stmt.setString(3, lineas[2]);
                            stmt.setString(4, null);
                            stmt.execute();//executamos sentencia
                        }
                    } else {
                        String sql = "INSERT INTO traballadores(dni,nome,apelidos,cif) VALUES (?,?,?,?)";
                        String sql2 = "INSERT INTO empresas(cif,nome,razonsocial) VALUES (?,?,?)";
                        try ( Connection con = DB.getConnection();  PreparedStatement stmt = con.prepareStatement(sql);  PreparedStatement stmt2 = con.prepareStatement(sql2);) {
                            //engadimos os datos a traballadores.dat
                            stmt.setString(1, lineas[0]);
                            stmt.setString(2, lineas[1]);
                            stmt.setString(3, lineas[2]);
                            stmt.setString(4, lineas[3]);
                            if (!cifs.contains(lineas[3])) {
                                cifs.add(lineas[3]);//engadimos o cif ao arraylist
                                stmt2.setString(1, lineas[3]);
                                stmt2.setString(2, lineas[4]);
                                stmt2.setString(3, lineas[5]);
                            }
                            //excutamos
                            stmt.executeUpdate();
                            stmt2.executeUpdate();
                        }
                    }
                }
                ler.readLine();//lemos outra liña
            }
        }
    }

}
