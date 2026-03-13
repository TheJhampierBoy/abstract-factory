package com.cafeteria.strategy;

public interface PaymentStrategy {
    String getName();
    void pay(double amount);
}
