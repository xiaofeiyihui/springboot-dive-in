package com.xfyh.springboot.autoconfigure.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * @Description: {@link Repository}
 * Repository 二级派生
 * @Auther: xfyh
 * @Date: 2019/11/28 13:53
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@OneLevelRepository
public @interface TwoLevelRepository {
    String value() default "";
}
