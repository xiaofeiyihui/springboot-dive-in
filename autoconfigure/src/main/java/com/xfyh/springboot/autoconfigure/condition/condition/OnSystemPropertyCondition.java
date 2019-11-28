package com.xfyh.springboot.autoconfigure.condition.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @Description: 自定义condition条件匹配
 * @Auther: xfyh
 * @Date: 2019/11/28 16:49
 */
public class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        final Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        //获取注解上的name值
        final String propertyName = String.valueOf(annotationAttributes.get("name"));
        //获取注解上的value值
        final String propertyValue = String.valueOf(annotationAttributes.get("value"));
        //获取系统propertyName值
        final String property = System.getProperty(propertyName);
        //比较系统和配置的值
        return propertyValue.equals(property);
    }
}
