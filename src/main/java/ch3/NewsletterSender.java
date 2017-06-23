package ch3;

/**
 * Created by vionov on 19.06.2017.
 */
public interface NewsletterSender {
    void setSmtpServer(String smtpServer);

    String getSmtpServer();

    void setFromAddress(String fromAddress);

    String getFromAddress();

    void send();
}
