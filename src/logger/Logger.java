package logger;
import java.util.ArrayList;
import java.util.List;

import java.io.FileWriter;
import java.io.IOException;


public class Logger {
    private static Logger instance;
    private final List<String> logHistory = new ArrayList<>();
    private final String logFilePath = "logs.txt";

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    private void writeLogs(String message) {
        try (FileWriter writer = new FileWriter(logFilePath, true)) {
            writer.write(message + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Failed to write log to file: " + e.getMessage());
        }
    }

    public void log(String severity, String message) {
        String logEntry = "[" + severity + "] " + message;
        logHistory.add(logEntry);
        System.out.println(logEntry);
        writeLogs(logEntry);
    }

    public List<String> getLogHistory() {
        return new ArrayList<>(logHistory);
    }
}
