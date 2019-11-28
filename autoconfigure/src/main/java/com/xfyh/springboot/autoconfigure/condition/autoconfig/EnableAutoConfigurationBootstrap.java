package com.xfyh.springboot.autoconfigure.condition.autoconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description: 基于spring  boot的自动装配
 * 实现方式：
 *      1. 激活自动装配 -  @EnableAutoConfiguration
 *      2. 实现自动装配 -  XXXAutoConfiguration
 *      3. 配置自动装配实现 -  META-INF/spring.factories
 * @Auther: xfyh
 * @Date: 2019/11/28 17:34
 */
@EnableAutoConfiguration //启动自动装配，会在META-INF/spring.factories找到HelloWorldAutoConfiguration
public class EnableAutoConfigurationBootstrap {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext =
                SpringApplication.run(EnableAutoConfigurationBootstrap.class, args);
        final String helloWorld = applicationContext.getBean("helloWorld", String.class);
        System.out.println("helloWorld bean:"+ helloWorld);
        applicationContext.close();
    }
}
