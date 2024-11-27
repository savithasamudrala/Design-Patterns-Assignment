package logger;

public class Main {
    public static void main(String[] args) {
        //Logger logger1 = Logger.getInstance();
        //Logger logger2 = Logger.getInstance();

        //System.out.println(logger1 == logger2);

        //logger1.log("Logger initialized!");


        Logger logger = Logger.getInstance();

        logger.log("INFO", "Application started");
        logger.log("DEBUG", "Debugging enabled");
        logger.log("ERROR", "Error occurred");


        System.out.println("Logs written to logs.txt");

        logger.archiveLogs("archived_logs.txt", true);
        logger.log("INFO", "New log message after archiving");



        System.out.println("Log History:");
        for (String log : logger.getLogHistory()) {
            System.out.println(log);
        }

        logger.log("INFO", "Logging to console by default");

        logger.setLogOutput(new FileOutput("dynamic_logs.txt"));
        logger.log("DEBUG", "Logging to a file now");

        logger.setLogOutput(new ConsoleOutput());
        logger.log("ERROR", "Back to logging to the console");
    }
}
