package com.cafeteria.observer;

public class KitchenObserver implements Observer {

    @Override
    public void update(String message) {

        System.out.println("Kitchen received notification: " + message);

    }

}