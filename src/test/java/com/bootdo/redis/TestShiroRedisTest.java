package com.bootdo.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author helloLi
 * @version 1.0
 * @date 2020/5/24 9:45
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestShiroRedisTest {
    @Autowired
    private TestShiroRedis testShiroRedis;
    @Test
    public void search() {
        //TestShiroRedis testShiroRedis = new TestShiroRedis();
        testShiroRedis.search("hello6","5");

    }
}