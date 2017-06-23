package ch3.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import ch3.MessageProvider;

@Service("messageProvider")
public class ConfigurableMessageProvider implements MessageProvider {

    private String message;

    @Autowired
    public ConfigurableMessageProvider (String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}