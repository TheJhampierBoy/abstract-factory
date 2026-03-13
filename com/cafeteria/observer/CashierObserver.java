package com.cafeteria.observer;

public class CashierObserver implements Observer {

    @Override
    public void update(String message) {

        System.out.println("Cashier received the notification: " + message);

    }

}