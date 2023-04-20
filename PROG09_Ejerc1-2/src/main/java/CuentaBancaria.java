
import java.io.Serializable;


/**
 * Clase abstracta que contén as contas bancarias do banco
 *
 * @author alba_
 */
public abstract class CuentaBancaria implements Imprimible, Serializable {
    //engadimos atributos da clase
    private Persona titular;
    private double saldo;
    private String iban;

    //engadimos o constructor con parámetros
    public CuentaBancaria(Persona titular, double saldo, String iban) {
        this.titular = titular;
        this.saldo = saldo;
        this.iban = iban;
    }
    
    

    //engadimos os getter e setter
    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    // Implementamos o método devolverContenidoString() 
    @Override
    public String devolverInfoString() {
        String contenido = titular.devolverInfoString() + " Cuenta: " + iban + " Saldo: " + saldo;
        return contenido;
    }

}
