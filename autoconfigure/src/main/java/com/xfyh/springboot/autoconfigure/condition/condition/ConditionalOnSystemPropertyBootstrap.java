package com.xfyh.springboot.autoconfigure.condition.condition;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Description: 系统属性条件引导类
 * @Auther: xfyh
 * @Date: 2019/11/28 17:12
 */
public class ConditionalOnSystemPropertyBootstrap {

    @Bean
    @ConditionalOnSystemProperty(name = "user.name",value = "xfyh")
    public String helloWorld() {
        return "hello world,xfyh";
    }

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        final String helloWorld = applicationContext.getBean("helloWorld", String.class);

        System.out.println("helloWorld bean:"+ helloWorld);

        applicationContext.close();
    }
}
