package ch3.InjectSimple;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("InjectSimpleConfigAnn")
public class InjectSimpleConfigAnn {

    private String name = "Chris Schaefer";
    private int age = 32;
    private float height = 1.778f;
    private boolean programmer = true;
    private Long ageinSeconds = 1009843200L;
}
