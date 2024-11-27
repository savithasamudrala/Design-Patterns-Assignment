package logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Logger {
    private static Logger instance;
    private LogOutput logOutput;
    private LogFormatter logFormatter;
    private final List<String> logHistory = new ArrayList<>();
    private final String logFilePath = "logs.txt";

    private Logger() {
        this.logOutput = new ConsoleOutput();
        this.logFormatter = new DefaultLogFormatter();
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) { //EC: User Story #6
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

    public void setLogFormatter(LogFormatter logFormatter) {
        this.logFormatter = logFormatter;
    }

    public void log(String severity, String message) {
        String formattedMessage = logFormatter.format(severity, message);
        synchronized (logHistory) {
            logHistory.add(formattedMessage);
        }
        writeLogs(formattedMessage);
        logOutput.write(formattedMessage);
    }

    public List<String> getLogHistory() {
        synchronized (logHistory) {
            return Collections.unmodifiableList(logHistory);
        }
    }

    private void writeLogs(String message) {
        try (FileWriter writer = new FileWriter(logFilePath, true)) {
            writer.write(message + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Failed to write log to file: " + e.getMessage());
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
