package system;

public class EmailNotification implements Notification {
    private final Notification wrappedNotification;

    public EmailNotification(Notification notification) {
        this.wrappedNotification = notification;
    }

    @Override
    public void send(String message) {
        wrappedNotification.send(message);
        System.out.println("Email Notification: Sending '" + message + "' via Email.");
    }
}
