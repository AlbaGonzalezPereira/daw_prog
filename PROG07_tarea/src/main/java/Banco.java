
/**
 * Clase que almacena las cuentas
 * @author alba_
 */
public class Banco {

    /**
     * atributos
     */
    private CuentaBancaria[] cuentas;
    private int contador;

    /**
     * Constructor vacío
     */
    public Banco() {
        cuentas = new CuentaBancaria[100];
        contador = 0;
    }

    /**
     * método que recibe por parámetro un objeto CuentaBancaria y lo almacena 
     * en la estructura. Devuelve true o false
     * @param cuenta
     * @return 
     */
    public boolean abrirCuenta(CuentaBancaria cuenta) {
        if (contador > cuentas.length) {
            return false;
        }
        cuentas[contador] = cuenta;
        contador++;
        return true;

    }

    /**
     * método que devuelve un array donde cada elemento es una cadena que 
     * representa la información de una cuenta
     * @return 
     */
    public String[] listadoCuentas() {
        String[] lista = new String[contador];
        for (int i = 0; i < contador; i++) {
            lista[i] = cuentas[i].devolverInfoString();
        }
        return lista;
    }

    /**
     * método que recibe un iban por parámetro y devuelve una cadena con la 
     * información de la cuenta o null si la cuenta no existe
     * @param iban
     * @return 
     */
    public String informacionCuenta(String iban) {
        for (int i = 0; i < contador; i++) {
            if (iban.equals(cuentas[i].getIban())) {
                return cuentas[i].devolverInfoString();
            }
        }
        return null;
    }

    /**
     * método que recibe un iban por parámetro y una cantidad e ingresa la
     * cantidad en la cuenta. Devuelve true o false 
     * @param iban
     * @param cantidad
     * @return 
     */
    public boolean ingresoCuenta(String iban, double cantidad) {
        for (int i = 0; i < contador; i++) {
            if (iban.equals(cuentas[i].getIban())) {
                cuentas[i].setSaldo(cuentas[i].getSaldo() + cantidad);
                return true;
            }
        }
        return false;
    }

    /**
     * método que recibe un iban por parámetro y una cantidad y trata de retirar 
     * la cantidad de la cuenta. Devuelve true o false 
     * @param iban
     * @param cantidad
     * @return 
     */
    public boolean retiradaCuenta(String iban, double cantidad) {

        for (int i = 0; i < contador; i++) {
            if (iban.equals(cuentas[i].getIban())) {
                if (cuentas[i].getSaldo() >= cantidad) {
                    cuentas[i].setSaldo(cuentas[i].getSaldo() - cantidad);
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * método que recibe un iban por parámetro y devuelve el saldo de la cuenta 
     * si existe. En caso contrario devuelve -1
     * @param iban
     * @return 
     */
    public double obtenerSaldo(String iban) {
        int i;
        for (i = 0; i < contador; i++) {
            if (iban.equals(cuentas[i].getIban())) {
                return cuentas[i].getSaldo();
            }
        }
        return -1;

    }
}
