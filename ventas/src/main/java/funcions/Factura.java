package funcions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

/**
 *Clase que crea facturas
 * @author alba_
 */
public class Factura {
    String codigo;
    final LocalDate dataFactura;
    final String dniCliente;
    final Collection<Venta> ventas;
    double importe;
    double ive;
    double total;
    boolean pechada;
    

    /**
     * Constructor con 2 argumentos que non permite construir obxectos Factura 
     * fora do paquete
     * @param dataFactura --> data da factura
     * @param dniCliente --> dni do cliente
     */
    Factura(LocalDate dataFactura, String dniCliente) {
        this.dataFactura = dataFactura;
        this.dniCliente = dniCliente;
        codigo=null;
        pechada=false;
        ventas=new ArrayList<>();
    }
    
    /**
     * engade unha venta ao atributo ventas que lanzará  unha VerboseException 
     * se a venta non corresponde co cliente da factura ou non se pode engadir a venta
     * @param v
     * @throws VerboseException 
     */
    public void addVenta(Venta v) throws VerboseException{
        if(!v.getDniCliente().equals(this.dniCliente))
            throw new VerboseException("ERROR", "O cliente non é correcto"); 
        else if(ventas.add(v)==false)//se é true o engade e devolve true
            throw new VerboseException("ERROR", "Non se pode engadir a venta");    
    }
    
    //engadimos getter e setter axeitados:

    public String getCodigo() {
        return codigo;
    }

    public LocalDate getDataFactura() {
        return dataFactura;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public Collection<Venta> getVentas() {
        return ventas;
    }

    public double getImporte() {
        return importe;
    }

    public double getIve() {
        return ive;
    }

    public double getTotal() {
        return total;
    }

    public boolean isPechada() {
        return pechada;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public void setIve(double ive) {
        this.ive = ive;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setPechada(boolean pechada) {
        this.pechada = pechada;
    }

    @Override
    public String toString() {
        return  dataFactura + " " + codigo + " " + dniCliente + " " + total + "€";
    }
    
    
    
    
    
}
