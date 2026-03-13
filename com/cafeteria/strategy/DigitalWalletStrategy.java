public class DigitalWalletStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Pago realizado con billetera digital por: " + amount);
    }

}