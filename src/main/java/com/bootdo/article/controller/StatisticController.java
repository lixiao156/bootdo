package com.bootdo.article.controller;

import com.bootdo.article.dao.StatisticDao;
import com.bootdo.article.domain.StatisticDo;
import com.bootdo.article.service.StatisticService;
import com.bootdo.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author helloLi
 * @version 1.0
 * @date 2020/5/26 8:15
 */
@Controller
@RequestMapping("/article/statistic")
public class StatisticController {
//
//    @Autowired
//    StatisticService statisticService;
//
//
//    @PostMapping("/save")
//    @ResponseBody
//    public R save(StatisticDo statisticDo){
//        //如果表设计了更新时间就写更新时间
//        if(statisticService.save(statisticDo) > 0){
//            return R.ok();
//        }else {
//            return R.error();
//        }
//    }
//
//    @PostMapping("/update")
//    @ResponseBody
//    public R update(StatisticDo statisticDo){
//        statisticDo.setOperateTime(new Date());
//        if(statisticService.update(statisticDo) > 0){
//            return R.ok();
//        }else {
//            return R.error();
//        }
//    }
//
//    @PostMapping("/search")
//    @ResponseBody
//    public StatisticDo search(@RequestParam Map<String,Object>map){
//        StatisticDo statisticDo = statisticService.search(map);
//
//        if(statisticDo != null){
//           return statisticDo;
//        }else {
//            return null;
//        }
//    }
}
