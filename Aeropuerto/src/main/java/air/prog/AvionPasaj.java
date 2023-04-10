package air.prog;

/**
 *
 * @author alba_
 */
public class AvionPasaj extends Avion{
    private int numPlaza;
    private float precioBillete;

    public AvionPasaj(int numPlaza, float precioBillete, String codigo, int tipo) {
        super(codigo, tipo);
        this.numPlaza = numPlaza;
        this.precioBillete = precioBillete;
    }

    public int getNumPlaza() {
        return numPlaza;
    }

    public void setNumPlaza(int numPlaza) {
        this.numPlaza = numPlaza;
    }

    public float getPrecioBillete() {
        return precioBillete;
    }

    public void setPrecioBillete(float precioBillete) {
        this.precioBillete = precioBillete;
    }

    @Override
    public String toString() {
        return super.toString()+"AvionPasaj{" + "numPlaza=" + numPlaza + ", precioBillete=" + precioBillete + '}';
    }

   

    

    
    
    
    
}
