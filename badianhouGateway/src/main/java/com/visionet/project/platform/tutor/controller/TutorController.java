package com.visionet.project.platform.tutor.controller;

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
@RequestMapping("/tutor")
public class TutorController {
	/**
	 * 2.1 获取导师详情
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTutor")
	public String getTutor(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String advisorId=(String) map.get("advisorId");
			System.out.println(advisorId);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
//			String info = JsonHandler.objectToJson(null);
//			System.out.println(info);
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api%20/advisor/"+advisorId, null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	
	/**
	 * 2.2 获取话题评价
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTolkEvaluate")
	public String getTolkEvaluate(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			String advisorId=(String) map.get("advisorId");
			System.out.println(advisorId);
			String sid=(String) map.get("sid");
			System.out.println(sid);
			if(sid.trim()==null || "".equals(sid.trim())){
				sid="1,10";
			}
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/advisor/"+advisorId+"/reviews?sid="+sid, null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 2.3  获取导师的回答列表，该列表用于在导师的简历详细页面显示
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTutorAnswer")
	public String getTutorAnswer(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			String advisorId=(String) map.get("advisorId");
			System.out.println(advisorId);
			String sid=(String) map.get("sid");
			System.out.println(sid);
			if(sid.trim()==null || "".equals(sid.trim())){
				sid="1,10";
			}
//			String info = JsonHandler.objectToJson(map);
//			System.out.println(info);
			backInfo = HttpClientUtils.get(UrlUtil.URL+"/api/question/"+advisorId+"/answers?sid="+sid, null);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 2.4话题推荐
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTolkRecommend")
	public String getTolkRecommend(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
//			String advisorId=(String) map.get("advisorId");
//			System.out.println(advisorId);
//			String info = JsonHandler.objectToJson(map);
//			System.out.println(info);
			backInfo = HttpClientUtils.get(UrlUtil.URL+"/api/advisor/recommend", map);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 2.5 话题搜索
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTolkSearch")
	public String getTolkSearch(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
//			String sid=(String) map.get("sid");
//			System.out.println(sid);
//			String q=(String) map.get("q");
//			System.out.println(q);
//			String industry_code=(String) map.get("industry_code");
//			System.out.println(industry_code);
//			String service_topic_code=(String) map.get("service_topic_code");
//			System.out.println(service_topic_code);
//			String service_tags=(String) map.get("service_tags");
//			System.out.println(service_tags);
//			String info = JsonHandler.objectToJson(map);
//			System.out.println(info);
			backInfo = HttpClientUtils.get(UrlUtil.URL+"/api/advisor/topic-search", map);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 2.6 获取我的话题列表
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMyTolkList")
	public String getMyTolkList(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/advisor/advisor-service/", null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	
	/**
	 * 2.7 添加新的话题 
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/newTolk")
	public String newTolk(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/advisor/advisor-service/", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	
	/**
	 * 2.8 修改一个话题
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changeMyTolk")
	public String changeMyTolk(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPut(UrlUtil.URL+"/api/advisor/advisor-service/", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	
	/**
	 * 2.9 删除一个话题
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteMyTolk")
	public String deleteMyTolk(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String serviceId=(String) map.get("serviceId");
			System.out.println(serviceId);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			backInfo = HttpClientUtils.httpDelete(UrlUtil.URL+"/api/advisor/advisor-service/"+serviceId, null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	
	/**
	 * 2.10 获取话题的主题分类列表
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTopicList")
	public String getTopicList(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/advisor/advisor-service/topics", null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}

	/**
	 * 2.11 成为导师
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBecomeTutor")
	public String getBecomeTutor(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/advisor/to-be-advisor", null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
}
