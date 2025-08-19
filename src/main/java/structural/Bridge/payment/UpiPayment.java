package com.codencode.payment;

import com.codencode.payment.gateway.Gateway;

public class UpiPayment extends Payment{
    public UpiPayment(Gateway gateway) {
        super(gateway);
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Paying through UPI");
        gateway.processPayment(amount);
    }
}
