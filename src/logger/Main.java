package logger;

public class Main {
    public static void main(String[] args) {
        //Logger logger1 = Logger.getInstance();
        //Logger logger2 = Logger.getInstance();

        //System.out.println(logger1 == logger2);

        //logger1.log("Logger initialized!");


        Logger logger = Logger.getInstance();

        logger.log("INFO", "Application started");
        logger.log("DEBUG", "Debugging mode enabled");
        logger.log("ERROR", "An error occurred");


    }
}
