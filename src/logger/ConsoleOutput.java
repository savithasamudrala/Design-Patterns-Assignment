package logger;

public class ConsoleOutput implements LogOutput {
    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
