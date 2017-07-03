package ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanNamePrinterExample {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:config/ch4/app-context-xml-BeanNamePrinter.xml");
        ctx.refresh();
        BeanNamePrinter bean = (BeanNamePrinter) ctx.getBean("beanNamePrinter");
        bean.someOperation();
    }
}
