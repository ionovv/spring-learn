package ch3.InjectSimple;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimpleSpel1 {
    private String name;
    private int age;
    private float height;
    private boolean programmer;
    private Long ageinSeconds;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return this.height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean isProgrammer() {
        return this.programmer;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public Long getAgeinSeconds() {
        return this.ageinSeconds;
    }

    public void setAgeinSeconds(Long ageinSeconds) {
        this.ageinSeconds = ageinSeconds;
    }

    public String toString() {
        return "Name: " + name + "\n" + "Age: " + age + "\n"
                + "Age in Seconds: " + ageinSeconds + "\n"
                + "Height: " + height + "\n"
                + "Is Programmer?: " + programmer;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:config/app-context-xml_injectSimple-config.ch3.xml");
        ctx.refresh();
        InjectSimpleSpel1 simple = (InjectSimpleSpel1) ctx.getBean("injectSimpleSpel");
        System.out.println(simple);
    }
}