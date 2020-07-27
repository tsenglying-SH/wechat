package com.jiuting.service;

import com.jiuting.pojo.TUser;

public interface TUserService {

    // 判断用户名是否存在
     boolean queryUserNameIsExit(String username);

    // 查询用户是否存在
     TUser queryUserForLogin(String username ,String psw);

    // 用户注册
    TUser saveUser(TUser user);

}
