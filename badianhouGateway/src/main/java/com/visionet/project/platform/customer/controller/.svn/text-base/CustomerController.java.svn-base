package com.visionet.project.platform.customer.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.visionet.project.base.util.HttpClientUtils;
import com.visionet.project.base.util.JsonHandler;
import com.visionet.project.base.util.UrlUtil;
import com.visionet.project.domain.AppMessage;
import com.visionet.project.platform.customer.domain.entity.QuartzLog;
import com.visionet.project.platform.customer.service.QuartzLogService;

@Controller
@RequestMapping("/user")
public class CustomerController {
	@Resource
	private QuartzLogService quatzLogService;
	/**
	 * 1.3 发送手机验证码
	 * @param param
	 * @return 返回验证码
	 */
	@ResponseBody
	@RequestMapping("/getVerificationCode")
	public String getVerificationCode(@RequestBody String param, HttpServletRequest request) {
		String backInfo = "";
		System.out.println(param);
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String checkUniquetr=(String) map.get("check-unique");
			map.remove("check-unique");
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPost(UrlUtil.URL+"/api/phone/verify?check-unique="+checkUniquetr, info);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 1.2  注册
	 * @param param
	 * @param request
	 * @return 
	 */
	@ResponseBody
	@RequestMapping("/register")
	public String register(@RequestBody String param,HttpServletRequest request,HttpSession session) {	
		
		String backInfo = "";
		
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			String username=(String)map.get("phoneNumber");
			backInfo = HttpClientUtils.httpPost(UrlUtil.URL+"/api/signup/v2", info);
			System.out.println(backInfo);
			session.setAttribute("username", username);
			QuartzLog qu = new QuartzLog();
			String ip = request.getRemoteHost();
			String now = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss").format(new Date());
			qu.setIp(ip);
			qu.setTime(now);
			qu.setUsername(username);
			qu.setMethodName("register");
			quatzLogService.saveOrUpdate(qu);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	
	/**
	 * 1.1   登入
	 * @param param
	 * @return 
	 */
	@ResponseBody
	@RequestMapping("/login")
	public String login(@RequestBody String param, HttpServletRequest request,HttpSession session) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			String username =(String)map.get("username");
			backInfo = HttpClientUtils.httpPost(UrlUtil.URL+"/api/user/authentication/v2", info);
			System.out.println(backInfo);
			session.setAttribute("username", username);
			QuartzLog qu = new QuartzLog();
			String ip = request.getRemoteHost();
			String now = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss").format(new Date());
			qu.setIp(ip);
			qu.setTime(now);
			qu.setUsername(username);
			qu.setMethodName("Login");
			quatzLogService.saveOrUpdate(qu);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 1.4   验证手机验证码
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/VerifyPassword")
	public String VerifyPassword(@RequestBody String param,HttpServletRequest request) {	
		
		String backInfo = "";
		
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			
			backInfo = HttpClientUtils.httpPost(UrlUtil.URL+"/api/phone/verify-code", info);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	
	/**
	 * 1.5   重设密码验证 
	 * @param param
	 * @param request
	 * @return 
	 */
	@ResponseBody
	@RequestMapping("/changePasswordCode")
	public String changePasswordCode(@RequestBody String param,HttpServletRequest request) {	
		
		String backInfo = "";
		
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			
			backInfo = HttpClientUtils.httpPost(UrlUtil.URL+"/api/auth-reset-password", info);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	
	/**
	 * 1.6  重设密码 
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changePassword")
	public String changePassword(@RequestBody String param,HttpServletRequest request) {	
		
		String backInfo = "";
		
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			
			backInfo = HttpClientUtils.httpPost(UrlUtil.URL+"/api/reset-password-by-phone", info);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}

	/**
	 * 1.8 注销登入 
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/loginOut")
	public String loginOut(@RequestBody String param,HttpServletRequest request,HttpSession session) {	
		
		String backInfo = "";
		
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/signout",null,token);
			System.out.println(backInfo);
			String username=null;
		    username=(String)session.getAttribute("username");
			QuartzLog qu = new QuartzLog();
			String ip = request.getRemoteHost();
			String now = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss").format(new Date());
			qu.setIp(ip);
			qu.setTime(now);
			qu.setUsername(username);
			qu.setMethodName("logout");
			quatzLogService.saveOrUpdate(qu);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}

	
}
