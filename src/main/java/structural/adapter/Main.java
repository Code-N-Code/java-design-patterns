package structural.adapter;

public class Main {
    public static void main(String[] args) {
        Logger logger = new FileLoggerAdapter(new FileLogger());
        logger.log("Hello World again.");
    }
}