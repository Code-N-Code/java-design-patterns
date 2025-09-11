package com.codencode;

import com.codencode.observer.ConsoleLogger;
import com.codencode.observer.FileLogger;
import com.codencode.observer.Observer;
import com.codencode.subject.Stock;

public class Main {
    public static void main(String[] args) {
        Stock tcs = new Stock("TCS", 3500.00);

        Observer consoleLogger = new ConsoleLogger();
        Observer fileLogger = new FileLogger("prices.log");

        tcs.attach(consoleLogger);
        tcs.attach(fileLogger);

        tcs.startPriceFeed(); // Price changes every 5 seconds

        // keep main thread alive (for demo purpose)
        try { Thread.sleep(30000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
