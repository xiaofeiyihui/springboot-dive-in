package com.xfyh.springboot.autoconfigure.enable;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description: 启动EnableHelloWorl
 *
 * @Auther: xfyh
 * @Date: 2019/11/28 15:44
 */
@EnableHelloWorld
public class EnableHelloWorldBootstrap {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(EnableHelloWorldBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        final String helloWorld = applicationContext.getBean("helloWorld", String.class);

        System.out.println("helloWorld bean:"+ helloWorld);

        applicationContext.close();


    }
}
