package com.cafeteria.observer;

import com.cafeteria.model.Order;

public class KitchenObserver implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println("Cocina recibió notificación: Pedido #" + order.getId() + " - Estado: " + order.getStatus().getDescription());
    }

}
