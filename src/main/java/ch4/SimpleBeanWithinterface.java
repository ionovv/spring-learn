package ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBeanWithinterface implements InitializingBean {
    private static final String DEFAULT_NАME = "Luke Skywalker";
    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void myinit() {
        System.out.println("My Init");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
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
        ctx.load("classpath:config/ch4/app-context-xml-SimpleBeanWithinterface.xml");
        ctx.refresh();
        SimpleBeanWithinterface simpleBeanl = getBean("simpleBeanl", ctx);
        SimpleBeanWithinterface simpleBean2 = getBean("simpleBean2", ctx);
        SimpleBeanWithinterface simpleBeanЗ = getBean("simpleBeanЗ", ctx);
    }

    private static SimpleBeanWithinterface getBean(String beanName, ApplicationContext ctx) {
        try {
            SimpleBeanWithinterface bean = (SimpleBeanWithinterface) ctx.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException ex) {
            System.out.println("An error occured in bean configuration:" + ex.getMessage());
            return null;
        }
    }
}