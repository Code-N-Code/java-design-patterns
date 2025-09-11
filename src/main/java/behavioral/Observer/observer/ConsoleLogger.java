package com.codencode.observer;

import java.time.LocalDateTime;

public class ConsoleLogger implements Observer {
    @Override
    public void update(String symbol, double price) {
        System.out.println(LocalDateTime.now() + " | " + symbol + " price: " + price);
    }
}
