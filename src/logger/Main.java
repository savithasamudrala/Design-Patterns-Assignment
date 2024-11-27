package logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        System.out.println("=== Testing Logger ===");

        testConsoleLogging(logger);

        testFileLogging(logger);

        testLogArchiving(logger);

        testRemoteLogging(logger);

        testCustomFormatter(logger);

        testRotatingFileLogging(logger);

        testLogHistory(logger);

        System.out.println("=== Testing Complete ===");
    }

    private static void testConsoleLogging(Logger logger) {
        System.out.println("\n=== Testing Console Logging ===");
        logger.setLogOutput(new ConsoleOutput());
        logger.log("INFO", "Console logging test: Application started");
        logger.log("DEBUG", "Console logging test: Debugging enabled");
    }

    private static void testFileLogging(Logger logger) {
        System.out.println("\n=== Testing File Logging ===");
        logger.setLogOutput(new FileOutput("test_logs.txt"));
        logger.log("INFO", "File logging test: Writing to test_logs.txt");
    }

    private static void testLogArchiving(Logger logger) {
        System.out.println("\n=== Testing Log Archiving ===");
        logger.archiveLogs("archived_test_logs.txt", true);
        logger.log("INFO", "Log archiving test: Archived and cleared");
    }

    private static void testRemoteLogging(Logger logger) {
        System.out.println("\n=== Testing Remote Logging ===");
        logger.setLogOutput(new MockRemoteOutput());
        logger.log("INFO", "Remote logging test: Logging to a mock server");
    }


    private static void testCustomFormatter(Logger logger) {
        System.out.println("\n=== Testing Custom Formatter ===");
        logger.setLogFormatter((severity, message) -> String.format("[TEST FORMAT] %s -> %s", severity, message));
        logger.log("INFO", "Custom formatter test: Using test format");
    }

    private static void testRotatingFileLogging(Logger logger) {
        System.out.println("\n=== Testing Rotating File Logging ===");
        logger.setLogOutput(new RotatingFileOutput("logs/test_rotating", 512)); // Smaller size for test
        for (int i = 0; i < 20; i++) {
            logger.log("DEBUG", "Rotating log message #" + i);
        }
    }

    private static void testLogHistory(Logger logger) {
        System.out.println("\n=== Testing Log History ===");
        System.out.println("Log History:");
        for (String log : logger.getLogHistory()) {
            System.out.println(log);
        }
    }
}
