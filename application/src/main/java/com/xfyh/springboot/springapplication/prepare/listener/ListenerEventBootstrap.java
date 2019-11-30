package com.xfyh.springboot.springapplication.prepare.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: 事件监听
 *  参考：spring-boot-autoconfigure-2.2.1.RELEASE-sources.jar!/META-INF/spring.factories
 * @Auther: lxf
 * @Date: 2019/11/30 15:29
 */
//@SpringBootApplication
public class ListenerEventBootstrap {
    public static void main(String[] args) {
   /*     final ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(ListenerEventBootstrap.class)
                .run(args);
        applicationContext.addApplicationListener(event -> System.out.println("监听到事件--："+event));
       // applicationContext.refresh();

        applicationContext.close();*/

        final AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext();
        annotationContext.addApplicationListener(event -> {
            System.out.println("监听事件："+event);

            final ApplicationListener afterHelloWorldApplicationListener = new AfterHelloWorldApplicationListener();
            afterHelloWorldApplicationListener.onApplicationEvent(event);
            final ApplicationListener helloWorldApplicationListener = new HelloWorldApplicationListener();
            helloWorldApplicationListener.onApplicationEvent(event);



        });

        //启动上下文
       annotationContext.refresh();

       annotationContext.publishEvent("hello world");
       annotationContext.publishEvent("2019");

       annotationContext.publishEvent(new ApplicationEvent("xfyh"){});

        annotationContext.close();
    }
}
