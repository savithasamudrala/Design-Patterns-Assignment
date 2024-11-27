package system;

public class SlackNotification implements Notification {
    private final Notification wrappedNotification;
    private boolean enabled = true;

    public SlackNotification(Notification notification) {
        this.wrappedNotification = notification;
    }

    @Override
    public void send(String message) {
        wrappedNotification.send(message);
        if (enabled) {
            System.out.println("Slack Notification: Sending '" + message + "' to Slack.");
        }
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}