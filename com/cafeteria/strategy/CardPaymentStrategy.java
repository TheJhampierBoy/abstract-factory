package com.cafeteria.strategy;

public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public String getName() {
        return "Card";
    }

    @Override
    public void pay(double amount) {
        System.out.println("Pago realizado con tarjeta por: $" + amount);
    }

}
