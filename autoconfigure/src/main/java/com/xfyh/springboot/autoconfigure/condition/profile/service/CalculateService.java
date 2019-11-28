package com.xfyh.springboot.autoconfigure.condition.profile.service;

/**
 * @Description: 求和服务
 * @Auther: xfyh
 * @Date: 2019/11/28 16:07
 */
public interface CalculateService {
    /**
     * 求和
     * @param values
     * @return
     */
    Integer sum(Integer... values);
}
