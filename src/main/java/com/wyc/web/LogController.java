package com.wyc.web;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.wyc.entity.LogEntity;
import com.wyc.service.LogService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/log")
//@RequiresRoles("admin")
public class LogController {

    @Autowired
    private LogService logService;


    @RequestMapping("/queryLogs")
    public PageInfo findUserPageFromMybatis(HttpServletRequest request, @RequestParam(required = false) Integer pageNum, @RequestParam(required = false)Integer pageSize) {
        System.out.println(pageNum);
        System.out.println(pageSize);
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        List<LogEntity> logs = logService.getAllLogs(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(logs);
        Page page = (Page) logs;
        return pageInfo;
    }
}
