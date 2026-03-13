package com.cafeteria.model;

public class Beverage implements Product {
    private String name;
    private double price;
    private String description;

    public Beverage(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getType() {
        return "Beverage";
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "  - " + name + " (" + getType() + "): $" + price + " - " + description;
    }
}
