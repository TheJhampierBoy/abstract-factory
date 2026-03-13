package com.cafeteria.command;

import com.cafeteria.model.Order;
import com.cafeteria.model.OrderRepository;

public class CreateOrderCommand implements Command {

    private OrderRepository repository;
    private Order createdOrder;

    public CreateOrderCommand(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        createdOrder = new Order("Cliente");
        repository.addOrder(createdOrder);
        System.out.println("✔ Pedido creado.");
    }

    @Override
    public void undo() {
        if (createdOrder != null) {
            repository.removeOrder(createdOrder);
            System.out.println("↩ Creación de pedido deshecha.");
        }
    }
}