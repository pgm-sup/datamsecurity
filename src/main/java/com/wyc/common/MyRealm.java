package com.wyc.common;

import com.wyc.entity.UserInfo;
import com.wyc.entity.UserRoleInfo;
import com.wyc.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Map<String, Object> params = new HashMap<>();
        params.put("userCode", (String) super.getAvailablePrincipal(principalCollection));
        List<UserRoleInfo> userRoleInfos = userService.getUserRoleInfos(params);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if(!userRoleInfos.isEmpty()) {
            for(UserRoleInfo role : userRoleInfos) {
                System.out.println(role.getRoleCode());
                info.addRole(role.getRoleCode());
            }
        }
        return info;
    }

    /**
     * 认证登陆subject身份
     * @param authenticationToken
     * @return AuthenticationInfo
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Map<String, Object> params = new HashMap<>();
        params.put("userCode", (String)authenticationToken.getPrincipal());
        List<UserInfo> userInfos = userService.getUserInfos(params);
        if (userInfos.isEmpty()) {
            throw new UnknownAccountException();
        } else if(userInfos.size() > 1) {
            throw new DisabledAccountException();
        } else {
            UserInfo user = userInfos.get(0);
            // 校验密码
            return new SimpleAuthenticationInfo(authenticationToken.getPrincipal(), user.getUserPwd(), ByteSource.Util.bytes("2w@W"),  getName());
        }
    }

}
