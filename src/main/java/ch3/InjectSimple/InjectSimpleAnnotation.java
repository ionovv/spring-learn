package ch3.InjectSimple;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimpleAnnotation")
public class InjectSimpleAnnotation {

    @Value("Chris Schaefer")
    private String name;
    @Value("32")
    private int age;
    @Value("11.44")
    private float height;
    @Value("true")
    private boolean programmer;
    @Value("1009843200")
    private Long ageinSeconds;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:config/app-context-xml_injectSimple-annotation.xml");
        ctx.refresh();
        InjectSimpleAnnotation simple = (InjectSimpleAnnotation) ctx.getBean("injectSimpleAnnotation");
        System.out.println(simple);
    }

    public void setAgeinSeconds(Long ageinSeconds) {
        this.ageinSeconds = ageinSeconds;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name : " + name + "\n"
                + "Age:" + age + "\n"
                + "Age in Seconds: " + ageinSeconds + "\n"
                + "Height: " + height + "\n"
                + "Is Programmer?: " + programmer;
    }
}