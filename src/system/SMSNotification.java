package system;

public class SMSNotification implements Notification {
    private final Notification wrappedNotification;
    private boolean enabled = true;


    public SMSNotification(Notification notification) {
        this.wrappedNotification = notification;
    }

    @Override
    public void send(String message) {
        wrappedNotification.send(message);
        if (enabled) {
            System.out.println("SMS Notification: Sending '" + message + "' via SMS.");
        }
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}