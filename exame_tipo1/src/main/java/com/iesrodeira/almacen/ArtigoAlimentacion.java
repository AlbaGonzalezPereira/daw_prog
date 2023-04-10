
package com.iesrodeira.almacen;

import java.util.Date;

/**
 *
 * @author alba_
 */
public class ArtigoAlimentacion extends Artigo {
    private boolean refrixerado;
    private Date dataEnvasado;
    private Date consumoPref;

    /**
     * 
     * Declaramos constructores
     */
    public ArtigoAlimentacion(boolean refrixerado, Date dataEnvasado, Date consumoPref, String codigo, String denominacion, String descricion, double prezo) {
        super(codigo, denominacion, descricion, prezo);
        this.refrixerado = refrixerado;
        this.dataEnvasado = dataEnvasado;
        this.consumoPref = consumoPref;
    }

    
    
    
    public boolean isRefrixerado() {
        return refrixerado;
    }

    public void setRefrixerado(boolean refrixerado) {
        this.refrixerado = refrixerado;
    }

    public Date getDataEnvasado() {
        return dataEnvasado;
    }

    public void setDataEnvasado(Date dataEnvasado) {
        this.dataEnvasado = dataEnvasado;
    }

    public Date getConsumoPref() {
        return consumoPref;
    }

    public void setConsumoPref(Date consumoPref) {
        this.consumoPref = consumoPref;
    }

    @Override
    public String toString() {
        return super.toString()+" " + "refrixerado=" + refrixerado + ", dataEnvasado=" + dataEnvasado + ", consumoPref=" + consumoPref + '}';
    }
    
    
    
    
    
}
