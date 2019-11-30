package com.xfyh.springboot.springapplication.prepare.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Description:
 * @Auther: xfyh
 * @Date: 2019/11/30 14:43
 */
@Order(Ordered.LOWEST_PRECEDENCE+1) //最低优先级
public class AfterHelloWorldApplicationContextInitializer<C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C> {
    @Override
    public void initialize(C applicationContext) {
        System.out.println("--------AfterHelloWorldApplicationContextInitializer-----------");
        System.out.println("Ordered.LOWEST_PRECEDENCE ConfigurableApplicationContext.id = "+ applicationContext.getId());
        System.out.println();
    }
}
