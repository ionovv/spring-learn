package ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;

public class SimpleBeanWithJSR250 {

    private static final String DEFAULT_NАME = "Luke Skywalker";
    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("Initializing bean");
        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NАME;
        }
        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the age property of any beans of type " + SimpleBeanWithinterface.class);
        }
    }

    public String toString() {
        return "Name:" + name + "\nAge:" + age;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:config/ch4/app-context-xml-SimpleBeanWithJSR250.xml");
        ctx.refresh();
        SimpleBeanWithJSR250 simpleBeanl = getBean("simpleBeanl", ctx);
        SimpleBeanWithJSR250 simpleBean2 = getBean("simpleBean2", ctx);
        SimpleBeanWithJSR250 simpleBeanЗ = getBean("simpleBeanЗ", ctx);
    }

    private static SimpleBeanWithJSR250 getBean(String beanName, ApplicationContext ctx) {
        try {
            SimpleBeanWithJSR250 bean = (SimpleBeanWithJSR250) ctx.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException ex) {
            System.out.println("An error occured in bean configuration:" + ex.getMessage());
            return null;
        }
    }
}
