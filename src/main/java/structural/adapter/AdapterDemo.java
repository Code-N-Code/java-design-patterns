package structural.adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        Logger logger = new FileLoggerAdapter(new FileLogger());
        logger.log("Hello World again.");
    }
}