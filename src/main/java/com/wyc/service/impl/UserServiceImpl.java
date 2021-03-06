package com.wyc.service.impl;


import com.wyc.entity.UserInfo;
import com.wyc.entity.UserRoleInfo;
import com.wyc.mapper.UserInfoMapper;
import com.wyc.service.BaseServiceClient;
import com.wyc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private BaseServiceClient baseServiceClient;

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<UserInfo> getUserInfos(Map<String, Object> paramMap) {
        paramMap.put("state", 1);
        return userInfoMapper.getUserInfos(paramMap);
    }

    @Override
    public List<UserRoleInfo> getUserRoleInfos(Map<String, Object> paramMap) {
        paramMap.put("state", 1);
        return userInfoMapper.getUserRoleInfos(paramMap);
    }

    @Override
    public boolean addUserInfo(UserInfo userInfo) {
        if(1 == baseServiceClient.insert(userInfo)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public HashMap getUserInfo(long id) {
        return baseServiceClient.query(id, UserInfo.class);
    }

    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
        if(1 == baseServiceClient.update(userInfo)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteUserInfo(long id) {
        UserInfo user = new UserInfo();
        user.setId(id);
        if(1 == baseServiceClient.delete(user)) {
            return true;
        } else {
            return false;
        }
    }

}
