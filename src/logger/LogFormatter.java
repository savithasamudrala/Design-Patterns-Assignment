package logger;

public interface LogFormatter {
    String format(String severity, String message);
}
