package org.example;

public class OrderService {

    private final OrderApi orderApi;

    public OrderService(OrderApi orderApi) {
        this.orderApi = orderApi;
    }

    public String process(int orderId) {
        return orderApi.getOrder(orderId);
    }
}