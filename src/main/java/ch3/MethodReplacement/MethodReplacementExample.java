package ch3.MethodReplacement;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementExample {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:config/app-context-ch3.xml-replacement-method.ch3.xml");
        ctx.refresh();
        ReplacementTarget replacementTarget = (ReplacementTarget) ctx.getBean("replacementTarget");
        ReplacementTarget standardTarget = (ReplacementTarget) ctx.getBean("standardTarget");
        displayinfo(replacementTarget);
        displayinfo(standardTarget);
    }

    private static void displayinfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Hello World!"));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");
        for (int х = 0; х < 1000000; х++) {
            String out = target.formatMessage("foo");
        }
        stopWatch.stop();
        System.out.println("1000000 invocations took: " + stopWatch.getTotalTimeMillis() + " ms");
    }
}