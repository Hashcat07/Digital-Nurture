public class PayTMAdapter implements PaymentProcessor{
    private final PayTMGateway payTMGateway;

    public PayTMAdapter(PayTMGateway payTMGateway){
        this.payTMGateway=payTMGateway;
    }
    @Override
    public void processPayment(double amt) {
        payTMGateway.doTransaction(amt);
    }
}
