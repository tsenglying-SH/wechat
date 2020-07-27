package com.jiuting.service.impl;

import com.jiuting.mapper.TUserMapper;
import com.jiuting.pojo.TUser;
import com.jiuting.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.n3r.idworker.Sid;


/**
 * @ClassName TUserServiceImpl
 * @Description TODO
 * @Author Tsenglying
 * @Date 2020/7/27 15:03
 * @Version 1.0
 **/
@Service
public class TUserServiceImpl implements TUserService {

    @Autowired
    private TUserMapper userMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUserNameIsExit(String username) {
        TUser user = new TUser();
        user.setUsername(username);
        TUser result = userMapper.selectOne(user);
        return result != null ? true : false;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public TUser queryUserForLogin(String username, String psw) {
        TUser user1 = new TUser();
        user1.setUsername(username);
        user1.setPassword(psw);
        TUser result1 = userMapper.selectOne(user1);
        return result1;
    }

    @Override
    public TUser saveUser(TUser user) {
        String userId = Sid.next();
        user.setPassword(user.getPassword());
        user.setNickName(user.getUsername());
        user.setFaceImg("");
        user.setFaceImgBig("");
        //生成二维码
        user.setQrcode("");
        user.setId(userId);
        userMapper.insert(user);
        return user;
    }
}
