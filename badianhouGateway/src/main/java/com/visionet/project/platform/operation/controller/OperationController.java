package com.visionet.project.platform.operation.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.visionet.project.base.util.HttpClientUtils;
import com.visionet.project.base.util.JsonHandler;
import com.visionet.project.base.util.UrlUtil;

@Controller
@RequestMapping("/operation")
public class OperationController {
	/**
	 * 
	 * 8.1获取本周推荐导师
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCommTutor")
	public String getCommTutor(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String count=(String) map.get("count");
			System.out.println(count);
			backInfo = HttpClientUtils.get(UrlUtil.OPEURL+"/v2/api/advisor/"+count, null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 8.2获取热门案例
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getHotCase")
	public String getHotCase(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String count=(String) map.get("count");
			System.out.println(count);
			backInfo = HttpClientUtils.get(UrlUtil.OPEURL+"/v2/api/hot_case/"+count, null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 8.3  获取首页内容
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAdvertisement")
	public String getAdvertisement(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String count=(String) map.get("count");
			System.out.println(count);
			if(count.trim()==null || "".equals(count.trim())){
				count="6";
			}
			backInfo = HttpClientUtils.get(UrlUtil.OPEURL+"/v2/api/ads/"+count, null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 8.4 获取客服联系信息
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getService")
	public String getService(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			backInfo = HttpClientUtils.get(UrlUtil.OPEURL+"/v2/api/contact", null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	
}
