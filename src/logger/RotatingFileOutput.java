package logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RotatingFileOutput implements LogOutput {
    private final String baseFilePath;
    private final int maxFileSizeBytes;
    private int fileIndex = 0;

    public RotatingFileOutput(String baseFilePath, int maxFileSizeBytes) {
        this.baseFilePath = baseFilePath;
        this.maxFileSizeBytes = maxFileSizeBytes;
    }

    @Override
    public void write(String message) {
        try {
            File currentFile = new File(baseFilePath + "_" + fileIndex + ".log");

            if (currentFile.exists() && currentFile.length() > maxFileSizeBytes) {
                fileIndex++;
                currentFile = new File(baseFilePath + "_" + fileIndex + ".log");
            }

            try (FileWriter writer = new FileWriter(currentFile, true)) {
                writer.write(message + System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("Failed to write log to file: " + e.getMessage());
        }
    }
}