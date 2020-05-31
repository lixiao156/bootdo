package com.bootdo.article.dao;

import com.bootdo.article.domain.StatisticDo;
import io.swagger.models.auth.In;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author helloLi
 * @version 1.0
 * @date 2020/5/25 16:40
 */
public interface StatisticDao {
    // 统计访问数量
    int searchClickNum(String string, Date date);

    //int save(int newsId,Date date);

    int save(StatisticDo statisticDo);

    int update(String url, long newsId,int times);

    int search(Map<String,Object> map);

    StatisticDo sqlSearch(String url,long newsId);

}
