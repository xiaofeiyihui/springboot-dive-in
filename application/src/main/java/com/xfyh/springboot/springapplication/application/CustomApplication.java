package com.xfyh.springboot.springapplication.application;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Auther: xfyh
 * @Date: 2019/11/29 14:09
 */
@SpringBootApplication
public class CustomApplication {
    public static void main(String[] args) {
        //基本方式：内部有默认处理
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(CustomApplication.class, args);

        //自定义
        // 方式一
        final SpringApplication springApplicationRun = new SpringApplication(CustomApplication.class);
        springApplicationRun.setWebApplicationType(WebApplicationType.NONE);
        springApplicationRun.setBannerMode(Banner.Mode.CONSOLE);
        springApplicationRun.setAdditionalProfiles("prod");
        springApplicationRun.setHeadless(true);
        final ConfigurableApplicationContext applicationContext1 = springApplicationRun.run(args);

        //方式二
        final ConfigurableApplicationContext applicationContextBuilder = new SpringApplicationBuilder(CustomApplication.class)
                .web(WebApplicationType.NONE)
                .profiles("prof")
                .bannerMode(Banner.Mode.CONSOLE)
                .headless(true)
                .run(args);

        //方式三
        Set<String> sources = new HashSet();
        // 配置Class 名称,source不一定非得main所在的类名，理论上只要添加@SpringBootApplication都可以
        sources.add(CustomApplicationOther.class.getName());
        SpringApplication springApplication = new SpringApplication();
        // source可以是 a class name, package name, or an XML resource location
        springApplication.setSources(sources);
        springApplication.run(args);

        /**
         * 小结：不关哪种方式都会走到 {@link SpringApplication#run(String...)}方法
         */


    }

    @SpringBootApplication
    public class CustomApplicationOther {

    }

}
