package com.xfyh.springboot.springapplication.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:
 *
 * 根据准备阶段的推断 Web 应用类型创建对应的  ConfigurableApplicationContext 实例：
 *      Web Reactive： AnnotationConfigReactiveWebServerApplicationContext
 *      Web Servlet： AnnotationConfigServletWebServerApplicationContext
 *      非 Web： AnnotationConfigApplicationContext
 *
 * 根据准备阶段的推断 Web 应用类型创建对应的  ConfigurableEnvironment 实例：
 *      Web Reactive： StandardEnvironment
 *      Web Servlet： StandardServletEnvironment
 *      非 Web： StandardEnvironment
 *
 * @Auther: xfyh
 * @Date: 2019/11/30 17:08
 */

@SpringBootApplication
public class ApplicationRunBootstrap {
    public static void main(String[] args) {
      /*  final AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext();
        annotationContext.addApplicationListener(event -> {
            System.out.println("监听事件："+event);
        });
        annotationContext.refresh();
        annotationContext.publishEvent("测试，hello world");
        annotationContext.close();*/

        /**
         * 启动执行顺序：SpringApplicationRunListener# starting-> ApplicationListener(ApplicationEnvironmentPreparedEvent) -> ApplicationContextInitializer -> ApplicationListener(ApplicationPreparedEvent)
         *  ->ApplicationListener(ContextRefreshedEvent) -> SpringApplicationRunListener# running
         *     1.{@link HelloWorldRunListener }  实现  {@link org.springframework.boot.SpringApplicationRunListener }
         *     2.{@link com.xfyh.springboot.springapplication.prepare.listener.BeforeConfigFileApplicationListener }实现{@link ConfigFileApplicationListener -> ApplicationListener}
         *     3.{@link com.xfyh.springboot.springapplication.prepare.context.HelloWorldApplicationContextInitializer }实现{@link org.springframework.context.ApplicationContextInitializer }
         *     4.{@link com.xfyh.springboot.springapplication.prepare.listener.BeforeConfigFileApplicationListener }实现{@link ConfigFileApplicationListener -> ApplicationListener}
         *     5.{@link com.xfyh.springboot.springapplication.prepare.listener.HelloWorldApplicationListener }实现{@link org.springframework.context.ApplicationListener}
         *     6.{@link HelloWorldRunListener }  实现  {@link org.springframework.boot.SpringApplicationRunListener }
         */
        final ConfigurableApplicationContext run = SpringApplication.run(ApplicationRunBootstrap.class, args);
        run.addApplicationListener(event -> {
            System.out.println("监听事件："+event);
        });
        run.publishEvent("测试，run hello world");
        run.close();


    }
}
