package com.bootdo.system.controller;

import com.bootdo.common.utils.MD5Utils;
import com.bootdo.common.utils.R;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author helloLi
 * @version 1.0
 * @date 2020/4/26 20:26
 */
@Controller
@RequestMapping("/User")
public class MyUserController {
    @Autowired
    private MyUserService myUserService;

    @RequestMapping("/save")
    public R save(UserDO userDO){
       if(userListMap().containsValue(userDO.getUsername())){
           return R.error("存在相同的用户名");
       }else if (userDO!=null){
           String password = userDO.getPassword();
           String pass = MD5Utils.encrypt(password);
           userDO.setPassword(pass);
           if(myUserService.save(userDO) > 0){
               return R.ok();
           }
       }
       return R.error();
    }

    public List<UserDO> list(){
       List<UserDO>  userDOS = myUserService.list();


       return userDOS;
    }

    public Map userListMap(){
        List<UserDO> userDOS = list();
        Map<Long,String> map = new HashMap<>();
        for (UserDO u: userDOS) {
            map.put(u.getUserId(),u.getUsername());
        }
        return map;
    }

}
