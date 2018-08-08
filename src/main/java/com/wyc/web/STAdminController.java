package com.wyc.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyc.utils.HttpClientUtil;
import com.wyc.utils.HttpRequestMethedEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wyc.common.IConstants;
import com.wyc.entity.JsonBean;
import com.wyc.entity.Polling;
import com.wyc.entity.Schdule;
import com.wyc.entity.SixModule;
import com.wyc.service.StAdminService;

@RestController
@RequestMapping("/admin")
public class STAdminController {
	
	@Autowired
	private StAdminService stAdminService;
	
	@RequestMapping("/add")
	public JsonBean addData(HttpServletRequest req, HttpServletResponse res, @RequestBody JSONObject obj) {;
		String data=obj.toJSONString();
		System.out.println("data:" + data);
		List<Schdule> schdules = new ArrayList<>();
		List<Polling> pollings = new ArrayList<>();
    	JSONObject json = JSON.parseObject(data);
		String blockOne = json.getString("blockOne");
		String blockTwo = json.getString("blockTwo");
		String blockThree = json.getString("blockThree");
		String version =  Double.toString(json.getDouble("version"));
		Integer view = json.getInteger("view");
		JSONArray schduleArray=JSONArray.parseArray(blockOne);
		JSONArray pollingArray=JSONArray.parseArray(blockTwo);
		// 值班情况
		for(int i=0;i<schduleArray.size();i++){
            String STREETNAME=JSONObject.parseObject(JSONObject.toJSONString(schduleArray.get(i))).getString("STREETNAME");
            String value1=JSONObject.parseObject(JSONObject.toJSONString(schduleArray.get(i))).getString("value1");
            String value2=JSONObject.parseObject(JSONObject.toJSONString(schduleArray.get(i))).getString("value2");
            String value3=JSONObject.parseObject(JSONObject.toJSONString(schduleArray.get(i))).getString("value3");
            Schdule schdule = new Schdule(STREETNAME, value3, value2, value1,version, view);
            schdules.add(schdule);
		}
		// 一键轮询
		for(int i=0;i<pollingArray.size();i++){
            Integer iconNumber=Integer.parseInt(JSONObject.parseObject(JSONObject.toJSONString(pollingArray.get(i))).getString("iconNumber"));
            String eventUrl=JSONObject.parseObject(JSONObject.toJSONString(pollingArray.get(i))).getString("eventUrl");
            String eventType=JSONObject.parseObject(JSONObject.toJSONString(pollingArray.get(i))).getString("eventType");
            String iconName=JSONObject.parseObject(JSONObject.toJSONString(pollingArray.get(i))).getString("iconName");
            String STREETNAME=JSONObject.parseObject(JSONObject.toJSONString(pollingArray.get(i))).getString("STREETNAME");
            String imagUrl=JSONObject.parseObject(JSONObject.toJSONString(pollingArray.get(i))).getString("imgUrl");
            Polling polling = new Polling(iconNumber, eventUrl, eventType, iconName, STREETNAME, imagUrl, version, view);
            pollings.add(polling);
		}
		
		// 六大模块
		JSONObject blockThreeObj = JSON.parseObject(blockThree);
        String street = blockThreeObj.getString("street");
        String subject1 = blockThreeObj.getString("subject1");
        String subject2 = blockThreeObj.getString("subject2");
        String subject3 = blockThreeObj.getString("subject3");
        String custom = blockThreeObj.getString("custom");
        String title1 = blockThreeObj.getString("title1");
        String title2 = blockThreeObj.getString("title2");
        String title3 = blockThreeObj.getString("title3");
        String title4 = blockThreeObj.getString("title4");
        String title5 = blockThreeObj.getString("title5");
        String title6 = blockThreeObj.getString("title6");
        String title7 = blockThreeObj.getString("title7");
        String iframe1 = blockThreeObj.getString("iframe1");
        String iframe2 = blockThreeObj.getString("iframe2");
        String iframe3 = blockThreeObj.getString("iframe3");
        String iframe4 = blockThreeObj.getString("iframe4");
        String iframe5 = blockThreeObj.getString("iframe5");
        String iframe6 = blockThreeObj.getString("iframe6");
        String modal = blockThreeObj.getString("modal");
        String modal1 = blockThreeObj.getString("modal1");
        String modal2 = blockThreeObj.getString("modal2");
        String modal3 = blockThreeObj.getString("modal3");
        String modal4 = blockThreeObj.getString("modal4");
        String modal5 = blockThreeObj.getString("modal5");
        String modal6 = blockThreeObj.getString("modal6");
        String modal7 = blockThreeObj.getString("modal7");
        
        SixModule sixModule = new SixModule(street, subject1, subject2, subject3, custom, title1, title2, title3, title4, title5, title6, title7, iframe1, iframe2, iframe3, iframe4, iframe5, iframe6, modal, modal1, modal2, modal3, modal4, modal5, modal6, modal7,version, view);
        
//        System.out.println(pollings);
//        System.out.println(sixModule);
//        System.out.println(schdules);

		JsonBean reJson = new JsonBean();
		try {
			stAdminService.addData(pollings, sixModule, schdules);
		}catch (Exception e) {
            reJson.setStatus(IConstants.RESULT_INT_ERROR);
            reJson.setMessage("数据添加失败！");
            reJson.setData(e.getMessage());
            return reJson;
		}
//		String url1 = "http://100.124.10.1:1521/dataide/task/refresh?tid=1191&uid=1001&key=4c03e2ab6e2f9eaa2743280b663c72e3";
//        String url2 = "http://100.124.10.1:1521/dataide/task/refresh?tid=1192&uid=1001&key=4c03e2ab6e2f9eaa2743280b663c72e3";
//        String url3 = "http://100.124.10.1:1521/dataide/task/refresh?tid=1193&uid=1001&key=4c03e2ab6e2f9eaa2743280b663c72e3";
//        HttpClientUtil.sendHttp(HttpRequestMethedEnum.HttpGet,url1, null,null);
//        HttpClientUtil.sendHttp(HttpRequestMethedEnum.HttpGet,url2, null,null);
//        HttpClientUtil.sendHttp(HttpRequestMethedEnum.HttpGet,url3, null,null);
        reJson.setStatus(IConstants.RESULT_INT_SUCCESS);
        reJson.setMessage("数据添加成功！");
        return reJson;
		
	}
	
	@RequestMapping("/query")
	public JsonBean queryData(String street, String version) {
		JsonBean reJson = new JsonBean();
		Map<String, Object> map = stAdminService.queryData(street, version);
        reJson.setStatus(IConstants.RESULT_INT_SUCCESS);
        reJson.setMessage("数据查询成功！");
        reJson.setData(map);
        return reJson;
		
	}
	
	@RequestMapping("/update")
	public JsonBean updateData(List<Integer> pollids, Integer sixId, List<Integer> scids) {
		JsonBean reJson = new JsonBean();
		try {
			stAdminService.updateData(pollids, sixId, scids);
		} catch (Exception e) {
	        reJson.setStatus(IConstants.RESULT_INT_ERROR);
	        reJson.setMessage("数据更新失败！");
	        return reJson;
		}
        reJson.setStatus(IConstants.RESULT_INT_SUCCESS);
        reJson.setMessage("数据查询成功！");
        return reJson;
		
	}
}
