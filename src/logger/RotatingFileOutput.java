package logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RotatingFileOutput implements LogOutput {
    private final String baseFilePath;
    private final long maxFileSize;
    private File currentFile;
    private int fileIndex;

    public RotatingFileOutput(String baseFilePath, long maxFileSize) {
        this.baseFilePath = baseFilePath;
        this.maxFileSize = maxFileSize;
        this.currentFile = new File(baseFilePath + "_0.log");
        this.fileIndex = 0;

        if (!currentFile.getParentFile().exists()) {
            currentFile.getParentFile().mkdirs();
        }

        try {
            if (!currentFile.exists()) {
                currentFile.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Failed to create initial log file: " + e.getMessage());
        }
    }

    @Override
    public void write(String message) {
        try (FileWriter writer = new FileWriter(currentFile, true)) {
            writer.write(message + System.lineSeparator());
            System.out.println("[INFO] Log written to rotating file: " + currentFile.getName());
        } catch (IOException e) {
            System.err.println("Failed to write log to rotating file: " + e.getMessage());
        }
        rotateIfNeeded();
    }

    private void rotateIfNeeded() {
        if (currentFile.length() > maxFileSize) {
            try {
                fileIndex++;
                currentFile = new File(baseFilePath + "_" + fileIndex + ".log");
                if (!currentFile.exists()) {
                    currentFile.createNewFile();
                }
                System.out.println("[INFO] Rotating log file to: " + currentFile.getName());
            } catch (IOException e) {
                System.err.println("Failed to rotate log file: " + e.getMessage());
            }
        }
    }
}
