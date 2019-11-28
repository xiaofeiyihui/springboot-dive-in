package com.xfyh.springboot.autoconfigure.annotation;

import com.xfyh.springboot.autoconfigure.annotation.repository.MyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description:
 * @Auther: xfyh
 * @Date: 2019/11/28 14:03
 */

@ComponentScan(basePackages = "com.xfyh.springboot.autoconfigure.annotation.repository")
public class RepositoryBootstrap {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(RepositoryBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        final MyRepository myRepository = applicationContext.getBean("myRepository", MyRepository.class);

        System.out.println("myRepository bean: "+myRepository);

        //关闭上下文
       applicationContext.close();


    }
}
