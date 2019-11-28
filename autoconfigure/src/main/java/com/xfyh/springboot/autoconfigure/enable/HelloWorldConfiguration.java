package com.xfyh.springboot.autoconfigure.enable;

import org.springframework.context.annotation.Bean;

/**
 * @Description: helloWorld配置类
 * @Auther: lxf
 * @Date: 2019/11/28 15:35
 */
public class HelloWorldConfiguration {

    //将返回结果注册到spring容器：
    // key 为方法名：helloWorld——> value为结果："hello world,xfyh."
    @Bean
    public String helloWorld() {
        return "hello world,xfyh.";
    }
}
