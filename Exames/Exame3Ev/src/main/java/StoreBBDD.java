


import database.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Clase que permite realizar todas as consultas descritas
 *
 * @author alba_
 */
public class StoreBBDD implements Store {

    /**
     * método que devolve os traballadores ordeados polo dni
     * @return
     * @throws Exception 
     */
    @Override
    public Traballador[] getTraballadores() throws Exception {
        String consulta = "Select * from traballadores order by dni";
        Connection con = DB.getConnection();//obtenemos a conexión
        Traballador t = null;
        ArrayList<Traballador> traballadores = new ArrayList<>();
        try ( PreparedStatement stmt = con.prepareStatement(consulta);) {
            //agregamos os valores:
            ResultSet resultado = stmt.executeQuery(); //executamos e recollemos os datos na variable resultado
            while (resultado.next()) {
                t = new Traballador(resultado.getString(1), resultado.getString(2), resultado.getString(3));
                t.setEmpresa(resultado.getString(4));
                traballadores.add(t);
            }
        }
        return traballadores.toArray(new Traballador[0]);//convertemos o arraylist a array
    }
    
    /**
     * método que devolve todas as empresas ordeadas polo cif
     * @return
     * @throws Exception 
     */
    @Override
    public Empresa[] getEmpresas() throws Exception {
        String consulta = "Select * from empresas order by cif";
        Connection con = DB.getConnection();//obtenemos a conexión
        Empresa e = null;
        ArrayList<Empresa> empresas = new ArrayList<>();
        try ( PreparedStatement stmt = con.prepareStatement(consulta);) {
            //agregamos os valores:
            ResultSet resultado = stmt.executeQuery(); //executamos e recollemos os datos na variable resultado
            while (resultado.next()) {
                e = new Empresa(resultado.getString(1), resultado.getString(2), resultado.getString(3));
                empresas.add(e);
            }
        }
        return empresas.toArray(new Empresa[0]);//convertemos o arraylist a array
    }

    /**
     * método que devolve todos os traballadores dunha empresa
     * @param cif
     * @return
     * @throws Exception 
     */
    @Override
    public Traballador[] getTraballadores(String cif) throws Exception {
        String consulta = "Select * from traballadores where cif = ?";
        Connection con = DB.getConnection();//obtenemos a conexión
        Traballador te = null;
        ArrayList<Traballador> traballadoresEmp = new ArrayList<>();
        try ( PreparedStatement stmt = con.prepareStatement(consulta);) {
            //agregamos os valores:
            stmt.setString(1, cif); //engadimos o primeiro value
            ResultSet resultado = stmt.executeQuery(); //executamos e recollemos os datos na variable resultado
            if (resultado.next()) {
                te = new Traballador(resultado.getString(1), resultado.getString(2), resultado.getString(3));
                te.setEmpresa(cif);
                traballadoresEmp.add(te);
            }
        }
        return traballadoresEmp.toArray(new Traballador[0]);
    }

    /**
     * método que devolve un traballador cun dni especificado
     * @param dni
     * @return
     * @throws Exception 
     */
    @Override
    public Traballador getTraballador(String dni) throws Exception {
        String consulta = "Select * from traballadores where dni = ?";
        Connection con = DB.getConnection();//obtenemos a conexión
        Traballador t = null;
        try ( PreparedStatement stmt = con.prepareStatement(consulta);) {
            //agregamos os valores:
            stmt.setString(1, dni); //engadimos o primeiro value
            ResultSet resultado = stmt.executeQuery(); //executamos e recollemos os datos na variable resultado
            if (resultado.next()) {
                t = new Traballador(dni, resultado.getString(2), resultado.getString(3));
                t.setEmpresa(resultado.getString(4));
            }
        }
        return t; //devolve traballador
    }

    /**
     * método que devolve a empresa segundo un cif especificado
     * @param cif
     * @return
     * @throws Exception 
     */
    @Override
    public Empresa getEmpresa(String cif) throws Exception {
        String consulta = "Select * from empresas where cif = ?";
        Connection con = DB.getConnection();//obtenemos a conexión
        Empresa e = null;
        try ( PreparedStatement stmt = con.prepareStatement(consulta);) {
            //agregamos os valores:
            stmt.setString(1, cif); //engadimos o primeiro value
            ResultSet resultado = stmt.executeQuery(); //executamos e recollemos os datos na variable resultado
            if (resultado.next()) {
                e = new Empresa(cif, resultado.getString(2), resultado.getString(3));
            }
        }
        return e; //devolve traballador
    }

    /**
     * método que devolve todos os traballadores en paro da BBDD
     * @return
     * @throws Exception 
     */
    @Override
    public Traballador[] getTraballadoresParo() throws Exception {
        String consulta = "Select * from traballadores where cif=null";
        Connection con = DB.getConnection();//obtenemos a conexión
        Traballador tp = null;
        ArrayList<Traballador> traballadoresParo = new ArrayList<>();
        try ( PreparedStatement stmt = con.prepareStatement(consulta);) {
            //agregamos os valores:
            ResultSet resultado = stmt.executeQuery(); //executamos e recollemos os datos na variable resultado
            while (resultado.next()) {
                tp = new Traballador(resultado.getString(1), resultado.getString(2), resultado.getString(3));
                traballadoresParo.add(tp);
            }
        }
        return traballadoresParo.toArray(new Traballador[0]);//convertemos o arraylist a array
    }

    /**
     * método que pecha a clase. o deixamos baleiro porque non queremos que peche a conexión desde aquí
     * @throws Exception 
     */
    @Override
    public void close() throws Exception {

    }

}
