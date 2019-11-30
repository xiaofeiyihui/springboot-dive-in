package com.xfyh.springboot.springapplication.prepare.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

/**
 * @Description: 加载自定义的应用上下文初始器：
 *  参考：{@link org.springframework.boot.autoconfigure.SharedMetadataReaderFactoryContextInitializer,\}
 *  参考：{@link org.springframework.context.ApplicationContextInitializer}
 * @Auther: xfyh
 * @Date: 2019/11/30 14:22
 */

public class HelloWorldApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("----------HelloWorldApplicationContextInitializer------------");
        System.out.println("Ordered.HIGHEST_PRECEDENCE ConfigurableApplicationContext.id = "+ applicationContext.getId());
        System.out.println();
    }

    /**
     * 也可以用注解的方式  @Order
     * @return
     */
    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
