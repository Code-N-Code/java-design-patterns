package com.codencode.payment.gateway;

public class PaypalPaymentGateway implements Gateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Paypal Payment Gateway");
        System.out.println("Processing payment of amount: " + amount);
    }
}
