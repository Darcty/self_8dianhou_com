package com.visionet.project.platform.pushmsg.controller;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.visionet.project.base.util.JsonHandler;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import cn.jpush.api.push.model.notification.PlatformNotification;
@Controller
@RequestMapping("/pushMsg")
public class PushMsg {
    protected static final Logger LOG = LoggerFactory.getLogger(PushMsg.class);

//	private static final String appKey ="235c59de033ee9c90ef7be43";
//	private static final String masterSecret = "d3bdcc6dbdf00c88aaf2d335";
    private static final String appKey ="5dc1fed5005458443160deea";
	private static final String masterSecret = "5d61aa15caabdc7ae86d1b18";
    
    private static JPushClient jpush = null;
    private static PushPayload payload=null;
    
    
    
	public static void main(String[] args) {
		Integer time =86400;
		String str = "091693beed3#09131c7eede";
		String number = "091693beed3";
		String[] numbers= number.split("#");
		Collection<String> ids=   new ArrayList<String>();
		for(int i = 0;i<numbers.length;i++){
			ids.add(numbers[i]);
		}
		System.out.println(ids);
	    jpush = new JPushClient(masterSecret, appKey);
	    PushPayload payload = buildPushObject_ids_apns_alert(ids,"test1",time);
//	    PushPayload payload = buildPushObject_all_apns_alert("test2",time);
        try {
            PushResult result = jpush.sendPush(payload);
            System.out.println(result.toString());
            LOG.info("Got result - " + result);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
        }
		
	}
	
	
	@ResponseBody
	@RequestMapping("/sendPush")
	public  String testSendPush(@RequestBody String param, HttpServletRequest request) {
    System.out.println(param);
    Map<String,Object> map = JsonHandler.json2Map(param);
    Collection<String> ids=   new ArrayList<String>();
    String messageType="";
    String number="";
    String title="";
    String bussinessId="";
    String content="";
    String message="";
    String timeToLive="";
    Integer time = null;
	 messageType=(String) map.get("MessageType");
	 number=(String) map.get("number");
     title=(String) map.get("title");
	 bussinessId=(String) map.get("bussinessId");
	 content=(String) map.get("content");
	 message=(String) map.get("message");
	 timeToLive=(String) map.get("timeToLive");
	 if(timeToLive.trim() !=null && !"".equals(timeToLive.trim())){
	  time = Integer.parseInt(timeToLive);
	 }else{
		 time=86400;
	 }
	if(number.trim()!=null && !"".equals(number.trim())){
		String[] numbers= number.split("#");
		for(int i = 0;i<numbers.length;i++){
			ids.add(numbers[i]);
		}
	}
	
	System.out.println("map:"+map);
	System.out.println("content"+content);
	System.out.println("bussinessId"+bussinessId);
	System.out.println("title"+title);
	System.out.println("number"+number);
	System.out.println("messageType"+messageType);
	System.out.println("message"+message);
	System.out.println("ids"+ids);
	System.out.println("timeToLive"+timeToLive);
	if(messageType.trim().equals("SYSTEM")){
		jpush = new JPushClient(masterSecret, appKey,3);
		if(ids != null && !"".equals(ids)){
			 payload = buildPushObject_ids_apns_alert(ids,message,time);
		}else{
             payload = buildPushObject_all_apns_alert(message,time);
		}
        try {
        	
            PushResult result = jpush.sendPush(payload);
            System.out.println(result.toString());
            LOG.info("Got result - " + result);
            return result.toString();
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
        }
	}else{
		jpush=new JPushClient(masterSecret, appKey,3);
		if(ids !=null && !"".equals(ids)){
			payload=sendAppMsg(ids,title,message,bussinessId, messageType,time);
    	}else{
    		payload=sendAppMsgAll(title,message,bussinessId, messageType,time);
    	}
		     
		 try {
	            PushResult result = jpush.sendPush(payload);
	            System.out.println(result.toString());
	            LOG.info("Got result - " + result);
	            return result.toString();
	            
	        } catch (APIConnectionException e) {
	            LOG.error("Connection error. Should retry later. ", e);
	            
	        } catch (APIRequestException e) {
	            LOG.error("Error response from JPush server. Should review and fix it. ", e);
	            LOG.info("HTTP Status: " + e.getStatus());
	            LOG.info("Error Code: " + e.getErrorCode());
	            LOG.info("Error Message: " + e.getErrorMessage());
	            LOG.info("Msg ID: " + e.getMsgId());
	        }
	}
	return "{'status':'ERROR'}";
	}
	


	
	public static PushPayload sendAppMsg(Collection<String> number,String title,String message,String bussinessId,String messageType,Integer time) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                 .setOptions(Options.newBuilder().setApnsProduction(true)
                		 .setTimeToLive(time)
                		 .build())
                .setAudience(Audience
                		    .newBuilder()
                        .addAudienceTarget(AudienceTarget.registrationId(number))
                        .build()
                		)
                .setMessage(Message.newBuilder()
                		.setContentType(messageType)
                		.setTitle(title)
                        .setMsgContent(message)
                        .addExtra("bussinessId", bussinessId)
                        .build())
                .build();
    }
	public static PushPayload sendAppMsgAll(String title,String message,String bussinessId,String messageType,Integer time) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                 .setOptions(Options.newBuilder().setApnsProduction(true)
                		 .setTimeToLive(time)
                		 .build())
                .setAudience(Audience
                		   .all()
                		)
                .setMessage(Message.newBuilder()
                		.setContentType(messageType)
                		.setTitle(title)
                        .setMsgContent(message)
                        .addExtra("bussinessId", bussinessId)
                        .build())
                .build();
    }
	
	 public static PushPayload buildPushObject_ids_apns_alert(Collection<String> number,String message,Integer time) {
	        return PushPayload.newBuilder()
	                .setPlatform(Platform.all())
	                .setOptions(Options.newBuilder()
	                		.setTimeToLive(time)
	                		.setApnsProduction(true).build())
	                .setAudience(Audience
	                		.newBuilder()
	                		.addAudienceTarget(AudienceTarget.registrationId(number))
	                		.build()
	                		)
	                .setNotification(Notification.alert(message))
	                .build();
	    }
	 public static PushPayload buildPushObject_all_apns_alert(String message,Integer time) {
	        return PushPayload.newBuilder()
	                .setPlatform(Platform.all())
	                .setOptions(Options.newBuilder()
	                		.setTimeToLive(time)
	                		.setApnsProduction(true).build())
	                .setAudience(Audience
	                		.all()
	                		)
	                .setNotification(Notification.alert(message))
	                .build();
	    }
    
	 
    
    
}

