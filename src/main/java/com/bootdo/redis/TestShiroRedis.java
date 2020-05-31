package com.bootdo.redis;

import com.bootdo.common.redis.shiro.RedisManager;
import com.bootdo.common.redis.shiro.RedisSessionDAO;
import com.bootdo.common.utils.R;
import com.bootdo.system.config.ShiroConfig;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpSession;


/**
 * @author helloLi
 * @version 1.0
 * @date 2020/5/24 9:02
 */
@Component
public class TestShiroRedis {
    @Autowired
    RedisManager redisManager;
    @Autowired
    RedisSessionDAO redisSessionDAO;



    public void search(String x,String y){
        redisSessionDAO.setRedisManager(redisManager);
        redisManager.init();
        redisSessionDAO.getActiveSessions();
        System.out.println( redisSessionDAO.getKeyPrefix());
        System.out.println(redisSessionDAO.getRedisManager());
        System.out.println( "----------------"+redisSessionDAO.getActiveSessions());


    }


}
