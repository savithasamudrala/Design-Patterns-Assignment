package system;

public class EmailNotification implements Notification {
    private final Notification wrappedNotification;
    private boolean enabled = true;

    public EmailNotification(Notification notification) {
        this.wrappedNotification = notification;
    }

    @Override
    public void send(String message) {
        wrappedNotification.send(message);
        if (enabled) {
            System.out.println("Email Notification: Sending '" + message + "' via Email.");
        }
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}