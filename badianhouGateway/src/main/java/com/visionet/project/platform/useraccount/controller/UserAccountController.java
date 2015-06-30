package com.visionet.project.platform.useraccount.controller;

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
@RequestMapping("/useraccount")
public class UserAccountController {
	/**
	 * 3.1 获取账号信息
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getUserAccount")
	public String getUserAccount(@RequestBody String param, HttpServletRequest request) {
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
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/member/account", null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	
	/**
	 * 3.2 修改用户的手机号码
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changPhone")
	public String changPhone(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/member/account/changePhoneNumber", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 3.3 修改账号密码
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/modifyPassword")
	public String modifyPassword(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);	
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/member/account/changepassword", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 *3.4  更改账号名称
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changeUserName")
	public String changeUserName(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/member/account/changefullname", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 3.5 修改用户的时区
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changeUserTime")
	public String changeUserTime(@RequestBody String param, HttpServletRequest request) {
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
			backInfo = HttpClientUtils.httpPut(UrlUtil.URL+"/api/member/account/changetimezone", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 3.6 获取用户账户余额
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getBalances")
	public String getBalances(@RequestBody String param, HttpServletRequest request) {
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
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/member/balance", null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	
	/**
	 * 3.7 获取交易流水线
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTradeList")
	public String getTradeList(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String sid=(String) map.get("sid");
			if(sid.trim()==null || "".equals(sid.trim())){
				sid="1,10";
			}
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
//			String info = JsonHandler.objectToJson(map);
//			System.out.println(info);
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/member/transactions?sid="+sid, null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
}
