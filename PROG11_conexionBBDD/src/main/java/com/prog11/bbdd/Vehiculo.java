package com.prog11.bbdd;

/**
 *
 * @author alba_
 */
public class Vehiculo {
    //insertamos os datos que aparecen na táboa vehiculos:
    private String mat_veh;
    private String marca_veh;
    private int kms_veh;
    private float precio_veh;
    private String desc_veh;
    private int id_prop;
    
    //insertamos os constructores:
    public Vehiculo(String mat_veh, String marca_veh, int kms_veh, float precio_veh, String desc_veh) {
        this.mat_veh = mat_veh;
        this.marca_veh = marca_veh;
        this.kms_veh = kms_veh;
        this.precio_veh = precio_veh;
        this.desc_veh = desc_veh;
    }

    public Vehiculo(String mat_veh, String marca_veh, int kms_veh, float precio_veh, String desc_veh, int id_prop) {
        this(mat_veh, marca_veh, kms_veh,precio_veh,desc_veh);
        this.id_prop = id_prop;
    }
    
    //insertamos getter e setter
    public String getMat_veh() {
        return mat_veh;
    }

    public void setMat_veh(String mat_veh) {
        this.mat_veh = mat_veh;
    }

    public String getMarca_veh() {
        return marca_veh;
    }

    public void setMarca_veh(String marca_veh) {
        this.marca_veh = marca_veh;
    }

    public int getKms_veh() {
        return kms_veh;
    }

    public void setKms_veh(int kms_veh) {
        this.kms_veh = kms_veh;
    }

    public float getPrecio_veh() {
        return precio_veh;
    }

    public void setPrecio_veh(float precio_veh) {
        this.precio_veh = precio_veh;
    }

    public String getDesc_veh() {
        return desc_veh;
    }

    public void setDesc_veh(String desc_veh) {
        this.desc_veh = desc_veh;
    }

    public int getId_prop() {
        return id_prop;
    }

    public void setId_prop(int id_prop) {
        this.id_prop = id_prop;
    }
     
    //insertamos método toString();
    @Override
    public String toString() {
        return "mat_veh=" + mat_veh + ", marca_veh=" + marca_veh + ", kms_veh=" + kms_veh + ", precio_veh=" + precio_veh + ", desc_veh=" + desc_veh + ", id_prop=" + id_prop;
    }

}
