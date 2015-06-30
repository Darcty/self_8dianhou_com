package com.visionet.project.platform.pushmsg.controller;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.visionet.project.platform.customer.domain.entity.QuartzLog;
import com.visionet.project.platform.customer.service.QuartzLogService;


public class sendMessage {
	
//	private static final String appKey ="5dc1fed5005458443160deea";
//	private static final String masterSecret = "5d61aa15caabdc7ae86d1b18";
	@Resource
	private QuartzLogService quatzLogService;
	

	public  void getMsg(@RequestBody String param, HttpServletRequest request) {
		String username=null;
		QuartzLog qu = new QuartzLog();
		
		String ip = request.getRemoteHost();
		
		String now = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss").format(new Date());
		System.out.println(now+"====="+ip);
		qu.setIp(ip);
		qu.setTime(now);
		qu.setUsername(username);
		qu.setMethodName("登入");
		quatzLogService.saveOrUpdate(qu);
	}
	
	public static void main(String[] args) {
//		String str =appKey+":"+masterSecret;
//		String base64_auth_string=new sun.misc.BASE64Encoder().encode( str.getBytes() );
//		System.out.println(base64_auth_string);
	}
}
