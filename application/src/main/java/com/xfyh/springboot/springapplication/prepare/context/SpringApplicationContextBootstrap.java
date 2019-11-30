package com.xfyh.springboot.springapplication.prepare.context;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description: 加载自定义的应用上下文初始器：
 *
 *  参考：spring-boot-autoconfigure-2.2.1.RELEASE-sources.jar!/META-INF/spring.factories
 *
 *  实现：
 *      实现类： org.springframework.core.io.support.SpringFactoriesLoader
 *      配置资源： META-INF/spring.factories
 *      排序： AnnotationAwareOrderComparator#sort
 * @Auther: xfyh
 * @Date: 2019/11/30 14:25
 */
@SpringBootApplication
public class SpringApplicationContextBootstrap {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(SpringApplicationContextBootstrap.class)
               // .web(WebApplicationType.SERVLET)
                .run(args);

        System.out.println("ConfigurableApplicationContext 类型："+applicationContext.getClass().getName());

        System.out.println("Environment 类型：" + applicationContext.getEnvironment().getClass().getName());

        // 注册应用事件监听器
        applicationContext.addApplicationListener(event -> {
            System.out.println("监听到事件: " + event);
        });

        applicationContext.close();
    }
}
