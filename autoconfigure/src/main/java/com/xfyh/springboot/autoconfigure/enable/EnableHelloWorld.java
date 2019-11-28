package com.xfyh.springboot.autoconfigure.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Description:
 *
 * Spring Framework 3.1 开始支持”@Enable 模块驱动“。所谓“模块”是指具备相同领域的功能组件集合，
 * 组合所形成一个独立的单元。比如 Web MVC 模块、AspectJ代理模块、Caching（缓存）模块、
 * JMX（Java 管 理扩展）模块、Async（异步处理）模块等。
 * 实现方式：
 *      HelloWorldImportSelector ->  HelloWorldConfiguration -> HelloWorld
 * 模拟 {@link org.springframework.scheduling.annotation.EnableAsync}
 * @Auther: xfyh
 * @Date: 2019/11/28 15:26
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloWorldImportSelector.class)
//@Import(HelloWorldConfiguration.class)
public @interface EnableHelloWorld {
}
