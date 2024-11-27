package system;

public class SMSNotification implements Notification {
    private final Notification wrappedNotification;

    public SMSNotification(Notification notification) {
        this.wrappedNotification = notification;
    }

    @Override
    public void send(String message) {
        wrappedNotification.send(message);
        System.out.println("SMS Notification: Sending '" + message + "' via SMS.");
    }
}
