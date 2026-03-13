package com.cafeteria.factory;

// Productor de fábricas: obtiene la fábrica según el tipo de cafetería
public class FactoryProducer {
    
    // Retorna la fábrica correspondiente al tipo
    public static CafeteriaFactory getFactory(String cafeteriaType) {
        if (cafeteriaType == null) {
            return null;
        }
        
        if (cafeteriaType.equalsIgnoreCase("TRADICIONAL")) {
            return new TraditionalCafeteriaFactory();
        } else if (cafeteriaType.equalsIgnoreCase("FITNESS")) {
            return new FitnessCafeteriaFactory();
        }
        
        return null;
    }

    public static void showAvailableTypes() {
        System.out.println("Tipos de cafetería disponibles:");
        System.out.println("  - TRADICIONAL: Café con leche, Cheesecake, Combo clásico");
        System.out.println("  - FITNESS: Té sin azúcar, Barra proteica, Combo fit");
    }
}
