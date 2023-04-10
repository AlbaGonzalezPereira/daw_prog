package air.prog;

/**
 *
 * @author alba_
 */
public class Avion {
    private String codigo;
    private int tipo;
    private float precioBillete;

    public Avion() {
    }
    
    public Avion(String codigo, int tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getNumPlaza(){
        return -1;
    }
    
     public float getPrecioBillete() {
        return -1;
    }
     
      public void setPrecioBillete(float precioBillete) {
        this.precioBillete = precioBillete;
    }
     
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

        @Override
    public String toString() {
        return "Avion{" + "codigo=" + codigo + ", tipo=" + tipo + '}';
    }
    
}
