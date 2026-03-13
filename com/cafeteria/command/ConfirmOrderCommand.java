package com.cafeteria.command;

import com.cafeteria.model.Order;
import com.cafeteria.model.OrderStatus;

public class ConfirmOrderCommand implements Command {

    private Order order;

    public ConfirmOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.setStatus(OrderStatus.CONFIRMED);
        System.out.println("✔ Pedido confirmado y pago procesado.");
    }

    @Override
    public void undo() {
        System.out.println("↩ Confirmación de pedido cancelada.");
    }
}