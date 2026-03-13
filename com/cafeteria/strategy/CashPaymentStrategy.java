public class CashPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Pago realizado en efectivo por: " + amount);
    }

}