package org.example;

public class NotificationService {

    private final EmailApi emailApi;

    public NotificationService(EmailApi emailApi) {
        this.emailApi = emailApi;
    }

    public void notifyUser(String to) {
        emailApi.sendEmail(to);
    }
}