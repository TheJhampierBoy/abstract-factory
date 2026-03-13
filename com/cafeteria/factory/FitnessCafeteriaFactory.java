package com.cafeteria.factory;

import com.cafeteria.model.Beverage;
import com.cafeteria.model.Dessert;
import com.cafeteria.model.Combo;

// Fábrica concreta para cafetería fitness
public class FitnessCafeteriaFactory implements CafeteriaFactory {
    
    @Override
    public Beverage createBeverage() {
        // Fitness: Té sin azúcar
        return new Beverage("Té Sin Azúcar", 1800.0, "Té verde natural sin azúcar");
    }
    
    @Override
    public Dessert createDessert() {
        // Fitness: Barra proteica
        return new Dessert("Barra Proteica", 3500.0, "Barra de proteínas con avena y miel");
    }
    
    @Override
    public Combo createCombo() {
        // Fitness: Combo fit
        return new Combo("Combo Fit", 6500.0, "Té sin azúcar + Barra proteica");
    }
    
    @Override
    public String getCafeteriaType() {
        return "Fitness";
    }
}
