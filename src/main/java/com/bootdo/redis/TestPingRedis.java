package com.bootdo.redis;

import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import redis.clients.jedis.Jedis;

import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarOutputStream;

/**
 * @author helloLi
 * @version 1.0
 * @date 2020/5/23 12:54
 */
public class TestPingRedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.150.128",6391);
        jedis.auth("123456");
        System.out.println(jedis.ping());
        jedis.set("test","helloRedis");
        System.out.println(jedis.get("test"));

        String hget1 = jedis.hget("\\xac\\xed\\x00\\x05t\\x001search_redis_maphttp://localhost/shownews.html131", "131");
        System.out.println(hget1);

    }
}
