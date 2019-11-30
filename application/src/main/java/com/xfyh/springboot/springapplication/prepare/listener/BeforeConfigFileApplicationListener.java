package com.xfyh.springboot.springapplication.prepare.listener;

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.lang.Nullable;

/**
 * @Description:
 *
 *      Before {@link ConfigFileApplicationListener} 执行
 * @Auther: xfyh
 * @Date: 2019/11/30 16:22
 */
public class BeforeConfigFileApplicationListener implements SmartApplicationListener,Ordered {

    @Override
    public boolean supportsSourceType(@Nullable Class<?> sourceType) {
        return true;
    }

    @Override
    public int getOrder() {
        // ConfigFileApplicationListener小1
        return ConfigFileApplicationListener.DEFAULT_ORDER-1;
    }

    /**
     *  {@link ConfigFileApplicationListener}实现一致
     * @param eventType
     * @return
     */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("========BeforeConfigFileApplicationListener#onApplicationEvent=============");
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent preparedEvent = (ApplicationEnvironmentPreparedEvent) event;
            Environment environment = preparedEvent.getEnvironment();
            System.out.println("environment.getProperty(\"name\") : " + environment.getProperty("name"));
        }
        if (event instanceof ApplicationPreparedEvent) {
            ApplicationPreparedEvent preparedEvent2 = (ApplicationPreparedEvent) event;
            final ConfigurableApplicationContext applicationContext = preparedEvent2.getApplicationContext();
            System.out.println("applicationContext : " + applicationContext.getId());
        }
    }
}
