package com.cafeteria.observer;

import java.util.ArrayList;
import java.util.List;

public class OrderSubject implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {

        for (Observer observer : observers) {
            observer.update(message);
        }

    }

    public void createOrder(String orderName) {

        System.out.println("New order created: " + orderName);

        notifyObservers("New order ready to process: " + orderName);
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public void updateOrderStatus(String orderName, String status) {
    System.out.println("Order: " + orderName + " | Status: " + status);

    notifyObservers("Order '" + orderName + "' changed status to: " + status);
    }

}