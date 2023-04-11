package funcions;

import java.util.HashMap;

/**
 * Clase implementada que almacena e permite atopar rapidamente cantas unidades
 * temos
 *
 * @author alba_
 */
public class ArtigoStock implements Stock {

    //declaramos o atributo almacen que será un HashMap porque mediante un código permite
    //atopar rapidamente un stock, é dicir, emprega chave e valor
    HashMap<String, Integer> almacen;

    /**
     * Insertamos o constructor inicializando o atributo
     */
    public ArtigoStock() {
        almacen = new HashMap<String, Integer>();
    }

    //implementamos os métodos da interface
    /**
     * Método que devolve o stock se o hai
     *
     * @param codigo
     * @return
     */
    @Override
    public Integer getStock(String codigo) {
        if (almacen.get(codigo) == null) {
            System.out.println("Non existe o código");
            return -1;
        } else {
            return almacen.get(codigo);
        }
    }

    /**
     * método que engade stock e que se é negativo lanza unha VerboseException
     *
     * @param codigo
     * @param num
     * @throws VerboseException
     */
    @Override
    public void addStock(String codigo, Integer num) throws VerboseException {
        if (almacen.get(codigo) != null) {
            if (almacen.get(codigo) >= 0 && almacen.get(codigo) + num >= 0) {
                almacen.put(codigo, almacen.get(codigo) + num);
            } else {
                throw new VerboseException("O stock non pode ser negativo");
            }
        }
    }

    /**
     * método que permite modificar o stock e lanza unha excepción cando sexa
     * negativo o stock
     *
     * @param codigo
     * @param num
     * @throws VerboseException
     */
    @Override
    public void setStock(String codigo, Integer num) throws VerboseException {
        if (almacen.get(codigo) != null) {
            if (num > 0) {
                almacen.put(codigo, num);
            } else {
                throw new VerboseException("O stock non pode ser negativo");
            }
        } else {
            System.out.println("Non se atopou o código");
        }
    }

}//fin clase
