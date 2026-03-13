package com.cafeteria.observer;

import com.cafeteria.model.Order;

public class KitchenObserver implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println("Kitchen received notification: Order #" + order.getId() + " - Status: " + order.getStatus().getDescription());
    }

}
