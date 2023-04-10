package air.prog;

/**
 *
 * @author alba_
 */
public class AvionComb extends Avion{
    private int velocidad;
    private TipoMisiles misil;

    public AvionComb(int velocidad, TipoMisiles misil, String codigo, int tipo) {
        super(codigo, tipo);
        this.velocidad = velocidad;
        this.misil = misil;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public TipoMisiles getMisil() {
        return misil;
    }

    public void setMisil(TipoMisiles misil) {
        this.misil = misil;
    }

    @Override
    public String toString() {
        return super.toString()+"AvionComb{" + "velocidad=" + velocidad + ", misil=" + misil + '}';
    }

    
    
    
   
    
    
}
