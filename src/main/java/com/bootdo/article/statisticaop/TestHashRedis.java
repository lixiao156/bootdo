package com.bootdo.article.statisticaop;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author helloLi
 * @version 1.0
 * @date 2020/5/30 5:53
 */
public class TestHashRedis {
    @Autowired
    private RedisTemplate redisTemplate;

    public void test(){
        HashOperations hashOperations = redisTemplate.opsForHash();
      //  hashOperations.put();
    }
}
