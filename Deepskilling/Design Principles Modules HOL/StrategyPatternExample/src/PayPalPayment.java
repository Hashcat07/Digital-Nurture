public class PayPalPayment implements PaymentStrategy {
    private final String id;

    public PayPalPayment(String id) {
        this.id = id;
    }

    @Override
    public void pay(double amt) {
        System.out.println("Paid " + amt + " using PayPal account " + id);
    }
}