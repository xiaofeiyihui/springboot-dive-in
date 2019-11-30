package com.xfyh.springboot.springapplication.prepare.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Description:
 *  aAfter HelloWorld {@link ApplicationListener} 监听 {@link ContextRefreshedEvent}
 *
 * @Auther: xfyh
 * @Date: 2019/11/30 16:25
 */

@Order(Ordered.LOWEST_PRECEDENCE+1)
public class AfterHelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("-------AfterHelloWorldApplicationListener-------");
        System.out.println("ContextRefreshedEvent : " + event.getApplicationContext().getId()
                + " , timestamp : " + event.getTimestamp());
    }


}
