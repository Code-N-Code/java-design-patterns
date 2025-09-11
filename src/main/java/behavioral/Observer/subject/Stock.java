package com.codencode.subject;

import com.codencode.observer.Observer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Stock implements Subject{
    private final String symbol;
    private double price;
    private final List<Observer> observers = new CopyOnWriteArrayList<>();
    private final Random random = new Random();

    public Stock(String symbol, double initialPrice) {
        this.symbol = symbol;
        this.price = initialPrice;
    }

    @Override
    public void attach(Observer o) { observers.add(o); }

    @Override
    public void detach(Observer o) { observers.remove(o); }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(symbol, price);
        }
    }

    // Simulates price changes every few seconds
    public void startPriceFeed() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(() -> {
            double change = (random.nextDouble() - 0.5) * 10; // +/-5 fluctuation
            price = Math.round((price + change) * 100.0) / 100.0; // 2 decimals
            notifyObservers();
        }, 0, 5, TimeUnit.SECONDS);
    }
}
