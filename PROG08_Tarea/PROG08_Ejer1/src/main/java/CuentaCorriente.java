
/**
 * clase abstracta que herda de CuentaBancaria
 * @author alba_
 */
public abstract class CuentaCorriente extends CuentaBancaria{
    private String[] entidades;

    //engadimos o constructor baleiro
    public CuentaCorriente(String[] entidades, Persona titular, double saldo, String iban) {
        super(titular, saldo, iban);
        this.entidades = entidades;
    }

    //engadimos o get e set
    public String[] getEntidades() {
        return entidades;
    }

    public void setEntidades(String[] entidades) {
        this.entidades = entidades;
    }
    
    // Implementamos o método devolverContenidoString() 
    @Override
   public String devolverInfoString() {
        String contenido=super.devolverInfoString() + "CuentaCorriente{" + "entidades=" + entidades + '}';
        return contenido;
    } 

     
    
}
