package logger;
import java.util.ArrayList;
import java.util.List;

import java.io.FileWriter;
import java.io.IOException;

import java.util.Collections;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Logger {
    private static Logger instance;
    private LogOutput logOutput;
    private final List<String> logHistory = new ArrayList<>();
    private final String logFilePath = "logs.txt";

    private Logger() {
        this.logOutput = new ConsoleOutput();
    }
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

    public void setLogOutput(LogOutput logOutput) {
        this.logOutput = logOutput;
    }

    private void writeLogs(String message) {
        try (FileWriter writer = new FileWriter(logFilePath, true)) {
            writer.write(message + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Failed to write log to file: " + e.getMessage());
        }
    }

    public void log(String severity, String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String logEntry = String.format("[%s] [%s] %s", timestamp, severity, message);
        logHistory.add(logEntry);
        System.out.println(logEntry);
        writeLogs(logEntry);
        logOutput.write(logEntry);
    }

    public List<String> getLogHistory() {
        synchronized (logHistory) {
            return new ArrayList<>(logHistory);
        }
    }

    public synchronized void archiveLogs(String archiveFilePath, boolean clearAfterArchive) {
        try (FileWriter writer = new FileWriter(archiveFilePath)) {
            synchronized (logHistory) {
                for (String log : logHistory) {
                    writer.write(log + System.lineSeparator());
                }
                if (clearAfterArchive) {
                    logHistory.clear();
                }
            }
            System.out.println("Logs archived to: " + archiveFilePath);
        } catch (IOException e) {
            System.err.println("Archive logs failure: " + e.getMessage());
        }
    }
}
