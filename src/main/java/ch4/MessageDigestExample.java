package ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestExample {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:config/ch4/app-context-xml-MessageDigestFactoryBean.xml");
        ctx.refresh();
        MessageDigester digester = (MessageDigester) ctx.getBean("digester");
        digester.digest("Hello World!");
    }
}
