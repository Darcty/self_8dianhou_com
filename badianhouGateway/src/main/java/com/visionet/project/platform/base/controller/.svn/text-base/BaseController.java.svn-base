package com.visionet.project.platform.base.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.visionet.project.base.util.HttpClientUtils;
import com.visionet.project.base.util.JsonHandler;
import com.visionet.project.base.util.UrlUtil;

@Controller
@RequestMapping("/base")
public class BaseController {
	/**
	 * 9.3 获取热门行业
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBusiness")
	public String getBusiness(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			String count=(String) map.get("count");
			if(count.trim()==null || "".equals(count.trim())){
				count="8";
			}
			System.out.println(count);
//			String info = JsonHandler.objectToJson(map);
//			System.out.println(info);
			backInfo = HttpClientUtils.get(UrlUtil.URL+"/api/advisor-search/top-industries?count="+count, null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 9.4 获取行业列表
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBusinessList")
	public String getBusinessList(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
		
			backInfo = HttpClientUtils.get(UrlUtil.URL+"/api/advisor-search/industries", null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 9.5 获取热门话题标签
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTolkTag")
	public String getTolkTag(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			String count=(String) map.get("count");
			System.out.println(count);
			if(count.trim()==null || "".equals(count.trim())){
				count="8";
			}
		
			backInfo = HttpClientUtils.get(UrlUtil.URL+"/api/tags/top-service-tags?count="+count, null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 9.6 获取热门话题主题分类
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getThemeClassify")
	public String getThemeClassify(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			String type=(String) map.get("type");
			if(type.trim()==null || "".equals(type.trim())){
				type="advisee";
			}
			System.out.println(type);
//			String info = JsonHandler.objectToJson(map);
//			System.out.println(info);
			backInfo = HttpClientUtils.get(UrlUtil.URL+"/api/topics/top-service-topics?type="+type, null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 9.7 获取国家列表
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCountryList")
	public String getCountryList(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
		
			backInfo = HttpClientUtils.get(UrlUtil.URL+"/api/location/countries", null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 9.8  获取城市列表
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCityList")
	public String getCityList(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			String countryCode=(String) map.get("countryCode");
			System.out.println(countryCode);
			String provinceCode=(String) map.get("provinceCode");
			System.out.println(provinceCode);
			backInfo = HttpClientUtils.get(UrlUtil.URL+"/api/location/"+countryCode+"/"+provinceCode+"/cities", null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 9.9   获取省会
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getProvinceList")
	public String getProvinceList(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			String countryCode=(String) map.get("countryCode");
			System.out.println(countryCode);
			backInfo = HttpClientUtils.get(UrlUtil.URL+"/api/location/"+countryCode+"/provinces", null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 9.10 是否更新缓存
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkBuffer")
	public String checkBuffer(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		String checkBuffer="";
		boolean flag = false;
		Properties props = new Properties();
		try {
			props.load(BaseController.class.getClassLoader().getResourceAsStream("../../buffer.properties"));
			 checkBuffer = props.getProperty("buffer");
			
			Map<String,Object> map = JsonHandler.json2Map(param);
			String strBuffer=(String) map.get("checkBuffer");
			long appBuffer = Long.parseLong(strBuffer);
			long slefBuffer = Long.parseLong(checkBuffer);
			if( appBuffer<slefBuffer){
				flag=true;
			}
			Map<String,Object> mapSelf = new HashMap<String, Object>();
			mapSelf.put("checkBuffer", checkBuffer);
			mapSelf.put("flag", flag);
			 backInfo = JsonHandler.objectToJson(mapSelf);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 9.11 用户设备信息
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/userDevice")
	public String userDevice(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
//			String favoriteId=(String) map.get("answerId");
//			System.out.println(favoriteId);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/user/device", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 9.12 删除用户设备信息
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteDevice")
	public String deleteDevice(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String number=(String) map.get("number");
			System.out.println(number);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
//			String info = JsonHandler.objectToJson(map);
//			System.out.println(info);
			backInfo = HttpClientUtils.httpDelete(UrlUtil.URL+"/api/user/device/"+number, null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 9.13 获取默认时区列表
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTimepl")
	public String getTimepl(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			
//			String info = JsonHandler.objectToJson(map);
//			System.out.println(info);
			backInfo = HttpClientUtils.get(UrlUtil.URL+"/api/timezone/defaults", null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
}
