package logger;

public class MockRemoteOutput implements LogOutput {
    @Override
    public void write(String message) {
        System.out.println("[MOCK] Successfully sent log to mock server: " + message);
    }
}
