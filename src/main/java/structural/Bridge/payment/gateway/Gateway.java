package com.codencode.payment.gateway;

public interface Gateway {
    void processPayment(double amount);
}
