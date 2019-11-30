package com.xfyh.springboot.springapplication.prepare.deduce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description:
 * @Auther: xfyh
 * @Date: 2019/11/30 10:42
 */
@SpringBootApplication
public class SpringApplicationPrepare {

    public static void main(String[] args) {

        /**
         * 1.web应用类型推断
         *
         * 参考： 2.0.2  org.springframework.boot.SpringApplication#deduceWebApplicationType
         * 2.2.1 {@link SpringApplication#deduceFromClasspath}
         * Web Reactive： WebApplicationType.REACTIVE  ——需要引入其他jar
         * Web Servlet： WebApplicationType.SERVLET
         * 非 Web： WebApplicationType.NONE
         */
        //这种会走类型推断逻辑
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringApplicationPrepare.class, args);

        new SpringApplicationBuilder(SpringApplicationPrepare.class)
                .web(WebApplicationType.NONE)//指定了非web应用类型
                .run(args);

        /**
         * 2. 推断引导类（Main Class）
         *
         * 2.2.1 {@link SpringApplication#deduceMainApplicationClass()}
         */


    }
}
