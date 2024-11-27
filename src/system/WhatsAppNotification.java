package system;

public class WhatsAppNotification implements Notification {
    private final Notification wrappedNotification;

    public WhatsAppNotification(Notification notification) {
        this.wrappedNotification = notification;
    }

    @Override
    public void send(String message) {
        wrappedNotification.send(message);
        System.out.println("WhatsApp Notification: Sending '" + message + "' via WhatsApp.");
    }
}