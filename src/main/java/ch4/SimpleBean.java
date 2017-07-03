package ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {

    private static final String DEFAULT_NAME = "Luke Skywalker";
    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void init() {
        System.out.println("Initializing bean");// инициализация бина
        if (name == null) {
            System.out.println("Using default name");// использование стандартного имени
            name = DEFAULT_NAME;
        }
        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Уоu must set the age property of any beans of type "
                    // Должно быть установлено свойство age любого бина типа
                    + SimpleBean.class);
        }
    }

    public String toString() {
        return "Name: " + name + "\nAge: " + age;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:config/ch4/app-context-xml-SimpleBean.xml");
        ctx.refresh();
        SimpleBean simpleBeanl = getBean("simpleBeanl", ctx);
        SimpleBean simpleBean2 = getBean("simpleBean2", ctx);
        SimpleBean simpleBeanЗ = getBean("simpleBeanЗ", ctx);
    }

    private static SimpleBean getBean(String beanName, ApplicationContext ctx) {
        try {
            SimpleBean bean = (SimpleBean) ctx.getBean(beanName);
            System.out.println(bean);
            return bean;
        } catch (BeanCreationException ех) {
            System.out.println("An error occured in bean configuration: "
                    + ех.getMessage()); // В конфигурации бина произошла ошибка
            return null;
        }
    }
}