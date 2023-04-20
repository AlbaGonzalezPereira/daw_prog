/**
 * clase herdada
 * @author alba_
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente{
    private double descubierto;
    private double maxDescubierto;

    public CuentaCorrienteEmpresa(double descubierto, double maxDescubierto, String[] entidades, Persona titular, double saldo, String iban) {
        super(entidades, titular, saldo, iban);
        this.descubierto = descubierto;
        this.maxDescubierto = maxDescubierto;
    }

    public double getDescubierto() {
        return descubierto;
    }

    public void setDescubierto(double descubierto) {
        this.descubierto = descubierto;
    }

    public double getMaxDescubierto() {
        return maxDescubierto;
    }

    public void setMaxDescubierto(double maxDescubierto) {
        this.maxDescubierto = maxDescubierto;
    }
    @Override
   public String devolverInfoString() {
        String contenido=super.devolverInfoString()+ "CuentaCorrienteEmpresa{" + "descubierto=" + descubierto + ", maxDescubierto=" + maxDescubierto + '}';
        return contenido;
    } 
    
   
    
}
