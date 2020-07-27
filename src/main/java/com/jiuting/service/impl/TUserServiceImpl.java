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

    @Override
    public Integer preconditionSearchFriends(String myUserId, String friendUsername) {

        TUser user = queryUserInfoByUsername(friendUsername);

        // 1. 搜索的用户如果不存在，返回[无此用户]
        if (user == null) {
            return SearchFriendsStatusEnum.USER_NOT_EXIST.status;
        }

        // 2. 搜索账号是你自己，返回[不能添加自己]
        if (user.getId().equals(myUserId)) {
            return SearchFriendsStatusEnum.NOT_YOURSELF.status;
        }

        // 3. 搜索的朋友已经是你的好友，返回[该用户已经是你的好友]
        Example mfe = new Example(MyFriends.class);
        Criteria mfc = mfe.createCriteria();
        mfc.andEqualTo("myUserId", myUserId);
        mfc.andEqualTo("myFriendUserId", user.getId());
        MyFriends myFriendsRel = myFriendsMapper.selectOneByExample(mfe);
        if (myFriendsRel != null) {
            return SearchFriendsStatusEnum.ALREADY_FRIENDS.status;
        }

        return SearchFriendsStatusEnum.SUCCESS.status;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public TUser queryUserInfoByUsername(String username) {
        Example ue = new Example(Users.class);
        Criteria uc = ue.createCriteria();
        uc.andEqualTo("username", username);
        return userMapper.selectOneByExample(ue);
    }

}
