package com.bootdo.article.statisticaop;

import com.bootdo.article.domain.StatisticDo;
import com.bootdo.article.service.StatisticService;
import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

/**
 * @author helloLi
 * @version 1.0
 * @date 2020/5/27 10:47
 */

@Aspect
@Component
public class StatisticAop {

    @Autowired
    private StatisticService statisticService;

    @Autowired
    RedisTemplate redisTemplate;


    //方法执行前调用
   @Before("execution (* com.bootdo.home.controller..*.*(..))")
 //   @Before("execution (* com.bootdo.home.controller.HomeController.shownews())")
    public void before() {
        System.out.println("before:统计点击量的方法调用之前)");
    }

    //方法执行后调用
    @After("execution (* com.bootdo.home.controller..*.*(..))")
    public void after() {
        System.out.println("after:统计点击量的方法调用之后)");

    }

    //方法执行的前后调用
  @Around("execution (* com.bootdo.home.controller.HomeController.shownews(..))")

    public Object around(ProceedingJoinPoint point) throws Throwable{


        StatisticDo statisticDo = new StatisticDo();

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        StringBuffer requestURL = request.getRequestURL();
        int idValue  = Integer.parseInt(request.getParameter("id"));
        HashMap map = new HashMap<String,Object>();
        String url = requestURL.toString()+idValue;
        System.out.println(url);
        map.put("url",url);
        map.put("newsId",idValue);
        HashOperations hashOperations = redisTemplate.opsForHash();
        if( hashOperations.get(url,idValue) == null) {
            if (statisticService.sqlSearch(url,idValue) == null) {
                statisticDo.setUrl(url);
                statisticDo.setNewsId(idValue);
                statisticDo.setOperateTime(new Date());
                statisticDo.setClickDate(new Date());
                statisticDo.setTimes(1);
                statisticService.save(statisticDo);
                statisticService.saveRedis(url, idValue, 1);
            } else {

                StatisticDo statisticDo1 = statisticService.sqlSearch(url, idValue);
                int times1 = statisticDo1.getTimes();
                statisticService.updateRedis(url, idValue,times1+1);
                statisticService.update(url,idValue);

            }
        }
        else {
            int times = (int)hashOperations.get(url, idValue);
            statisticService.updateRedis(url,idValue,times+1);
            System.out.println(times);
        }

      Object proceed = point.proceed();//目标方法
      return proceed;

  }
    //方法运行出现异常时调用
    @AfterThrowing(pointcut = "execution (* com.bootdo.home.controller.HomeController.shownews(..))",throwing = "ex")
    public void afterThrowing(Exception ex){
        System.out.println("aop around 方法中的错误");
        System.out.println(ex);
    }
}
