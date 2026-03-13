package com.cafeteria.factory;

import com.cafeteria.model.Beverage;
import com.cafeteria.model.Dessert;
import com.cafeteria.model.Combo;

// Fábrica concreta para cafetería tradicional
public class TraditionalCafeteriaFactory implements CafeteriaFactory {
    
    @Override
    public Beverage createBeverage() {
        // Traditional: Café con leche
        return new Beverage("Café con Leche", 2500.0, "Café tradicional con leche entera");
    }
    
    @Override
    public Dessert createDessert() {
        // Traditional: Cheesecake
        return new Dessert("Cheesecake", 4500.0, "Cheesecake de frutillas con cobertura de chocolate");
    }
    
    @Override
    public Combo createCombo() {
        // Traditional: Combo clásico
        return new Combo("Combo Clásico", 8500.0, "Café con leche + Cheesecake");
    }
    
    @Override
    public String getCafeteriaType() {
        return "Tradicional";
    }
}
