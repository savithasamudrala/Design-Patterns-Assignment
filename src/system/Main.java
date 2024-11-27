package system;

public class Main {
    public static void main(String[] args) {
        NotificationPreferences preferences = new NotificationPreferences();
/*
        // Basic Notification
        preferences.send("Welcome to the notification system!");

        // Add SMS
        preferences.addNotificationChannel(new SMSNotification(preferences.getNotificationChain()));
        preferences.send("You've added SMS notifications.");

        // Add Email
        preferences.addNotificationChannel(new EmailNotification(preferences.getNotificationChain()));
        preferences.send("You've added Email notifications.");

        // Add Slack
        preferences.addNotificationChannel(new SlackNotification(preferences.getNotificationChain()));
        preferences.send("You've added Slack notifications.");

        // Add WhatsApp
        preferences.addNotificationChannel(new WhatsAppNotification(preferences.getNotificationChain()));
        preferences.send("You've added WhatsApp notifications.");

        Notification allNotifications = new SlackNotification(
                new EmailNotification(
                        new SMSNotification(new BasicNotification())
                )
        );
        allNotifications.send("New system update!");

        System.out.println("\nNotification History:");
        for (String notification : preferences.getNotificationHistory()) {
            System.out.println(notification);
        }

 */

        SMSNotification sms = new SMSNotification(preferences.getNotificationChain());
        EmailNotification email = new EmailNotification(sms);
        SlackNotification slack = new SlackNotification(email);
        WhatsAppNotification whatsapp = new WhatsAppNotification(slack);


        // User Story 10 Testing
        preferences.addNotificationChannel(whatsapp);

        preferences.send("System maintenance scheduled for tonight.");

        slack.setEnabled(false);
        whatsapp.setEnabled(false);

        preferences.send("System maintenance rescheduled to tomorrow.");

        slack.setEnabled(true);

        preferences.send("System maintenance confirmed for tomorrow at midnight.");

    }
}
