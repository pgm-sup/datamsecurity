package com.wyc.mapper;




import com.wyc.entity.UserInfo;
import com.wyc.entity.UserRoleInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {
    /**
     * 获取用户信息
     * @param paramMap
     * @return List<UserInfo>
     */
    List<UserInfo> getUserInfos(Map<String, Object> paramMap);

    /**
     * 获取用户角色信息
     * @param paramMap
     * @return List<UserRoleInfo>
     */
    List<UserRoleInfo> getUserRoleInfos(Map<String, Object> paramMap);
}
