package com.cafeteria.observer;

import com.cafeteria.model.Order;

public class CashierObserver implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println("Caja recibió notificación: Pedido #" + order.getId() + " - Total: $" + order.getTotal());
    }

}
