package com.bootdo.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author helloLi
 * @version 1.0
 * @date 2020/5/26 19:29
 */
public class TestDate {
    @Autowired
    RedisTemplate redisTemplate;

    public static void main(String[] args) {
        Date date = new Date();

//      一、获取当前系统时间和日期并格式化输出:
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");//设置日期格式
        String dateTime = df.format(date); // Formats a Date into a date/time string.
        System.out.println(dateTime);  // 2017-09-24 23:33:20
    }
}
