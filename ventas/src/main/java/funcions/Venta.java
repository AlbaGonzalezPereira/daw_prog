package funcions;

import java.time.LocalDate;

/**
 *
 * @author alba_
 */
public class Venta implements Comparable<Venta> {
    //declaramos atributos como final xa que non poden ser modificados unha vez establecido o seu valor
    private final LocalDate data;
    private final String codigoArtigo;
    private final String dniCliente;
    private final int unidades;
    private final double prezo;

    /**
     * método constructor que recibe o DNI do cliente, a data, o codigo do artigo, o prezo e o número de unidades
     * Non debe ser posible crear instancias de Venta dende fora do package
     * @param data
     * @param codigoArtigo
     * @param dniCliente
     * @param unidades
     * @param prezo 
     */
    Venta(LocalDate data, String codigoArtigo, String dniCliente, int unidades, double prezo) {
        this.data = data;
        this.codigoArtigo = codigoArtigo;
        this.dniCliente = dniCliente;
        this.unidades = unidades;
        this.prezo = prezo;
    }

    //engadimos os getter correspondentes
    public LocalDate getData() {
        return data;
    }

    public String getCodigoArtigo() {
        return codigoArtigo;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public int getUnidades() {
        return unidades;
    }

    public double getPrezo() {
        return prezo;
    }

    /**
     * método que representa como String dunha venta debe ser data,dni,codigo,unidades
     * @return 
     */
    @Override
    public String toString() {
        return data + ", " + dniCliente + ", " + codigoArtigo + ", " + unidades;
    }

    /**
     * método para que as ventas son comparables por data
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Venta o) {
        return this.data.compareTo(o.getData());
    }
    
    
    
}
