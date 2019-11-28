package com.xfyh.springboot.autoconfigure.condition.profile;

import com.xfyh.springboot.autoconfigure.condition.profile.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Description: profile是基于配置的方式实现的条件注解
 * @Auther: xfyh
 * @Date: 2019/11/28 16:15
 */
@SpringBootApplication(scanBasePackages = "com.xfyh.springboot.autoconfigure.condition.profile.service")//将service加入容器
public class ProfileBootstrap {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext7 = new SpringApplicationBuilder(ProfileBootstrap.class)
                .web(WebApplicationType.NONE)
                .profiles("java7")
                .run(args);

        final CalculateService calculateService7 = applicationContext7.getBean(CalculateService.class);
        System.out.println("calculateService.sum(1...10) : " +
                calculateService7.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        // 关闭上下文
        applicationContext7.close();

        final ConfigurableApplicationContext applicationContext8 = new SpringApplicationBuilder(ProfileBootstrap.class)
                .web(WebApplicationType.NONE)
                .profiles("java8")
                .run(args);

        final CalculateService calculateService8 = applicationContext8.getBean(CalculateService.class);
        System.out.println("calculateService.sum(1...10) : " +
                calculateService8.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        // 关闭上下文
        applicationContext8.close();
    }
}
