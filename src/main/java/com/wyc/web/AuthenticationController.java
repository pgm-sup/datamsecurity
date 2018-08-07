package com.wyc.web;

import com.wyc.common.IConstants;
import com.wyc.common.MyRealm;
import com.wyc.entity.JsonBean;
import com.wyc.entity.UserInfo;
import com.wyc.utils.ParamUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping()
@CrossOrigin
public class AuthenticationController {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    final MyRealm shiroDbRealm;
    @Autowired
    public AuthenticationController(MyRealm shiroDbRealm) {
        this.shiroDbRealm = shiroDbRealm;
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "/login";
    }

    @ResponseBody
    @RequestMapping(value = "/login_in", produces = "application/json;charset=UTF-8")
    public JsonBean loginIn(HttpServletRequest request) {
        JsonBean reJson = new JsonBean();
        Map paramMap = ParamUtils.handleServletParameter(request);
        String userCode = MapUtils.getString(paramMap, "userCode");
        String userPwd = MapUtils.getString(paramMap, "userPwd");
        System.out.println(userCode + ";" + userPwd );
        // shiro认证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userCode, userPwd);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            reJson.setStatus(IConstants.RESULT_INT_ERROR);
            reJson.setMessage("账户不存在");
            return reJson;
        } catch (DisabledAccountException e) {
            reJson.setStatus(IConstants.RESULT_INT_ERROR);
            reJson.setMessage("账户存在问题");
            return reJson;
        } catch (AuthenticationException e) {
            reJson.setStatus(IConstants.RESULT_INT_ERROR);
            reJson.setMessage("密码错误");
            return reJson;
        } catch (Exception e) {
            log.info("登陆异常", e);
            reJson.setMessage("登陆异常");
            return reJson;
        }
        reJson.setStatus(IConstants.RESULT_INT_SUCCESS);
        String res = subject.getPrincipals().toString();
//        System.out.println(res);
//        if (subject.hasRole("川沙新镇")) {
//            System.out.println("川沙新镇的角色");
//        }
//        if (subject.hasRole("guest")) {
//            res = res + "----------你拥有guest权限";
//        }
        reJson.setData(subject.getSession().getId());
        System.out.println(subject.getSession().getId());
//        UserInfo userInfo = (UserInfo) subject.getPrincipal();
        AuthorizationInfo authorizationInfo = shiroDbRealm.doGetAuthorizationInfo(subject.getPrincipals());
        Collection<String> roles = authorizationInfo.getRoles();
        String role = null;
        for (String r : roles) {
            role = r;
        }
//        System.out.println(role + "role");
//        System.out.println(subject.getSession().getId());
        reJson.setMessage(role);
        return reJson;
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @RequestMapping(value = "/unauth")
    @ResponseBody
    public Object unauth() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "1000000");
        map.put("msg", "未登录");
        return map;
    }
}
