package system;

public class SlackNotification implements Notification {
    private final Notification wrappedNotification;

    public SlackNotification(Notification notification) {
        this.wrappedNotification = notification;
    }

    @Override
    public void send(String message) {
        wrappedNotification.send(message);
        System.out.println("Slack Notification: Sending '" + message + "' to Slack.");
    }
}