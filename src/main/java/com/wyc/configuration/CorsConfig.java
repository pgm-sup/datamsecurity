package com.wyc.configuration;

import org.apache.commons.httpclient.HttpStatus;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 跨域访问更改权限
 */
//@Configuration
public class CorsConfig implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletresponse, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletresponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        response.setHeader("Access-Control-Allow-Origin", "*"); //允许来之域名为http://localhost的请求
        String token = request.getHeader("X-DATAM-AUTH");
//        System.out.println(request.getRequestURL());
        System.out.println("filter origin:" + token);//通过打印，可以看到一次非简单请求，会被过滤两次，即请求两次，第一次请求确认是否符合跨域要求（预检），这一次是不带headers的自定义信息，第二次请求会携带自定义信息。
        if ("OPTIONS".equals(request.getMethod())) {//这里通过判断请求的方法，判断此次是否是预检请求，如果是，立即返回一个204状态吗，标示，允许跨域；预检后，正式请求，这个方法参数就是我们设置的post了
            response.setStatus(HttpStatus.SC_NO_CONTENT); //HttpStatus.SC_NO_CONTENT = 204
            response.setHeader("Access-Control-Allow-Origin", "*"); //允许来之域名为http://localhost的请求
            response.setHeader("Access-Control-Allow-Headers", "Origin,No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With, userId, token, X-DATAM-AUTH");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE"); //请求允许的方法
            response.setHeader("Access-Control-Max-Age", "3600");    //身份认证(预检)后，xxS以内发送请求不在需要预检，既可以直接跳
        }
        if("OPTIONS".equals(request.getMethod())){
            response.getWriter().write("od");
        }else {
            chain.doFilter(request,response);
        }

    }

    @Override
    public void destroy() {

    }
}
