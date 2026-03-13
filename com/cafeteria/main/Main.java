package com.cafeteria.main;

// Importaciones de los patrones de diseño
import com.cafeteria.factory.CafeteriaFactory;
import com.cafeteria.factory.FactoryProducer;
import com.cafeteria.model.*;
import com.cafeteria.strategy.*;
import com.cafeteria.command.*;
import com.cafeteria.observer.*;
import com.cafeteria.singleton.SystemConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    // Repositorio de pedidos y scanner para entrada
    private static OrderRepository orderRepository = new OrderRepository();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Mostrar mensaje de bienvenida usando Singleton
        showWelcome();
        
        // Ciclo del menú principal
        boolean exit = false;
        while (!exit) {
            showMenu();
            int option = getOption();
            
            switch (option) {
                case 1:
                    createOrder();
                    break;
                case 2:
                    showAllOrders();
                    break;
                case 3:
                    confirmOrder();
                    break;
                case 4:
                    cancelOrder();
                    break;
                case 5:
                    showProducts();
                    break;
                case 6:
                    exit = true;
                    System.out.println("\n¡Gracias por usar el sistema!");
                    break;
                default:
                    System.out.println("\nOpción inválida. Intente de nuevo.");
            }
        }
    }
    
    // Mostrar mensaje de bienvenida
    private static void showWelcome() {
        SystemConfig config = SystemConfig.getInstance();
        System.out.println("========================================");
        System.out.println("   Sistema de Cafetería " + config.getBranch());
        System.out.println("========================================");
        System.out.println("Sistema de Gestión de Cafetería");
        System.out.println("Moneda: " + config.getCurrency());
        System.out.println();
    }
    
    // Mostrar menú principal
    private static void showMenu() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Crear nuevo pedido");
        System.out.println("2. Ver todos los pedidos");
        System.out.println("3. Confirmar pedido");
        System.out.println("4. Cancelar pedido");
        System.out.println("5. Ver productos disponibles");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    // Obtener opción del usuario
    private static int getOption() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    // Crear nuevo pedido usando Abstract Factory
    private static void createOrder() {
        System.out.println("\n--- Crear Nuevo Pedido ---");
        
        // Seleccionar tipo de cafetería
        System.out.println("Tipos de cafetería disponibles:");
        System.out.println("1. Tradicional");
        System.out.println("2. Fitness");
        System.out.print("Seleccione tipo: ");
        int type = getOption();
        
        CafeteriaFactory factory = null;
        String cafeteriaType = "";
        
        if (type == 1) {
            factory = FactoryProducer.getFactory("TRADICIONAL");
            cafeteriaType = "Tradicional";
        } else if (type == 2) {
            factory = FactoryProducer.getFactory("FITNESS");
            cafeteriaType = "Fitness";
        } else {
            System.out.println("Tipo inválido.");
            return;
        }
        
        if (factory == null) {
            System.out.println("Error al crear la fábrica.");
            return;
        }
        
        System.out.println("\nCafetería seleccionada: " + cafeteriaType);
        
        // Mostrar productos
        System.out.println("\n--- Productos Disponibles ---");
        Product beverage = factory.createBeverage();
        Product dessert = factory.createDessert();
        Product combo = factory.createCombo();
        
        System.out.println("1. " + beverage.getName() + " - $" + beverage.getPrice());
        System.out.println("2. " + dessert.getName() + " - $" + dessert.getPrice());
        System.out.println("3. " + combo.getName() + " - $" + combo.getPrice());
        
        // Seleccionar productos
        System.out.println("\nSeleccione productos (ingrese números, ej: 1,2 para múltiplos):");
        System.out.println("1. Beverage (Bebida)");
        System.out.println("2. Dessert (Postre)");
        System.out.println("3. Combo (Combo)");
        System.out.println("4. Todos los productos");
        System.out.print("Seleccione: ");
        
        String productChoice = scanner.nextLine();
        
        // Crear pedido usando Command
        CreateOrderCommand command = new CreateOrderCommand(orderRepository);
        command.execute();
        
        // Obtener el pedido creado
        int lastOrderId = orderRepository.getOrderCount();
        Order order = orderRepository.findOrder(lastOrderId);
        
        if (order == null) {
            System.out.println("Error al crear el pedido.");
            return;
        }
        
        // Agregar observadores
        order.addObserver(new CashierObserver());
        order.addObserver(new KitchenObserver());
        
        // Agregar productos seleccionados
        if (productChoice.contains("1") || productChoice.toLowerCase().contains("beverage") || productChoice.toLowerCase().contains("bebida")) {
            order.addProduct(beverage);
        }
        if (productChoice.contains("2") || productChoice.toLowerCase().contains("dessert") || productChoice.toLowerCase().contains("postre")) {
            order.addProduct(dessert);
        }
        if (productChoice.contains("3") || productChoice.toLowerCase().contains("combo")) {
            order.addProduct(combo);
        }
        if (productChoice.equals("4")) {
            order.addProduct(beverage);
            order.addProduct(dessert);
            order.addProduct(combo);
        }
        
        // Verificar si se seleccionó algún producto
        if (order.getProducts().isEmpty()) {
            System.out.println("No se seleccionaron productos. Pedido cancelado.");
            orderRepository.removeOrder(order);
            return;
        }
        
        // Seleccionar método de pago usando Strategy
        System.out.println("\nMétodos de pago:");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta");
        System.out.println("3. Billetera Digital");
        System.out.print("Seleccione: ");
        int paymentOption = getOption();
        
        PaymentStrategy paymentStrategy = null;
        if (paymentOption == 1) {
            paymentStrategy = new CashPaymentStrategy();
        } else if (paymentOption == 2) {
            paymentStrategy = new CardPaymentStrategy();
        } else if (paymentOption == 3) {
            paymentStrategy = new DigitalWalletStrategy();
        } else {
            System.out.println("Usando efectivo por defecto.");
            paymentStrategy = new CashPaymentStrategy();
        }
        
        // Establecer estrategia de pago
        order.setPaymentStrategy(paymentStrategy);
        
        System.out.println("\n" + order.getDetails());
        System.out.println("Pedido creado exitosamente!");
    }
    
    // Mostrar todos los pedidos
    private static void showAllOrders() {
        System.out.println("\n--- Todos los Pedidos ---");
        
        if (orderRepository.getOrderCount() == 0) {
            System.out.println("No hay pedidos registrados.");
            return;
        }
        
        for (Order order : orderRepository.getOrders()) {
            System.out.println(order);
        }
    }
    
    // Confirmar pedido usando Command
    private static void confirmOrder() {
        System.out.println("\n--- Confirmar Pedido ---");
        
        if (orderRepository.getOrderCount() == 0) {
            System.out.println("No hay pedidos para confirmar.");
            return;
        }
        
        System.out.print("Ingrese ID del pedido: ");
        int orderId = getOption();
        
        Order order = orderRepository.findOrder(orderId);
        if (order == null) {
            System.out.println("Pedido no encontrado.");
            return;
        }
        
        // Verificar si el pedido ya está pagado
        if (order.getStatus() == OrderStatus.DELIVERED || order.getStatus() == OrderStatus.CONFIRMED) {
            System.out.println("Error: Este pedido ya ha sido pagado.");
            return;
        }
        
        ConfirmOrderCommand command = new ConfirmOrderCommand(order);
        command.execute();
        
        // Procesar pago
        if (order.getPaymentStrategy() != null) {
            order.getPaymentStrategy().pay(order.getTotal());
        }
        
        System.out.println("Pedido confirmado exitosamente!");
    }
    
    // Cancelar pedido usando Command
    private static void cancelOrder() {
        System.out.println("\n--- Cancelar Pedido ---");
        
        if (orderRepository.getOrderCount() == 0) {
            System.out.println("No hay pedidos para cancelar.");
            return;
        }
        
        System.out.print("Ingrese ID del pedido: ");
        int orderId = getOption();
        
        Order order = orderRepository.findOrder(orderId);
        if (order == null) {
            System.out.println("Pedido no encontrado.");
            return;
        }
        
        CancelOrderCommand command = new CancelOrderCommand(order);
        command.execute();
        
        System.out.println("Pedido cancelado exitosamente!");
    }
    
    // Mostrar productos de ambas fábricas
    private static void showProducts() {
        System.out.println("\n--- Productos Disponibles en Todas las Cafeterías ---");
        
        CafeteriaFactory traditional = FactoryProducer.getFactory("TRADICIONAL");
        CafeteriaFactory fitness = FactoryProducer.getFactory("FITNESS");
        
        System.out.println("\n=== CAFETERÍA TRADICIONAL ===");
        Product[] tradProducts = {
            traditional.createBeverage(),
            traditional.createDessert(),
            traditional.createCombo()
        };
        
        for (Product p : tradProducts) {
            System.out.println("- " + p.getName() + ": $" + p.getPrice() + " - " + p.getDescription());
        }
        
        System.out.println("\n=== CAFETERÍA FITNESS ===");
        Product[] fitProducts = {
            fitness.createBeverage(),
            fitness.createDessert(),
            fitness.createCombo()
        };
        
        for (Product p : fitProducts) {
            System.out.println("- " + p.getName() + ": $" + p.getPrice() + " - " + p.getDescription());
        }
    }
}
