package com.querylist;

import com.bootdo.article.dao.NewsDao;
import com.bootdo.article.domain.NewsDO;
import com.bootdo.redis.RedisService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author helloLi
 * @version 1.0
 * @date 2020/5/18 8:21
 */
@Service
public class QueryList{
//    @Autowired
//    private RedisService redisService;
//    @Autowired
//    private NewsDao newsMapper;
//
//    public List<NewsDO> queryList(Long id) {
//        List<NewsDO> newsDOS = null;
//        HashMap map = new HashMap<Integer,NewsDO>();
//
//        if (redisService.get(id) == null){
//            newsDOS.add((NewsDO) newsMapper.list(map));
//            redisService.set("newsDOS",newsDOS);
//        }else {
//            newsDOS = (List<NewsDO>) redisService.get(id);
//        }
//        return newsDOS;
//    }
        }

