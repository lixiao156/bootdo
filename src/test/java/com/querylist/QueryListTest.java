package com.querylist;

import com.bootdo.redis.RedisService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author helloLi
 * @version 1.0
 * @date 2020/5/18 11:36
 */
@SpringBootTest
public class QueryListTest {

    @Autowired
    RedisService redisService;

    @Test
    public void queryList() {
        redisService.get((long) 1);
    }
}
