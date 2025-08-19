package com.codencode.payment.gateway;

public class JuspayPaymentGateway implements Gateway{
    @Override
    public void processPayment(double amount) {
        System.out.println("Juspay Payment Gateway");
        System.out.println("Processing payment of amount: " + amount);
    }
}
