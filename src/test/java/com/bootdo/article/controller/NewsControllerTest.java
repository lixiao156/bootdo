package com.bootdo.article.controller;


import com.bootdo.article.service.NewsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * @author helloLi
 * @version 1.0
 * @date 2020/5/20 17:47
 */

public class NewsControllerTest {

    @Autowired
    private NewsService newsService;


    @Test
    public void searchLikeTitle() {
        HashMap map = new HashMap<String,Object>();
    }
}
