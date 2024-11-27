package system;

public class WhatsAppNotification implements Notification {
    private final Notification wrappedNotification;
    private boolean enabled = true;

    public WhatsAppNotification(Notification notification) {
        this.wrappedNotification = notification;
    }

    @Override
    public void send(String message) {
        wrappedNotification.send(message);
        if (enabled) {
            System.out.println("WhatsApp Notification: Sending '" + message + "' via WhatsApp.");
        }
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}