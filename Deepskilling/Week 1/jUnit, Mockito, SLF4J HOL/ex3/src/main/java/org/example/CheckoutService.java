package org.example;

public class CheckoutService {

    private final PaymentApi paymentApi;

    public CheckoutService(PaymentApi paymentApi) {
        this.paymentApi = paymentApi;
    }

    public void checkout() {
        paymentApi.validate();
        paymentApi.charge();
    }
}