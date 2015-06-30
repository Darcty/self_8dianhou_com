package com.visionet.project.platform.subscribe.controller;

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
@RequestMapping("/subscribe")
public class SubscribeController {
	/**
	 * 6.1获取预约列表
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getSubscribeList")
	public String getSubscribeList(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
//			String inprogress=(String) map.get("inprogress");
//			System.out.println(inprogress);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
//			String info = JsonHandler.objectToJson(map);
//			System.out.println(info);
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/member/consultations", map,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}
	/**
	 * 6.3 创建一个预约
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/startSubscribe")
	public String startSubscribe(@RequestBody String param, HttpServletRequest request) {
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
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/member/consultation/v2", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	
	/**
	 * 6.4  查询一个预约详情
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getDetail")
	public String getDetail(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String consultationId=(String) map.get("consultationId");
			System.out.println(consultationId);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
//			String info = JsonHandler.objectToJson(null);
//			System.out.println(info);
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/member/consultation/"+consultationId, null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 6.5 查询预约的时间列表
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getTimeList")
	public String getTimeList(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String consultationId=(String) map.get("consultationId");
			System.out.println(consultationId);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
//			String info = JsonHandler.objectToJson(null);
//			System.out.println(info);
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/member/consultation/"+consultationId+"/booking-times", null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 6.6	获取预约的确认时间
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getSubscribeTime")
	public String getSubscribeTime(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String consultationId=(String) map.get("consultationId");
			System.out.println(consultationId);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
//			String info = JsonHandler.objectToJson(null);
//			System.out.println(info);
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/member/consultation/"+consultationId+"/meeting-time", null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 6.7  确定预约时间
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/affirmTime")
	public String affirmTime(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String consultationId=(String) map.get("consultationId");
			System.out.println(consultationId);
			map.remove("consultationId");
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/member/consultation/"+consultationId+"/schedule/v2", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 6.8  重设预约时间
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/changeTime")
	public String changeTime(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String consultationId=(String) map.get("consultationId");
			System.out.println(consultationId);
			map.remove("consultationId");
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/member/consultation/"+consultationId+"/reschedule/v2", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 6.9  评论一个预约
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/commentSubscribe")
	public String commentSubscribe(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String consultationId=(String) map.get("consultationId");
			System.out.println(consultationId);
			map.remove("consultationId");
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/member/consultation/"+consultationId+"/review", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 6.10 支付预约
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/paySubscribe")
	public String paySubscribe(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String consultationId=(String) map.get("consultationId");
			System.out.println(consultationId);
			map.remove("consultationId");
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/member/consultation/"+consultationId+"/pay", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 * 6.11  获取预约状态
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getState")
	public String getState(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String consultationId=(String) map.get("consultationId");
			System.out.println(consultationId);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
//			String info = JsonHandler.objectToJson(null);
//			System.out.println(info);
			backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/member/consultation/"+consultationId+"/status", null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 *   6.12	获取预约消息列表
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getMessage")
	public String getMessage(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String consultationId=(String) map.get("consultationId");
			System.out.println(consultationId);
			String startts=(String) map.get("startts");
			System.out.println(startts);
			map.remove("consultationId");
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
//			String info = JsonHandler.objectToJson(null);
//			System.out.println(info);
			if(startts.trim()==null || "".equals(startts.trim())){
			   backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/member/consultation/"+consultationId+"/messages/v2", null,token);
			}else{
				backInfo = HttpClientUtils.getToken(UrlUtil.URL+"/api/member/consultation/"+consultationId+"/messages/v2", map,token);
			}
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 *   6.13	发送预约文本消息
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/sendText")
	public String sendText(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String consultationId=(String) map.get("consultationId");
			System.out.println(consultationId);
			
			map.remove("consultationId");
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(map);
			System.out.println(info);
			backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/member/consultation/"+consultationId+"/message/text", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 *   6.15	第三方支付信息
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/thirdPay")
	public String thirdPay(@RequestBody String param, HttpServletRequest request) {
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
			   backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/member/order/recharge/v3", info,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
	/**
	 *   6.16	发起会议
	 * @param param
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/goMeeting")
	public String goMetting(@RequestBody String param, HttpServletRequest request) {
		System.out.println(param);
		String backInfo = "";
		try {
			Map<String,Object> map = JsonHandler.json2Map(param);
			System.out.println(map);
			String consultationId=(String) map.get("consultationId");
			System.out.println(consultationId);
			Map<String,Object> mapHead = JsonHandler.json2MapHead(param);
			System.out.println(mapHead);
			String token=(String) mapHead.get("X-AUTH-TOKEN");
			System.out.println(token);
			String info = JsonHandler.objectToJson(null);
			System.out.println(info);
			   backInfo = HttpClientUtils.httpPostToken(UrlUtil.URL+"/api/member/consultation/restart-meeting/"+consultationId, null,token);
			System.out.println(backInfo);
		}  catch (Exception e) {
			e.printStackTrace();
		} 
		return backInfo;
	}	
}
