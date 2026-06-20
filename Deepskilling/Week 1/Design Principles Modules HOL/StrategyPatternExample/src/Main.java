public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment("1234 5678 9012 3456"));
        context.checkout(500.0);

        context.setPaymentStrategy(new PayPalPayment("ray@example.com"));
        context.checkout(750.0);
    }
}