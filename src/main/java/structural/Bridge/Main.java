package com.codencode;

import com.codencode.payment.CreditCardPayment;
import com.codencode.payment.Payment;
import com.codencode.payment.gateway.JuspayPaymentGateway;

public class Main {
    public static void main(String[] args) {
        Payment payment = new CreditCardPayment(new JuspayPaymentGateway());
        payment.processPayment(500);
    }
}
