package com.codencode.payment;

import com.codencode.payment.gateway.Gateway;

public class CreditCardPayment extends Payment {
    public CreditCardPayment(Gateway gateway) {
        super(gateway);
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Paying through credit card");
        gateway.processPayment(amount);
    }

}
