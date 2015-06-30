package com.visionet.project.platform.order.controller;

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
@RequestMapping("/order")
public class OrderController {
	/**
	 * 7.1  创建充值订单
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/createOrder")
	public String createOrder(@RequestBody String param, HttpServletRequest request) {
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
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/member/order/recharge", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 7.2 订单完成确认
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/affirmOrder")
	public String affirmOrder(@RequestBody String param, HttpServletRequest request) {
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
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/member/order/finish", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	
	
}
