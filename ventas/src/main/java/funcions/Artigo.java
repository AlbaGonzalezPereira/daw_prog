package funcions;

import java.util.Objects;

/**
 *clase comparable
 * @author alba_
 */
public class Artigo implements Comparable<Artigo>{
    //declaramos atributos accesibles só desde a clase
    //poñemos os atributos codigo e denominación como final xa que non poden ser alterados unha vez establecido o seu valor
    private final String codigo;
    private final String denominacion;
    private String descricion;
    private double prezo;

    /**
     * método construtor dun Artigo recibe o código, denominación e prezo
     * @param codigo
     * @param denominacion
     * @param prezo 
     */
    public Artigo(String codigo, String denominacion, double prezo) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.prezo = prezo;
    }

    /**
     * engadimos os getter e setter correspondentes
     * @return 
     */
    public String getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public String getDescricion() {
        return descricion;
    }

    public double getPrezo() {
        return prezo;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public void setPrezo(double prezo) {
        this.prezo = prezo;
    }

    /**
     * método que representa como String dun Artigo debe ser código: denominación (prezo €)
     * @return 
     */
    @Override
    public String toString() {
        return codigo + ": " + denominacion + "(" + prezo + " €)";
    }

    /**
     * método que determina se dous artigos se consideran iguais si os seus códigos coinciden
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Artigo other = (Artigo) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    /**
     * método que nos di se os artigos son comparables por código
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Artigo o) {
//        if(this.codigo.equals(o.getCodigo()))
//            return 0;
//        else if(this.codigo.compareTo(o.getCodigo())>0)
//            return 1;
//        else
//            return -1;
        
        return this.codigo.compareTo(o.getCodigo());
    }
    
    
    
}
