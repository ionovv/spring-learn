package ch3;

/**
 * Created by vionov on 20.06.2017.
 */
public interface MessageRenderer {
    void render();

    void setMessageProvider(MessageProvider provider);

    MessageProvider getMessageProvider();
}
