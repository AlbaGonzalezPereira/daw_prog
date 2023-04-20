
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que almacena las cuentas
 *
 * @author alba_
 */
public class Banco implements Serializable{

    /**
     * atributos
     */
    /**
     * para crear un array dinámico utilizo ArrayList porque presenta una serie
     * de ventajas frente a un array: Un ArrayList tiene un tamaño dinámico. Un
     * ArrayList no puede contener datos primitivos, sólo Objetos. El ArrayList
     * permite comprobar que los datos que se añaden a la colección son del tipo
     * correcto en tiempo de compilación. Es una de las estructuras dinámicas
     * más utilizada en Java
     */
    private ArrayList<CuentaBancaria> cuentas;
    //private CuentaBancaria[] cuentas;
    private int contador;

    /**
     * Constructor vacío
     */
    public Banco() {
        //cuentas = new CuentaBancaria[100];
        cuentas = new ArrayList<>();
        contador = 0;
    }

    /**
     * método que recibe por parámetro un objeto CuentaBancaria y lo almacena en
     * la estructura. Devuelve true o false
     *
     * @param cuenta
     * @return
     */
    public boolean abrirCuenta(CuentaBancaria cuenta) {
//        if (contador > cuentas.length) {
//            return false;
//        }
//        cuentas[contador] = cuenta;
//        contador++;
//        return true;

        if (contador > cuentas.size()) {
            return false;
        }
        cuentas.add(cuenta);
        contador++;
        return true;
    }

    /**
     * método que devuelve un array donde cada elemento es una cadena que
     * representa la información de una cuenta
     *
     * @return
     */
    public String[] listadoCuentas() {
//        String[] lista = new String[contador];
//        for (int i = 0; i < contador; i++) {
//            lista[i] = cuentas[i].devolverInfoString();
//        }
//        return lista;
        String[] lista = new String[contador];
        int longitud = 0; //declaramos un contador
        Iterator<CuentaBancaria> it = cuentas.iterator();
        //declaramos y recogemos el iterador del ArrayList

        while (it.hasNext()) {//mientras haya siguiente
            lista[longitud] = it.next().devolverInfoString();
            //it.next() es similar a cuentas[i] pero te lo pasa al siguiente
            longitud++;
        }
        return lista;

    }

    /**
     * método que recibe un iban por parámetro y devuelve una cadena con la
     * información de la cuenta o null si la cuenta no existe
     *
     * @param iban
     * @return
     */
    public String informacionCuenta(String iban) {
//        for (int i = 0; i < contador; i++) {
//            if (iban.equals(cuentas[i].getIban())) {
//                return cuentas[i].devolverInfoString();
//            }
//        }
//        return null;
        Iterator<CuentaBancaria> it = cuentas.iterator();
        CuentaBancaria c;
        while (it.hasNext()) {
            c = it.next();
            if (iban.equals(c.getIban())) {
                return c.devolverInfoString();
            }

        }
        return null;
    }

    /**
     * método que recibe un iban por parámetro y una cantidad e ingresa la
     * cantidad en la cuenta. Devuelve true o false
     *
     * @param iban
     * @param cantidad
     * @return
     */
    public boolean ingresoCuenta(String iban, double cantidad) {
//        for (int i = 0; i < contador; i++) {
//            if (iban.equals(cuentas[i].getIban())) {
//                cuentas[i].setSaldo(cuentas[i].getSaldo() + cantidad);
//                return true;
//            }
//        }
//        return false;
        Iterator<CuentaBancaria> it = cuentas.iterator();
        CuentaBancaria c;
        while (it.hasNext()) {
            c = it.next();
            if (iban.equals(c.getIban())) {
                c.setSaldo(c.getSaldo() + cantidad);
                return true;
            }

        }
        return false;
    }

    /**
     * método que recibe un iban por parámetro y una cantidad y trata de retirar
     * la cantidad de la cuenta. Devuelve true o false
     *
     * @param iban
     * @param cantidad
     * @return
     */
    public boolean retiradaCuenta(String iban, double cantidad) {

//        for (int i = 0; i < contador; i++) {
//            if (iban.equals(cuentas[i].getIban())) {
//                if (cuentas[i].getSaldo() >= cantidad) {
//                    cuentas[i].setSaldo(cuentas[i].getSaldo() - cantidad);
//                    return true;
//                }
//            }
//        }
//        return false;
        Iterator<CuentaBancaria> it = cuentas.iterator();
        CuentaBancaria c;
        while (it.hasNext()) {
            c = it.next();
            if (iban.equals(c.getIban())) {
                if (c.getSaldo() >= cantidad) {
                    c.setSaldo(c.getSaldo() - cantidad);
                    return true;
                }
            }

        }
        return false;

    }

    /**
     * método que recibe un iban por parámetro y devuelve el saldo de la cuenta
     * si existe. En caso contrario devuelve -1
     *
     * @param iban
     * @return
     */
    public double obtenerSaldo(String iban) {
//        int i;
//        for (i = 0; i < contador; i++) {
//            if (iban.equals(cuentas[i].getIban())) {
//                return cuentas[i].getSaldo();
//            }
//        }
//        return -1;

        for (CuentaBancaria cuenta : cuentas) {
            if (iban.equals(cuenta.getIban())) {
                return cuenta.getSaldo();
            }
        }
        return -1;
    }

    //creamos el método eliminarCuenta()
    public boolean eliminarCuenta(String ccc) {
        Iterator<CuentaBancaria> it = cuentas.iterator();
        CuentaBancaria c;
        while (it.hasNext()) {
            c = it.next();
            if (ccc.equals(c.getIban())) {
            //if (comprobarIban(ccc)!=null) {
                if (c.getSaldo() == 0) {
                    contador--;
                    //Para eliminar usar el it.remove();
                    return cuentas.remove(c); //ya devuelve un boolean
                    
                }

            }
            

        }

        return false;
    }
    
    /**********************************************PROG09_Ejer2*****************/
    /**
     * método que devolve as contas bancarias
     * @return 
     */
    public ArrayList<CuentaBancaria> getCuentas(){
        return cuentas;
    }

    
    
}
