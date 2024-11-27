package logger;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput implements LogOutput {
    private final String filePath;

    public FileOutput(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(String message) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(message + System.lineSeparator());
            System.out.println("[INFO] Log written to file: " + filePath);
        } catch (IOException e) {
            System.err.println("Failed to write log to file: " + e.getMessage());
        }
    }
}