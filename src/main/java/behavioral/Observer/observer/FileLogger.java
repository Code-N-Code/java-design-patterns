package com.codencode.observer;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileLogger implements Observer {
    private final String filePath;

    public FileLogger(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void update(String symbol, double price) {
        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.write(LocalDateTime.now() + " | " + symbol + " price: " + price + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
