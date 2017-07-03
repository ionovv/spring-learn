package ch3.LookupMethodInjection;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:config/app-context-ch3.xml-lookup-method.ch3.xml");
        ctx.refresh();
        DemoBean abstractBean = (DemoBean) ctx.getBean("abstractLookupBean");
        DemoBean standardBean = (DemoBean) ctx.getBean("standardLookupBean");
        displayinfo(standardBean);
        displayinfo(abstractBean);
    }

    public static void displayinfo(DemoBean bean) {
        MyHelper helperl = bean.getMyHelper();
        MyHelper helper2 = bean.getMyHelper();
        System.out.println("Helper Instances the Same?: " + (helperl == helper2));

        StopWatch stopWatch = new StopWatch();

        stopWatch.start("lookupDemo");

        for (int х = 0; х < 100000; х++) {
            MyHelper helper = bean.getMyHelper();
            helper.doSomethingHelpful();
        }

        stopWatch.stop();

        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}