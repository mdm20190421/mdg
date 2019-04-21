package com.hk.service.sys;

import com.hk.model.UserInfo;

public interface UserInfoService {

    /**
     * 根据用户id获取用户
     *
     * @param uid 用户id
     *
     * @return userinfo
     */
    UserInfo getUserInfo(Integer uid);

    /**
     *  getUserByUsername
     * @param username
     * @return
     */
    UserInfo getUserByUsername(String username);
}
