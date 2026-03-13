package com.cafeteria.command;

import com.cafeteria.model.Order;
import com.cafeteria.model.Product;

public class ShowOrderCommand implements Command {

    private Order order;

    public ShowOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println("\n📋 Productos del pedido:");
        int count = 1;
        for (Product product : order.getProducts()) {
            System.out.println("  " + count++ + ". " + product);
        }
        if (count == 1) {
            System.out.println("  (Sin productos aún)");
        }
    }

    @Override
    public void undo() {
        System.out.println("↩ No hay acción que deshacer para mostrar pedido.");
    }
}