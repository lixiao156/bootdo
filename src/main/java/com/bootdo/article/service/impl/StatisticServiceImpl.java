package com.bootdo.article.service.impl;

import com.bootdo.article.dao.StatisticDao;
import com.bootdo.article.domain.NewsDO;
import com.bootdo.article.domain.StatisticDo;
import com.bootdo.article.service.StatisticService;
import com.bootdo.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author helloLi
 * @version 1.0
 * @date 2020/5/25 16:43
 */
@Service
public class StatisticServiceImpl implements StatisticService{
    @Autowired
    StatisticDao statisticDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public StatisticDo sqlSearch(String url, int newsId) {
        return statisticDao.sqlSearch(url,newsId);
    }

    @Override
    public int searchClickNum(String string, Date date) {
        return statisticDao.searchClickNum(string,date);
    }

    @Override
    public int save(StatisticDo statisticDo) {
        //保存于更新之间的区别
        return statisticDao.save(statisticDo);
    }

    // 隔一段时间调用一次更新怎么会出现redis查询不到与 --mysql--交互
    @Override
    public int update(String url, long newsId) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        if(hashOperations.get(url,newsId) == null){
            HashMap map = new HashMap<String,Object>();
            map.put("url",url);
            map.put("newsId",newsId);
            int times = statisticDao.search(map);
            hashOperations.put(url,newsId,times);
            return 1;
        }else {
            System.out.println(hashOperations.get(url,newsId));
            int times = (int) hashOperations.get(url, newsId);
            hashOperations.put(url,newsId,times);
            System.out.println( hashOperations.get(url,newsId));
            int update = statisticDao.update(url, newsId, times);
            if(update>0){
                return 1;
            }else {
                return 0;
            }
        }

    }
    //查询点击次数  ---不需要存在的方法
    @Override
    public int RedisSearch(String url, long newsId) {
        // 获取当前的浏览量 使用url可以确定为唯一

        HashOperations hashOperations = redisTemplate.opsForHash();

        if(hashOperations.get(url,newsId) == null){
            if(statisticDao.sqlSearch(url,newsId) == null){
                return 0;
            }else {
                StatisticDo statisticDo = statisticDao.sqlSearch(url, newsId);
                int times = statisticDo.getTimes();
                hashOperations.put(url,newsId,times);
                return times;
            }

        }else{
            int times = (int)hashOperations.get(url, newsId);
            return (int) times;
        }
    }

   // 更新redis中的点击信息
    @Override
    public void updateRedis(String KeyUrl, long newsId, int times) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put(KeyUrl,newsId,times);

    }
   // 保存点击次数信息
    @Override
    public void saveRedis(String KeyUrl, long newsId, int times) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put(KeyUrl,newsId,times);
    }

}
