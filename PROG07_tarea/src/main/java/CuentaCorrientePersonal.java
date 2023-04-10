/**
 *
 * @author alba_
 */
public class CuentaCorrientePersonal extends CuentaCorriente {
    private float comisionMantenimiento;

    public CuentaCorrientePersonal(float comisionMantenimiento, String[] entidades, Persona titular, double saldo, String iban) {
        super(entidades, titular, saldo, iban);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    public float getComisionMantenimiento() {
        return comisionMantenimiento;
    }

    public void setComisionMantenimiento(float comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }

    @Override
    public String devolverInfoString() {
        String contenido=super.devolverInfoString()+ "CuentaCorrientePersonal{" + "comisionMantenimiento=" + comisionMantenimiento + '}';
        return contenido;
    }
    
    
    
}
