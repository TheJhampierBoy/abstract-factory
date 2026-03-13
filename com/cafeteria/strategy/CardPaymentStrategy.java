public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Pago realizado con tarjeta por: " + amount);
    }

}