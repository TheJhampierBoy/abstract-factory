package com.cafeteria.singleton;

public class SystemConfig {

    private static SystemConfig instance;

    private String branch;
    private double tax;
    private String currency;
    private int dailyOrderLimit;

    private SystemConfig() {
        branch = "Bogota";
        tax = 0.19;
        currency = "COP";
        dailyOrderLimit = 100;
    }
    public static SystemConfig getInstance() {
        if(instance == null) {
            instance = new SystemConfig();
        }
        return instance;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getDailyOrderLimit() {
        return dailyOrderLimit;
    }

    public void setDailyOrderLimit(int dailyOrderLimit) {
        this.dailyOrderLimit = dailyOrderLimit;
    }

}