package com.cafeteria.singleton;

public class SystemConfig {

    private static SystemConfig instance;

    private String sede;
    private double impuesto;
    private String moneda;

    private SystemConfig() {
        sede = "Bogotá";
        impuesto = 0.19;
        moneda = "COP";
    }
    
    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }
    
    public double getImpuesto() {
        return impuesto;
    }


    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    

    public static SystemConfig getInstance() {
        if(instance == null) {
            instance = new SystemConfig();
        }
        return instance;
    }
 
}