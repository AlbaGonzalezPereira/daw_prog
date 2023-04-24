
/**
 * clase herdada
 *
 * @author alba_
 */
public class CuentaAhorro extends CuentaBancaria {
    //engadimos o atributo
    private float tipoInteres;

    //engadimos o constructor con parámetros
    public CuentaAhorro(float tipoInteres, Persona titular, double saldo, String iban) {
        super(titular, saldo, iban);
        this.tipoInteres = tipoInteres;
    }

    //engadimos o get e set
    public float getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(float tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    //implementamos o método devolverInfoString()
    @Override
    public String devolverInfoString() {
        return "CuentaAhorro{" + "tipoInteres=" + tipoInteres + '}';

    }

}
