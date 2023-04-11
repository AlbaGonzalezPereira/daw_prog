package funcions;

import java.time.LocalDate;

/**
 *
 * @author alba_
 */
public class VentaBuider implements Builder<Venta>{
    //declaramos atributos como final xa que non poden ser modificados unha vez establecido o seu valor
    private LocalDate data;
    private String codigoArtigo;
    private String dniCliente;
    private int unidades;
    private double prezo;
    
    private VerboseException ve;

    public void setData(LocalDate data) {
        if (checkData()==true)
            this.data = data;
    }

    public void setCodigoArtigo(String codigoArtigo) {
        this.codigoArtigo = codigoArtigo;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public void setUnidades(int unidades) {
        if(checkUnidades()==true)
            this.unidades = unidades;
    }

    public void setPrezo(double prezo) {
        if(checkPrezo()==true)
            this.prezo = prezo;
    }
    

    @Override
    public Venta build() throws VerboseException {
        Venta venta;//declaramos un novo cliente

        reset();//Limpamos os error ao comezo
        checkData();
        checkPrezo();
        checkUnidades();
        
        if (ve == null) {
            venta = new Venta(data, codigoArtigo, dniCliente, unidades, prezo);
            return venta;
        } else {
            notifyErrors();
        }
        return null;    
    }

    private boolean checkData() {
        if(data.isBefore(LocalDate.now()))
            return true;
        if (ve != null) {
            ve = new VerboseException("Excepción creada");
        }
        ve.addMensaxe(Verbosity.INFO, "A data non é correcta");
        return false;   
    }    

    private boolean checkUnidades() {
        if(unidades > 0)
            return true;
        if (ve != null) {
            ve = new VerboseException("Excepción creada");
        }
        ve.addMensaxe(Verbosity.INFO, "As unidades deben ser maior que 0");
        return false;
        
    }

    private boolean checkPrezo() {
        if(prezo>0)
            return true;
        if (ve != null) {
            ve = new VerboseException("Excepción creada");
        }
        ve.addMensaxe(Verbosity.INFO, "O prezo debe ser maior que 0");
        return false;    
    }

    private void reset() {
        ve=null;
    }

    private void notifyErrors() throws VerboseException{
        if(ve!=null)
            throw ve;    
    }
    
}
