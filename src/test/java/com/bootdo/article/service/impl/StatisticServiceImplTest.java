package com.bootdo.article.service.impl;

import com.bootdo.article.domain.StatisticDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;

/**
 * @author helloLi
 * @version 1.0
 * @date 2020/5/31 14:48
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StatisticServiceImplTest {
    @Autowired
    StatisticServiceImpl statisticService;



    @Test
    public void save() {
        StatisticDo statisticDo = new StatisticDo();
        statisticDo.setUrl("httpRequest");
        statisticDo.setNewsId(-11);
        statisticDo.setTimes(1);
        statisticDo.setClickDate(new Date());
        statisticDo.setOperateTime(new Date());
        int save = statisticService.save(statisticDo);
        System.out.println(save);
    }

    @Test
    public void update() {
        int httpRequest = statisticService.update("httpRequest", -11);
        System.out.println(httpRequest);
    }

    @Test
    public void testSearch() {
    }

    @Test
    public void updateRedis() {
        statisticService.updateRedis("httpRequest", -11,15);
    }

    @Test
    public void saveRedis() {
        statisticService.saveRedis("testURL",-12,10);
    }

    @Test
    public void satisticSave() {
    }

    @Test
    public void sqlSearch() {
        StatisticDo statisticDo = statisticService.sqlSearch("httpRequest", -11);
        System.out.println(statisticDo.toString());
    }


    @Test
    public void redisSearch() {
        int i = statisticService.RedisSearch("http://localhost/shownews.html136", 136);
        System.out.println(i);
    }
}