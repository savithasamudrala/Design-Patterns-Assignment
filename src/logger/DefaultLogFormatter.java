package logger;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DefaultLogFormatter implements LogFormatter {
    @Override
    public String format(String severity, String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return String.format("[%s] [%s] %s", timestamp, severity, message);
    }
}
