package com.xfyh.springboot.springapplication.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Description:
 * Spring Boot 通过  SpringApplicationRunListener 的实现类  EventPublishingRunListener
 * 利用 Spring Framework 事件API ，广播 Spring Boot 事件
 *
 * Spring Framework 事件/监听器编程模型
 *      Spring 应用事件
 *          普通应用事件： ApplicationEvent
 *          应用上下文事件： ApplicationContextEvent
 *      Spring 应用监听器
 *          接口编程模型： ApplicationListener
 *          注解编程模型： @EventListener
 *      Spring 应用事广播器
 *          接口： ApplicationEventMulticaster
 *          实现类： SimpleApplicationEventMulticaster
 *              执行模式：同步或异步
 *
 * @Auther: xfyh
 * @Date: 2019/11/30 17:07
 */
public class HelloWorldRunListener implements SpringApplicationRunListener {

    public HelloWorldRunListener(SpringApplication application, String[] args) {
    }

    /**
     * Spring 应用刚启动
     */
    @Override
    public void starting() {
        System.out.println("-----------HelloWorldRunListener# starting------------");
    }

    /**
     * ConfigurableEnvironment 准备妥当，允许将其调整
     * @param environment
     */
    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    /**
     * ConfigurableApplicationContext 准备妥当，允许将其调整
     * @param context
     */
    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    /**
     * ConfigurableApplicationContext 已装载，但仍未启动
     * @param context
     */
    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    /**
     * ConfigurableApplicationContext 已启动，此时 Spring Bean 已初始化完成
     * @param context
     */
    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    /**
     * Spring 应用正在运行
     * @param context
     */
    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("------------HelloWorldRunListener running------------");
    }

    /**
     * Spring 应用运行失败
     * @param context
     * @param exception
     */
    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("--------failed----------");
    }
}
