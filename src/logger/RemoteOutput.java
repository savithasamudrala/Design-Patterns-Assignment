package logger;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;

public class RemoteOutput implements LogOutput {
    private final String serverUrl;

    public RemoteOutput(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    @Override
    public void write(String message) {
        int retries = 3;
        while (retries > 0) {
            try {
                URL url = new URL(serverUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");

                String jsonPayload = "{\"log\":\"" + message + "\"}";

                try (OutputStream os = connection.getOutputStream()) {
                    os.write(jsonPayload.getBytes());
                    os.flush();
                }

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    return; // Successful log
                } else {
                    System.err.println("Failed to send log to server. Response code: " + responseCode);
                }
            } catch (IOException e) {
                System.err.println("Failed to send log to server: " + e.getMessage());
            }
            retries--;
        }
        System.err.println("Failed to send log after retries.");
    }

}
