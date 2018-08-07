package com.wyc.web;

import com.wyc.service.DatamService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/datam")
public class GetDataController {

    @Autowired
    private DatamService datamService;

    @RequestMapping("/verify")
    public String verify(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
//        String orginUrl = request.getRequestURL()+"?" + request.getQueryString();
//        System.out.println(orginUrl);

        String newUrl = request.getQueryString();

//        Pattern pattern = Pattern.compile("(?<=street\\=).*");
        Pattern pattern = Pattern.compile("\\=([^\\&\\w]+(街道|镇))");
        String urlDecode= URLDecoder.decode(newUrl);
        Matcher matcher = pattern.matcher(urlDecode);
        String street = null;
        if(matcher.find()){
            street = matcher.group(1);
        }
        Subject subject = SecurityUtils.getSubject();
//        System.out.println(subject.getSession().getId() + " hello");
        String json;
//        System.out.println(subject.hasRole(street));
        if(subject.hasRole(street) || subject.hasRole("admin") || street == null){
            json = datamService.getData(newUrl);
        }else {
            return "[]";
        }
        return json;
    }
}
