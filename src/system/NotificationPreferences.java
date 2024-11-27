package system;

public class NotificationPreferences {
    private Notification notificationChain;

    public NotificationPreferences() {
        this.notificationChain = new BasicNotification();
    }

    public void addNotificationChannel(Notification newChannel) {
        this.notificationChain = newChannel;
    }

    public Notification getNotificationChain() {
        return this.notificationChain;
    }

    public void send(String message) {
        this.notificationChain.send(message);
    }
}