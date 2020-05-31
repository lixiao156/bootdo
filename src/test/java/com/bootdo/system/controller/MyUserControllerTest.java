package com.bootdo.system.controller;

import com.bootdo.common.utils.MD5Utils;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.MyUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author helloLi
 * @version 1.0
 * @date 2020/4/26 21:28
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class  MyUserControllerTest {

    @Autowired(required=false)
    private MyUserService myUserService;


    @Test
    public void save() {
        System.out.println("hello");
        UserDO userDO = new UserDO();

        userDO.setUsername("lisi");
        userDO.setPassword(MD5Utils.encrypt("jhiwono"));
        myUserService.save(userDO);
    }

    @Test
    public void list() {

    }

    @Test
    public void userListMap() {
    }
}