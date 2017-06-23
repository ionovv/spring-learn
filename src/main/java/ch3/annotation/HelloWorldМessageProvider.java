package ch3.annotation;

import org.springframework.stereotype.Service;
import ch3.MessageProvider;

public class HelloWorldМessageProvider implements MessageProvider {

    public String test;

    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
