package com.xfyh.springboot.autoconfigure.condition.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @Description: 基于编程的方式实现条件配置
 * @Auther: xfyh
 * @Date: 2019/11/28 16:50
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {
    /**
     * 系统属性名
     * @return
     */
    String name() ;

    /**
     * 系统属性值
     * @return
     */
    String value() ;
}
