package system;

public class Main {
    public static void main(String[] args) {
        // Basic Notification
        Notification basicNotification = new BasicNotification();
        basicNotification.send("System update available.");

        // SMS Notification
        Notification smsNotification = new SMSNotification(basicNotification);
        smsNotification.send("System update available.");

        // Email Notification
        Notification emailNotification = new EmailNotification(basicNotification);
        emailNotification.send("System update available.");

        // Slack Notification
        Notification slackNotification = new SlackNotification(basicNotification);
        slackNotification.send("System update available.");

        // Combined Notifications: SMS + Email
        Notification smsAndEmail = new EmailNotification(smsNotification);
        smsAndEmail.send("Critical system alert!");

        // Combined Notifications: SMS + Email + Slack
        Notification allNotifications = new SlackNotification(smsAndEmail);
        allNotifications.send("All hands meeting at 3 PM.");
    }
}
