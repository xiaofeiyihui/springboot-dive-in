package com.xfyh.springboot.autoconfigure.enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.scheduling.annotation.AsyncConfigurationSelector;

/**
 * @Description: 模仿 {@link AsyncConfigurationSelector},直接实现ImportSelector
 * @Auther: xfyh
 * @Date: 2019/11/28 15:29
 */
public class HelloWorldImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{HelloWorldConfiguration.class.getName()};
    }
}
