package com.xfyh.springboot.springapplication.prepare.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Description: 监听下上文刷新事件
 * @Auther: xfyh
 * @Date: 2019/11/30 15:19
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        System.out.println("-----HelloWorldApplicationListener#ContextRefreshedEvent-----");
        System.out.println("HelloWorld : " + event.getApplicationContext().getId()
                + " , timestamp : " + event.getTimestamp());
        System.out.println();
    }
}
