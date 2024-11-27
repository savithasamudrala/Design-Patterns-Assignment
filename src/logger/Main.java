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

        logger.setLogFormatter((severity, message) -> String.format("[CUSTOM FORMAT] %s: %s", severity, message));
        logger.log("INFO", "Using a custom formatter now");

        logger.setLogOutput(new RemoteOutput("http://example.com/api/logs"));
        logger.log("INFO", "Testing remote logging");

        logger.setLogOutput(new RotatingFileOutput("logs/rotating", 1024));
        for (int i = 0; i < 100; i++) {
            logger.log("DEBUG", "This is log message number " + i);
        }

    }
}
