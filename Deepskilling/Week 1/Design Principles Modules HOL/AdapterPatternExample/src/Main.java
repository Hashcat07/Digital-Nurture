public class Main {
    public static void main(String[] args) {
        PaymentProcessor payment;

        payment = new GPayAdapter(new GPayGateway());
        payment.processPayment(150.0);

        payment = new PayTMAdapter(new PayTMGateway());
        payment.processPayment(299.99);
    }
}