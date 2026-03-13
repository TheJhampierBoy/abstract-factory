package com.cafeteria.observer;

import com.cafeteria.model.Order;

public class DisplayObserver implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println("[PANTALLA] Pedido #" + order.getId() + " - Cliente: " + order.getClient() + " - Estado: " + order.getStatus().getDescription());
    }

}
