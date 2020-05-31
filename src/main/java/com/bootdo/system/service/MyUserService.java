package com.bootdo.system.service;

import com.bootdo.system.domain.UserDO;

import java.util.List;

/**
 * @author helloLi
 * @version 1.0
 * @date 2020/4/26 20:06
 */
public interface MyUserService {
    int save(UserDO userDO);
    int update(UserDO userDO);
    int remove(UserDO userDO);
    List<UserDO> list();
}
