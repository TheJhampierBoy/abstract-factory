public class Order {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double total) {

        if(paymentStrategy == null){
            System.out.println("Seleccione una estrategia de pago.");
            return;
        }

        paymentStrategy.pay(total);
    }

}