package com.iesrodeira.almacen;

import java.util.Date;

/**
 *
 * @author alba_
 */
public class ArtigoFarmacia extends Artigo{
    private Date dataEnvasado;
    private Date dataCaducidade;

    public ArtigoFarmacia(Date dataEnvasado, Date dataCaducidade, String codigo, String denominacion, String descricion, double prezo) {
        super(codigo, denominacion, descricion, prezo);
        this.dataEnvasado = dataEnvasado;
        this.dataCaducidade = dataCaducidade;
    }

    

    public Date getDataEnvasado() {
        return dataEnvasado;
    }

    public void setDataEnvasado(Date dataEnvasado) {
        this.dataEnvasado = dataEnvasado;
    }

    public Date getDataCaducidade() {
        return dataCaducidade;
    }

    public void setDataCaducidade(Date dataCaducidade) {
        this.dataCaducidade = dataCaducidade;
    }

    @Override
    public String toString() {
        return super.toString()+" " + "dataEnvasado=" + dataEnvasado + ", dataCaducidade=" + dataCaducidade + '}';
    }
    
    
    
    
    
}
