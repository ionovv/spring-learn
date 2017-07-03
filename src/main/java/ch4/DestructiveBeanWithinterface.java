package ch4;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

public class DestructiveBeanWithinterface implements InitializingBean, DisposableBean {
    private File file;
    private String filePath;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean"); // инициализация бина
        if (filePath == null) {
            throw new IllegalArgumentException(
                    "You must specify the filePath property of "// Свойство filePath должно быть установлено в классе
                            + DestructiveBeanWithinterface.class);
        }
        this.file = new File(filePath);
        this.file.createNewFile();
        System.out.println("File exists: " + file.exists());// файл существует
    }

    public void destroy1() {
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
        ctx.load("classpath:config/ch4/app-context-xml-DisposableBean.xml");
        ctx.refresh();
        DestructiveBeanWithinterface bean = (DestructiveBeanWithinterface) ctx.getBean("destructiveBean");
        System.out.println("Calling destroy()"); //вызов метода destroy()
        ctx.destroy();
        System.out.println("Called destroy()"); // метод destroy() вызван
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroying Bean"); // уничтожение бина
        if (!file.delete()) {
            // ОШБК: не удается удалить файл
            System.err.println("ERROR: failed to delete file.");
        }
        System.out.println("File exists: " + file.exists());
        // файл существует
    }
}