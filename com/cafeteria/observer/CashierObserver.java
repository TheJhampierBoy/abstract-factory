package com.cafeteria.observer;

public class CashierObserver implements Observer {

    @Override
    public void update(String message) {

        System.out.println("[CASHIER MODULE] Notification received -> " + message);

    }

}