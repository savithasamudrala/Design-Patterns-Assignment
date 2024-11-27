package system;

import java.util.ArrayList;
import java.util.List;

public class NotificationPreferences {
    private Notification notificationChain;
    private final List<String> notificationHistory;

    public NotificationPreferences() {
        this.notificationChain = new BasicNotification();
        this.notificationHistory = new ArrayList<>();
    }


        public void addNotificationChannel(Notification newChannel) {
        this.notificationChain = newChannel;
    }

    public Notification getNotificationChain() {
        return this.notificationChain;
    }

    public void send(String message) {
        this.notificationChain.send(message);
        notificationHistory.add(message);
    }

    public List<String> getNotificationHistory() {
        return notificationHistory;
    }
}