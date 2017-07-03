package ch4;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

public class DestructiveBeanWithJSR250{
    private File file;
    private String filePath;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean"); // инициализация бина
        if (filePath == null) {
            throw new IllegalArgumentException(
                    "You must specify the filePath property of "// Свойство filePath должно быть установлено в классе
                            + DestructiveBeanWithJSR250.class);
        }
        this.file = new File(filePath);
        this.file.createNewFile();
        System.out.println("File exists: " + file.exists());// файл существует
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying Bean"); //уничтожение бина
        if (!file.delete()) {// ОШБК: не удается удалить файл
            System.err.println("ERROR: failed to delete file.");
        }
        System.out.println("File exists: " + file.exists());// файл существует
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) throws Exception {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:config/ch4/app-context-xml-DestructiveBeanWithJSR250.xml");
        ctx.refresh();
        DestructiveBeanWithJSR250 bean = (DestructiveBeanWithJSR250) ctx.getBean("destructiveBean");
        System.out.println("Calling destroy()"); //вызов метода destroy()
        ctx.destroy();
        System.out.println("Called destroy()"); // метод destroy() вызван
    }
}