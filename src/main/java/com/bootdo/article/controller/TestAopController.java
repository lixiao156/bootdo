package com.bootdo.article.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author helloLi
 * @version 1.0
 * @date 2020/5/31 20:53
 */
@Controller
@RequestMapping("/Aop")
public class TestAopController {
    @ResponseBody
    public String testAop(){
        return "index/about";
    }

}
