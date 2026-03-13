package com.cafeteria.command;

import com.cafeteria.model.Order;
import com.cafeteria.model.OrderStatus;

public class CancelOrderCommand implements Command {

    private Order order;

    public CancelOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.setStatus(OrderStatus.CANCELLED);
        System.out.println("✔ Pedido cancelado.");
    }

    @Override
    public void undo() {
        System.out.println("↩ Cancelación revertida. Pedido restaurado.");
    }
}