package com.bootdo.article.service;

import com.bootdo.article.domain.StatisticDo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author helloLi
 * @version 1.0
 * @date 2020/5/25 16:42
 */
public interface StatisticService {

    StatisticDo sqlSearch(String url,int newsId);

    int searchClickNum(String string, Date date);

    int save(StatisticDo statisticDo);

    int update(String url, long newsId);

    int RedisSearch(String url,long newId);

    void updateRedis(String url, long newsId, int times);

    void saveRedis(String url, long newsId, int times);
}
