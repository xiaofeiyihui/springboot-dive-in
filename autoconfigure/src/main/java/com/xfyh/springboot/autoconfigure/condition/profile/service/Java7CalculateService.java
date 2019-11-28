package com.xfyh.springboot.autoconfigure.condition.profile.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @Description: 定义不同的profile
 * @Auther: xfyh
 * @Date: 2019/11/28 16:09
 */
@Profile("java7")//配置profile
@Service
public class Java7CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        System.out.println("Java 7 for 循环实现 ");
        int sum =0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }

    //测试
    public static void main(String[] args) {
        final CalculateService calculateService = new Java7CalculateService();
        System.out.println(calculateService.sum(1,2,3,4,5,6,7,8,9,10));
    }
}
