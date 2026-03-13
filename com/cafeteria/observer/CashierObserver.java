package com.cafeteria.observer;

import com.cafeteria.model.Order;

public class CashierObserver implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println("Cashier received notification: Order #" + order.getId() + " - Total: $" + order.getTotal());
    }

}
