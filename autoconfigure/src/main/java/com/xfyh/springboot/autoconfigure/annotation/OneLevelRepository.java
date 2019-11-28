package com.xfyh.springboot.autoconfigure.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * @Description: {@link org.springframework.stereotype.Repository}
 * 模式注解是一种用于声明在应用中扮演“组件”角色的注解。如 Spring Framework 中的  @Repository 标注在任何类上 ，用
 * 于扮演仓储角色的模式注解。 @Component 作为一种由 Spring 容器托管的通用模式组件，任何被  @Component 标准的组件均为
 * 组件扫描的候选对象。类似地，凡是被  @Component 元标注（meta-annotated）的注解，如  @Service ，当任何组件标注它时，
 * 也被视作组件扫 描的候选对象
 * Repository一级派生
 * @Auther: xfyh
 * @Date: 2019/11/28 13:53
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repository
public @interface OneLevelRepository {
    String value() default "";
}
