package com.bootdo.article.controller;

import com.bootdo.article.domain.StatisticDo;
import com.bootdo.article.service.StatisticService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @author helloLi
 * @version 1.0
 * @date 2020/5/26 16:22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StatisticControllerTest {
    @Autowired
    StatisticService statisticService;

    @Test
    public void save() {
        StatisticDo statisticDo = new StatisticDo();
        statisticDo.setNewsId(12);
        statisticDo.setClickDate(new Date());
        statisticService.save(statisticDo);
    }

    @Test
    public void update() {
    }


}