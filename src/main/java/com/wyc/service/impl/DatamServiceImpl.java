package com.wyc.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wyc.service.DatamService;
import com.wyc.utils.HttpClientUtil;
import com.wyc.utils.HttpRequestMethedEnum;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Service
public class DatamServiceImpl implements DatamService {


    @Override
    public String getData(String params) throws UnsupportedEncodingException {
//        String url = "http://100.124.10.1:1521/dataset/json?" + params;
        String url = "http://10.242.181.48:11521/dataset/json?" + params;

//        // 存储相关的header值
//        Map<String,String> header = new HashMap<String, String>();
//        //encoding--->token
//        header.put("Authorization", "设置头");

        String response = HttpClientUtil.sendHttp(HttpRequestMethedEnum.HttpGet,url, null,null);

//        System.out.println(JSON.toJSONString(JSONObject.parseObject(response),true));
        return response;
    }
}
