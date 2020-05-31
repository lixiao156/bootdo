package com.bootdo.system.service.impl;

import com.bootdo.system.dao.MyUserDao;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author helloLi
 * @version 1.0
 * @date 2020/4/26 20:08
 */
@Service
public class MyUserServiceImpl implements MyUserService {
    @Autowired
    private MyUserDao myUserMapper;
    @Override
    public int save(UserDO userDO) {

       return myUserMapper.save(userDO);
    }

    @Override
    public int update(UserDO userDO) {
        return myUserMapper.update(userDO);

    }

    @Override
    public int remove(UserDO userDO) {
        return myUserMapper.remove(userDO);
    }

    @Override
    public List<UserDO> list() {
        return myUserMapper.list();
    }
}
