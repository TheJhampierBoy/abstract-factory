package com.cafeteria.strategy;

public class CashPaymentStrategy implements PaymentStrategy {

    @Override
    public String getName() {
        return "Cash";
    }

    @Override
    public void pay(double amount) {
        System.out.println("Pago realizado en efectivo por: $" + amount);
    }

}
