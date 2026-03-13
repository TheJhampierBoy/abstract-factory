package com.cafeteria.observer;

import com.cafeteria.model.Order;

public class DisplayObserver implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println("[DISPLAY] Order #" + order.getId() + " - Client: " + order.getClient() + " - Status: " + order.getStatus().getDescription());
    }

}
