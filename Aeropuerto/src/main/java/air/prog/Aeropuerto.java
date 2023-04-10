package air.prog;

/**
 *
 * @author alba_
 */
public class Aeropuerto {
    private final static int MAX_AVIONES=100;
    int numAviones;
    Avion[] aviones = new Avion[MAX_AVIONES];

    public Aeropuerto() {
        numAviones=0;
    }
    
    public boolean engadirAvion(Avion av){
        aviones[numAviones]=av;        
        numAviones++;
        return true;
    }
              
    public int getNumAviones() {
        return numAviones;
    }

    public void setNumAviones(int numAviones) {
        this.numAviones = numAviones;
    }

    public Avion[] getAviones() {
        return aviones;
    }

    public void setAviones(Avion[] aviones) {
        this.aviones = aviones;
    }
       
}
