
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que xera dous índices para os ficheiros traballadores.dat e
 * empresas.dat utilizando estruturas de almacenamento dinámico en memoria que
 * permitan localizar os traballadores por DNI e as empresas por CIF de xeito
 * óptimo, e listalos por orden de DNI e CIF respectivamente e facilitando e
 * implantando ademais todas as consultas descritas ao inicio deste punto
 *
 * @author alba_
 */
public class StoreFicheiro implements Store {

    //creamos os hashmap para gardar as chaves e a súa posición
    private HashMap<String, Long> indexT = new HashMap<>();
    private HashMap<String, Long> indexE = new HashMap<>();
    File fileT = new File("traballadores.dat");
    File fileE = new File("empresas.dat");
    File fileIt = new File("traballadores.idx");
    File fileIe = new File("empresas.idx");

    /**
     * Constructor
     *
     * @throws IOException
     */
    public StoreFicheiro() throws IOException {
        if (fileIt.exists()) {
            cargarIndexT();//Se existe os carga
        } else {
            makeIndexT();//senón os crea
        }

        if (fileIe.exists()) {
            cargarIndexE();//Se existe os carga
        } else {
            makeIndexE();//senón os crea

        }
    }

    /**
     * método que crea o index dos traballadores coa chave
     *
     * @throws IOException
     */
    private void makeIndexT() throws IOException {
        try ( RandomAccessFile rasT = new RandomAccessFile(fileT, "rws");) {
            while (true) {
                Long posT = rasT.getFilePointer();//devolve a posición do punteiro do ficheiro
                String idT = rasT.readUTF();//lemos a chave
                indexT.put(idT, posT);//metemos a clave e a posición no arquivo
                rasT.readUTF();
                rasT.readUTF();
                rasT.readUTF();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StoreFicheiro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EOFException ex) {
        }
    }

    /**
     * método que crea o index dos traballadores coa chave
     *
     * @throws IOException
     */
    private void makeIndexE() throws IOException {
        try ( RandomAccessFile rasE = new RandomAccessFile(fileE, "rws");) {
            while (true) {
                Long posT = rasE.getFilePointer();//devolve a posición do punteiro do ficheiro
                String idT = rasE.readUTF();//lemos a chave
                indexT.put(idT, posT);//metemos a clave e a posición no arquivo
                rasE.readUTF();
                rasE.readUTF();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StoreFicheiro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EOFException ex) {
        }
    }

    /**
     * método que carga os index das empresa xunto coa chave
     */
    private void cargarIndexE() {
        try ( RandomAccessFile ras2 = new RandomAccessFile(fileIe, "rws");) {
            while (true) {
                String keyE = ras2.readUTF();
                Long pE = ras2.readLong();
                indexT.put(keyE, pE);//introducimos no hashmap
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(StoreFicheiro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EOFException ex) {

        } catch (IOException ex) {
            Logger.getLogger(StoreFicheiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * método que carga os index dos traballadores xunto coas chaves
     */
    private void cargarIndexT() {
        try ( RandomAccessFile ras = new RandomAccessFile(fileIt, "rws");) {
            while (true) {
                String keyT = ras.readUTF();
                Long pT = ras.readLong();
                indexT.put(keyT, pT);//introducimos no hashmap
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StoreFicheiro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EOFException ex) {

        } catch (IOException ex) {
            Logger.getLogger(StoreFicheiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * método que devolve todos os traballadores ordenador polo seu DNI
     *
     * @return
     * @throws Exception
     */
    @Override
    public Traballador[] getTraballadores() throws Exception {
        ArrayList<Traballador> traballadores = new ArrayList<>();
        try ( RandomAccessFile ras = new RandomAccessFile(fileT, "rws");) {
            while (true) {
                String dni = ras.readUTF();
                String nome = ras.readUTF();
                String apelidos = ras.readUTF();
                String cif = ras.readUTF();

                Traballador t = new Traballador(dni, nome, apelidos);
                t.setEmpresa(cif);
                if (!dni.startsWith("*")) {//se o dni non comeza por "*"
                    traballadores.add(t);
                }
            }
        } catch (EOFException ex) {
        }//cando chega ao final
        Traballador[] todosT = traballadores.toArray(new Traballador[0]);
        Arrays.sort(todosT, (Traballador o1, Traballador o2) -> o1.getDni().compareTo(o2.getDni()));//ordena todosT e garda os cambios
        return todosT;//devolvemos o array xa ordenado
    }

    /**
     * método que devolve todas as empresas ordenadas polo cif
     * @return
     * @throws Exception 
     */
    @Override
    public Empresa[] getEmpresas() throws Exception {
        ArrayList<Empresa> empresas = new ArrayList<>();
        try ( RandomAccessFile ras2 = new RandomAccessFile(fileE, "rws");) {
            while (true) {
                String cif = ras2.readUTF();
                String nome = ras2.readUTF();
                String razonsocial = ras2.readUTF();

                Empresa e = new Empresa(cif, nome, razonsocial);
                empresas.add(e);

            }
        } catch (EOFException ex) {
        }//cando chega ao final
        Empresa[] todasE = empresas.toArray(new Empresa[0]);
        Arrays.sort(todasE, (Empresa e1, Empresa e2) -> e1.getCif().compareTo(e2.getCif()));//ordena todasE e garda os cambios
        return todasE;//devolvemos o array xa ordenado   
    }

    /**
     * método que devolve todos os traballadores dunha empresa
     * @param cif
     * @return
     * @throws Exception 
     */
    @Override
    public Traballador[] getTraballadores(String cif) throws Exception {
        ArrayList<Traballador> traballadores = new ArrayList<>();
        try ( RandomAccessFile ras = new RandomAccessFile(fileT, "rws");) {
            while (true) {
                String dni = ras.readUTF();
                String nome = ras.readUTF();
                String apelidos = ras.readUTF();
                String cifE = ras.readUTF();

                Traballador t = new Traballador(dni, nome, apelidos);
                t.setEmpresa(cif);
                if (!dni.startsWith("*") && cifE.equals(cif)) {//se o dni non comeza por "*"
                    traballadores.add(t);
                }
            }
        } catch (EOFException ex) {
        }//cando chega ao final
        Traballador[] todosE = traballadores.toArray(new Traballador[0]);
        return todosE;//devolvemos o array
    }

    /**
     * método que devolve un traballador cun dni dado
     * @param dni
     * @return
     * @throws Exception 
     */
    @Override
    public Traballador getTraballador(String dni) throws Exception {
        try ( RandomAccessFile ras = new RandomAccessFile(fileT, "rws");) {
            while (true) {
                String dniT = ras.readUTF();
                String nome = ras.readUTF();
                String apelidos = ras.readUTF();
                String cif = ras.readUTF();

                Traballador t = new Traballador(dni, nome, apelidos);
                t.setEmpresa(cif);
                if (!dni.startsWith("*") && dniT.equals(dni)) {//se o dni non comeza por "*"
                    return t;
                }
            }
        } catch (EOFException ex) {
        }//cando chega ao final
        return null;//se non atopou traballador con dni    
    }

    /**
     * método que devolve unha empresa cun cif especificado
     * @param cif
     * @return
     * @throws Exception 
     */
    @Override
    public Empresa getEmpresa(String cif) throws Exception {
        try ( RandomAccessFile ras2 = new RandomAccessFile(fileE, "rws");) {
            while (true) {
                String cifE = ras2.readUTF();
                String nome = ras2.readUTF();
                String razonsocial = ras2.readUTF();

                Empresa e = new Empresa(cif, nome, razonsocial);
                if (cifE.equals(cif)) {
                    return e;
                }
            }
        } catch (EOFException ex) {
        }//cando chega ao final
        return null;
    }

    /**
     * método que devolve todos os traballadores en paro (os que teñen "*" no cif)
     * @return
     * @throws Exception 
     */
    @Override
    public Traballador[] getTraballadoresParo() throws Exception {
        ArrayList<Traballador> traballadoresParo = new ArrayList<>();
        try ( RandomAccessFile ras = new RandomAccessFile(fileT, "rws");) {
            while (true) {
                String dni = ras.readUTF();
                String nome = ras.readUTF();
                String apelidos = ras.readUTF();
                String cifE = ras.readUTF();

                Traballador t = new Traballador(dni, nome, apelidos);
                t.setEmpresa(cifE);
                if (!dni.startsWith("*") && cifE.equals("*")) {//se o dni non comeza por "*" e o cif é "*"
                    traballadoresParo.add(t);
                }
            }
        } catch (EOFException ex) {
        }//cando chega ao final
        Traballador[] todosP = traballadoresParo.toArray(new Traballador[0]);
        return todosP;//devolvemos o array
    }

    /**
     * método que cando se peche a clase garda os índices nos arquivos
     * correspondentes
     *
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        Set<String> chavesT = indexT.keySet();
        Set<String> chavesE = indexE.keySet();
        try ( RandomAccessFile ras = new RandomAccessFile(fileIt, "rws");) {
            for (String chaveT : chavesT) {
                ras.writeUTF(chaveT);//escribimos a chave
                Long posT = indexT.get(chaveT);//collemos a posición
                ras.writeLong(posT);//escribimos a posición         
            }
        }

        try ( RandomAccessFile ras2 = new RandomAccessFile(fileIe, "rws");) {
            for (String chaveE : chavesE) {
                ras2.writeUTF(chaveE);//escribimos a chave
                Long posE = indexE.get(chaveE);//collemos a posición
                ras2.writeLong(posE);//escribimos a posición        
            }
        }
    }

}
