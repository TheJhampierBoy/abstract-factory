package com.cafeteria.factory;

import com.cafeteria.model.Beverage;
import com.cafeteria.model.Dessert;
import com.cafeteria.model.Combo;

// Abstract Factory: define la interfaz para crear productos relacionados
public interface CafeteriaFactory {

    // Crea una bebida
    Beverage createBeverage();

    // Crea un postre
    Dessert createDessert();
    
    // Crea un combo
    Combo createCombo();
    
    // Retorna el tipo de cafetería
    String getCafeteriaType();
}
