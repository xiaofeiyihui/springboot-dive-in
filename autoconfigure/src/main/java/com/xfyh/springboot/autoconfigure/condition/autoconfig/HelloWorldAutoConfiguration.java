package com.xfyh.springboot.autoconfigure.condition.autoconfig;

import com.xfyh.springboot.autoconfigure.condition.condition.ConditionalOnSystemProperty;
import com.xfyh.springboot.autoconfigure.enable.EnableHelloWorld;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 模拟spring boot的自动装配
 * HelloWorldAutoConfiguration
 *      条件判断： user.name == "xfyh"
 *      模式注解： @Configuration
 *      @Enable 模块： @EnableHelloWorld ->  HelloWorldImportSelector -> HelloWorldConfiguration - >  helloWorld
 * @Auther: xfyh
 * @Date: 2019/11/28 17:27
 */
@Configuration // Spring 模式注解装配
@EnableHelloWorld // Spring @Enable 模块装配
@ConditionalOnSystemProperty(name = "user.name",value = "MrLi") // 条件装配
public class HelloWorldAutoConfiguration {
}
