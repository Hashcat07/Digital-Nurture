public class GPayAdapter implements PaymentProcessor{
    private final GPayGateway gPayGateway;

    public GPayAdapter(GPayGateway gPayGateway){
        this.gPayGateway=gPayGateway;
    }

    @Override
    public void processPayment(double amt) {
        gPayGateway.doPayment(amt);
    }
}
