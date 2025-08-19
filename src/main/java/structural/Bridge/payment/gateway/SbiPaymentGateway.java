package com.codencode.payment.gateway;

public class SbiPaymentGateway implements Gateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("SBI Payment Gateway");
        System.out.println("Processing payment of amount: " + amount);
    }
}
