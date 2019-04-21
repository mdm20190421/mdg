package com.hk.service.impl.sys;

import com.hk.dao.UserInfoMapper;
import com.hk.model.UserInfo;
import com.hk.service.sys.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfo(Integer uid) {
        return userInfoMapper.selectByPrimaryKey(uid);
    }

    @Override
    public UserInfo getUserByUsername(String username) {
        return userInfoMapper.selectByUsername(username);
    }
}
