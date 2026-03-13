package com.cafeteria.strategy;

public class DigitalWalletStrategy implements PaymentStrategy {

    @Override
    public String getName() {
        return "Digital Wallet";
    }

    @Override
    public void pay(double amount) {
        System.out.println("Pago realizado con billetera digital por: $" + amount);
    }

}
