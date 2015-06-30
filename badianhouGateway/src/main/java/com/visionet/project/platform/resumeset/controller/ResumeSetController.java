package com.visionet.project.platform.resumeset.controller;

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
@RequestMapping("/resume")
public class ResumeSetController {
	/**
	 * 4.1 获取用户简历信息
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getResume")
	public String getResume(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
//			String info = JsonHandler.objectToJson(null);
//			System.out.println(info);
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/member/profile-setting/basic", null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	
	/**
	 * 4.2 修改用户简历基本信息
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changeResume")
	public String changeResume(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String memberId=(String) map.get("memberId");
			System.out.println(memberId);
			map.remove("memberId");
			System.out.println(map);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPut(UrlUtil.URL+"/api/member/profile-setting/"+memberId+"/basic", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 4.3  创建用户的简历基本信息
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/createResume")
	public String createResume(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			String memberId=(String) map.get("memberId");
			System.out.println(memberId);
			map.remove("memberId");
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/member/profile-setting/"+memberId, info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 *4.4   获取用户的工作列表
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getWorkList")
	public String getWorkList(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
//			String info = JsonHandler.objectToJson(map);
//			System.out.println(info);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/member/profile-setting/positions", map,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 4.5  增加用户的工作记录
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addWork")
	public String addWork(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String memberId=(String) map.get("memberId");
			System.out.println(memberId);
			map.remove("memberId");
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/member/profile-setting/"+memberId+"/position", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 4.6 修改账号的工作记录
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/modifyWork")
	public String modifyWork(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String positionId=(String) map.get("positionId");
			System.out.println(positionId);
			map.remove("positionId");
			String memberId=(String) map.get("memberId");
			System.out.println(memberId);
			map.remove("memberId");
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPut(UrlUtil.URL+"/api/member/profile-setting/"+memberId+"/position/"+positionId, info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 4.7 删除用户的工作记录
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteWork")
	public String deleteWork(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String positionId=(String) map.get("positionId");
			System.out.println(positionId);
			map.remove("positionId");
			String memberId=(String) map.get("memberId");
			System.out.println(memberId);
			map.remove("memberId");
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
//			System.out.println(info);
			backInfo = HttpClientUtils.httpDelete(UrlUtil.URL+"/api/member/profile-setting/"+memberId+"/position/"+positionId, null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 4.8 获取用户的学历
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getEducation")
	public String getEducation(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
//			String info = JsonHandler.objectToJson(map);
//			System.out.println(info);
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/member/profile-setting/educations", null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 4.9  增加用户的学历
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addEducation")
	public String addEducation(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String memberId=(String) map.get("memberId");
			System.out.println(memberId);
			map.remove("memberId");
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/member/profile-setting/"+memberId+"/education", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 4.10  删除用户的学历
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteEducation")
	public String deleteEducation(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String educationId=(String) map.get("educationId");
			System.out.println(educationId);
			String memberId=(String) map.get("memberId");
			System.out.println(memberId);
			map.remove("memberId");
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
//			String info = JsonHandler.objectToJson(map);
//			System.out.println(info);
			backInfo = HttpClientUtils.httpDelete(UrlUtil.URL+"/api/member/profile-setting/"+memberId+"/education/"+educationId, null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 4.11  修改用户的学历
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/modifyEducation")
	public String modifyEducation(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String educationId=(String) map.get("educationId");
			System.out.println(educationId);
			map.remove("educationId");
			String memberId=(String) map.get("memberId");
			System.out.println(memberId);
			map.remove("memberId");
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPut(UrlUtil.URL+"/api/member/profile-setting/"+memberId+"/education/"+educationId, info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 4.12 增加用户的故事
	 * @param param
	 * @param request
	 * @return
	 */
//	@ResponseBody
//	@RequestMapping("/addStory")
//	public String addStory(@RequestBody String param, HttpServletRequest request) {
//		System.out.println(param);
//		String backInfo = "";
//		try {
//			Map<String,Object> map = JsonHandler.json2Map(param);
//			System.out.println(map);
//			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
//			System.out.println(mapHead);
//			String token=(String) mapHead.get("X-AUTH-TOKEN");
//			System.out.println(token);
//			String info = JsonHandler.objectToJson(map);
//			System.out.println(info);
//			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/member/profile-setting/story", info,token);
//			System.out.println(backInfo);
//		}  catch (Exception e) {
//			e.printStackTrace();
//		} 
//		return backInfo;
//	}
	/**
	 * 4.12  修改故事
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/modifyStory")
	public String modifyStory(@RequestBody String param, HttpServletRequest request) {
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
			backInfo = HttpClientUtils.httpPut(UrlUtil.URL+"/api/member/profile-setting/story", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 4.13 上传用户的生活照
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addLivePhoto")
	public String addLivePhoto(@RequestBody String param, HttpServletRequest request) {
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
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/member/profile-setting/daily-photo", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 4.14  获得用户的生活照
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getLifePhoto")
	public String getLifePhoto(@RequestBody String param, HttpServletRequest request) {
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
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/profile-setting/daily-photo", null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 4.15  取消生活照设置
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deletePhoto")
	public String deletePhoto(@RequestBody String param, HttpServletRequest request) {
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
			backInfo = HttpClientUtils.httpDelete(UrlUtil.URL+"/api/member/profile-setting/daily-photo", null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
}
