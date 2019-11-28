package com.xfyh.springboot.autoconfigure.condition.profile.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @Description:
 * @Auther: xfyh
 * @Date: 2019/11/28 16:12
 */
@Profile("java8")
@Service
public class Java8CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        System.out.println("Java 8 Lambda 实现");
        return Arrays.stream(values).reduce(0,Integer::sum);
    }

    //测试
    public static void main(String[] args) {
        final CalculateService calculateService = new Java8CalculateService();
        System.out.println(calculateService.sum(1,2,3,4,5,6,7,8,9,10));
    }
}
