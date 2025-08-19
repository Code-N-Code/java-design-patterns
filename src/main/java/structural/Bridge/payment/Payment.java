package com.codencode.payment;

import com.codencode.payment.gateway.Gateway;

public abstract class Payment {
    protected Gateway gateway;

    public Payment(Gateway gateway) {
        this.gateway = gateway;
    }

    public abstract void processPayment(double amount);
}
