package com.jiuting.controller;

import com.jiuting.pojo.TMyFriend;
import com.jiuting.pojo.TUser;
import com.jiuting.pojo.vo.UserVO;
import com.jiuting.service.TUserService;
import com.jiuting.utils.JSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TUserController
 * @Description TODO
 * @Author Tsenglying
 * @Date 2020/7/27 14:31
 * @Version 1.0
 **/
@RestController
@RequestMapping("/u")
public class TUserController {

    @Autowired
    private TUserService userService;

    @PostMapping("/registOrLogin")
    public JSONResult registOrLogin(@RequestBody TUser user) {

        // 1,判断用户名和密码不为空
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return JSONResult.errorMsg("用户名或密码不能为空");
        }

        // 2.判断用户名是否存在，若存在就登录，否则注册
        boolean userIsExist = userService.queryUserNameIsExit(user.getUsername());
        TUser userResult=null;
        if (userIsExist) {
            // 2.1 登录
            userResult = userService.queryUserForLogin(user.getUsername(), user.getPassword());
            if (userResult == null) {
                return JSONResult.errorMsg("用户名或密码不正确");
            }
        } else {
            // 2.2 注册
             userResult = userService.saveUser(user);
        }
        // 专门的返回对象，去掉了User中的无用信息
        UserVO userVO= new UserVO();
        BeanUtils.copyProperties(userResult,userVO);
        return JSONResult.ok(userVO);
    }

    @PostMapping("/search")
    public JSONResult searchUser(String myUserId, String friendUsername)
            throws Exception {

        // 0. 判断 myUserId friendUsername 不能为空
        if (StringUtils.isBlank(myUserId)
                || StringUtils.isBlank(friendUsername)) {
            return JSONResult.errorMsg("");
        }

        // 前置条件 - 1. 搜索的用户如果不存在，返回[无此用户]
        // 前置条件 - 2. 搜索账号是你自己，返回[不能添加自己]
        // 前置条件 - 3. 搜索的朋友已经是你的好友，返回[该用户已经是你的好友]
        Integer status = userService.preconditionSearchFriends(myUserId, friendUsername);
        if (status == SearchFriendsStatusEnum.SUCCESS.status) {
            TUser user = userService.queryUserInfoByUsername(friendUsername);
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            return JSONResult.ok(userVO);
        } else {
            String errorMsg = SearchFriendsStatusEnum.getMsgByKey(status);
            return JSONResult.errorMsg(errorMsg);
        }
    }




}
