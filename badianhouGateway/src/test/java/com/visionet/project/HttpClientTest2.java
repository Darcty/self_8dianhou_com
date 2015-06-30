/**
 * Copyright 2014 the original author or authors. All rights reserved.
 */
package com.visionet.project;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;



/**
 * @author huwk
 * @since 0.0.1
 *
 */
public class HttpClientTest2 {

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws HttpException, IOException {
//	String str = "{'head':{'aid':'badianhouGateway_app'},'body':{'phone':'15102188314','countryCode':'+86','check-unique':'true'}}";
//	String str = "{'head':{'aid':'badianhouGateway_app','X-AUTH-TOKEN':'vdW50SWQiOiJJQ','time':'0521'},'body':{'username':'252816154@qq.com','password':'123456'}}";
//	String str = "{'head':{'aid':'badianhouGateway_app'},'body':{'username':'13816817161','password':'123456'}}";
//	String str = "{'head':{'cd':'XkTyNHxHzjj0En5DeyNrtg==','mos':'IOS 7.1','ver':'1','de':'2015-06-12 16:26:18','aid':'NetworkFramework','screenx':'640','ln':'zh_CN','sid':'BAE69589-01A2-4DD0-84F7-6B8D53F98E1D','mod':'iPhone','sync':'1','screeny':'1136'},'body':{'username':'alwen.q.lu@careerfrog.com.cn','password':'abc12345'}}";
	String str = "{'head':{'aid':'badianhouGateway_app'},'body':{'username':'alwen.q.lu@careerfrog.com.cn','password':'abc12345'}}";
//	String str = "{'aid':'badianhouGateway_app','Basic':'MjM1YzU5ZGUwMzNlZTljOTBlZjdiZTQzOmQzYmRjYzZkYmRmMDBjODhhYWYyZDMzNQ=='},'platform':'all','audience':'all','notification':{'alert':'Hi,JPush'}}";
//	String str = "{'head':{'aid':'badianhouGateway_app'},'body':{'MessageType':'SYSTEM','message':''}}";
//	String str = "{'head':{'aid':'badianhouGateway_app'},'body':{'countryCode':'cn','provinceCode':'42'}}";
//	String str = "{'head':{'aid':'badianhouGateway_app','Basic':'MjM1YzU5ZGUwMzNlZTljOTBlZjdiZTQzOmQzYmRjYzZkYmRmMDBjODhhYWYyZDMzNQ=='},'body':{'platform': 'all','audience' : {'tag' : {'深圳', '北京'}}}";
//	            String str = "{'head':{'aid':'badianhouGateway_app','X-AUTH-TOKEN':' eyJhY2NvdW50SWQiOiJJQU0tQS0wNy0xOS0yMDE0LTk1NzZDQkVBIiwidXNlck5hbWUiOiJhbHdlbi5xLmx1QGNhcmVlcmZyb2cuY29tLmNuIiwiYXZhdGFyVXJsIjoiaHR0cDovLzhkaWFuaG91LmNhcmVlcmZyb2cuY29tLmNuL2FwaS9hdmF0YXIvYXZhdGFyLTBkZmFhYWQ2LTFiNzUtNGU1Mi04OGRhLTQ2NTU4NDMwY2VlYS5wbmciLCJmdWxsbmFtZSI6Impva2UxICIsImV4cGlyZXMiOjE0MzU0NzIyMDczMTcsInJvbGVzIjpbIkFEVklTT1IiLCJBRFZJU0VFIl19.rVUytRZSbtWT9KZP40YhDn3Yjt5OYMLGMgNoGKJAQ6U='},"
//			             + "'body':{'countryCode':'+86','phoneNumber':'18550295581','code':'0416'}}";
//	String str = "{'head':{'aid':'badianhouGateway_app','X-A':'eyJhY2NvdW50SWQiOiJJQU0tQS0wNy0xOS0yMDE0LTk1NzZDQkVBIiwidXNlck5hbWUiOiJhbHdlbi5xLmx1QGNhcmVlcmZyb2cuY29tLmNuIiwiYXZhdGFyVXJsIjoiaHR0cDovL3d3dy44ZGlhbmhvdS5jb20vYXBpL2F2YXRhci9hdmF0YXItMzhkNWY2NDEtOTE5OC00ZGY3LWE3YmEtYzc1MzA5MDE4NTE5LnBuZyIsImZ1bGxuYW1lIjoiR29HTyAiLCJleHBpcmVzIjoxNDMzNTY5NTE4NTk4LCJyb2xlcyI6WyJBRFZJU09SIiwiQURWSVNFRSJdfQ==.yqG+YJT+5XVrHk21Er7CJTmUf4yN3ocbjXRUNj8csHo='},"
//			+ "'body':{}}";
//	String str = "{'head':{'aid':'badianhouGateway_app','X-AUTH-TOKEN':'eyJhY2NvdW50SWQiOiJJQU0tQS0wNy0xOS0yMDE0LTk1NzZDQkVBIiwidXNlck5hbWUiOiJhbHdlbi5xLmx1QGNhcmVlcmZyb2cuY29tLmNuIiwiYXZhdGFyVXJsIjoiaHR0cDovLzhkaWFuaG91LmNhcmVlcmZyb2cuY29tLmNuL2FwaS9hdmF0YXIvYXZhdGFyLWI2OGY0NmU0LTJjZDctNDAzMS04ZmJlLTJmOTE4MjdjYTNkMS5wbmciLCJmdWxsbmFtZSI6IkFsd2VuIEx1IiwiZXhwaXJlcyI6MTQzNDg1NzkyMjc2MSwicm9sZXMiOlsiQURWSVNPUiIsIkFEVklTRUUiXX0=.nFmlMkR8+ePU80NGlfNJI+fPTIBWLGprpdi0OvyyvQ8='},"
//			+ "'body':{'answerId':'A-2015-04-27-60328EE3-58C'}}";
//	String str = "{'head':{'aid':'badianhouGateway_app','X-AUTH-TOKEN':'eyJhY2NvdW50SWQiOiJJQU0tQS0wNy0xOS0yMDE0LTk1NzZDQkVBIiwidXNlck5hbWUiOiJhbHdlbi5xLmx1QGNhcmVlcmZyb2cuY29tLmNuIiwiYXZhdGFyVXJsIjoiaHR0cDovL3d3dy44ZGlhbmhvdS5jb20vYXBpL2F2YXRhci9hdmF0YXItMzhkNWY2NDEtOTE5OC00ZGY3LWE3YmEtYzc1MzA5MDE4NTE5LnBuZyIsImZ1bGxuYW1lIjoiR29HTyAiLCJleHBpcmVzIjoxNDMzNzM0NzcxNTY3LCJyb2xlcyI6WyJBRFZJU09SIiwiQURWSVNFRSJdfQ==.HqBTH5EbIc7nPfcoyDy4FY8rl43fCC8RqnS3scJdafI='},"
//			+ "'body':{'memberId':'IAM-A-07-19-2014-9576CBEA','tutoringServiceId':'F5BE8801','name':'当你在和我聊8点后的时候，我们在聊什么','topicCode':'500','topicName':'创业咨询','description':'8点后终于上线了，作为我创业后的第一款产品，凝聚了团队大量的心血，也必然存在着很多不足，可以与你分享下8点后背后的产品设计故事，也希望听听你的宝贵建议。','price':5.0,'priceDisplay':'0.00','durationMinutes':30,'defaultDescription':true,'freePrice':true,'createTime':null,'tags':null,'target':null,'profession':null}}";
//	String str = "{'head':{'aid':'badianhouGateway_app','X-AUTH-TOKEN':' eyJhY2NvdW50SWQiOiJJQU0tQS0wNy0xOS0yMDE0LTk1NzZDQkVBIiwidXNlck5hbWUiOiJhbHdlbi5xLmx1QGNhcmVlcmZyb2cuY29tLmNuIiwiYXZhdGFyVXJsIjoiaHR0cDovL3d3dy44ZGlhbmhvdS5jb20vYXBpL2F2YXRhci9hdmF0YXItMzhkNWY2NDEtOTE5OC00ZGY3LWE3YmEtYzc1MzA5MDE4NTE5LnBuZyIsImZ1bGxuYW1lIjoiQUx3ZW4gTHUiLCJleHBpcmVzIjoxNDMzMTIzOTc1MTY3LCJyb2xlcyI6WyJBRFZJU09SIiwiQURWSVNFRSJdfQ==.fqC1NTDbsPkVr4KbdUqXwVTHKsWGbI2Qz9Pv5enEWTM='},'body':{'advisorId':'IAM-A-07-19-2014-9576CBEA'}}";
//	String str = "{'head':{'aid':'badianhouGateway_app','X-AUTH-TOKEN':' eyJhY2NvdW50SWQiOiJJQU0tQS0wNy0xOS0yMDE0LTk1NzZDQkVBIiwidXNlck5hbWUiOiJhbHdlbi5xLmx1QGNhcmVlcmZyb2cuY29tLmNuIiwiYXZhdGFyVXJsIjoiaHR0cDovL3d3dy44ZGlhbmhvdS5jb20vYXBpL2F2YXRhci9hdmF0YXItMzhkNWY2NDEtOTE5OC00ZGY3LWE3YmEtYzc1MzA5MDE4NTE5LnBuZyIsImZ1bGxuYW1lIjoiQUx3ZW4gTHUiLCJleHBpcmVzIjoxNDMzMTIzOTc1MTY3LCJyb2xlcyI6WyJBRFZJU09SIiwiQURWSVNFRSJdfQ==.fqC1NTDbsPkVr4KbdUqXwVTHKsWGbI2Qz9Pv5enEWTM='},'body':{'fullname':'GoGO'}}";
//	String str = "{'head':{'aid':'badianhouGateway_app','X-AUTH-TOKEN':' eyJhY2NvdW50SWQiOiJJQU0tQS0wNy0xOS0yMDE0LTk1NzZDQkVBIiwidXNlck5hbWUiOiJhbHdlbi5xLmx1QGNhcmVlcmZyb2cuY29tLmNuIiwiYXZhdGFyVXJsIjoiaHR0cDovL3d3dy44ZGlhbmhvdS5jb20vYXBpL2F2YXRhci9hdmF0YXItMzhkNWY2NDEtOTE5OC00ZGY3LWE3YmEtYzc1MzA5MDE4NTE5LnBuZyIsImZ1bGxuYW1lIjoiR29HTyAiLCJleHBpcmVzIjoxNDMzMzk3NDIwNDQ4LCJyb2xlcyI6WyJBRFZJU09SIiwiQURWSVNFRSJdfQ==.qDzCfqdRwcuCwTRSE7BdcN/eRtM2Dwx3J0r/ELawsP0='},'body':{'functionCode':'45','summary':'6546','headline':'dfdfdfdf','industryCode':'96','provinceCode':'21','avatarUrl':'http://8dianhou.careerfrog.com.cn/api/avatar/avatar-f43d082b-5aaa-47d3-803c-835fbea177d1.png','cityCode':'','countryCode':'cn','fullname':'dfdf'}}";
//	String str = "{'head':{'aid':'badianhouGateway_app','X-AUTH-TOKEN':'eyJhY2NvdW50SWQiOiJJQU0tQS0wNy0xOS0yMDE0LTk1NzZDQkVBIiwidXNlck5hbWUiOiJhbHdlbi5xLmx1QGNhcmVlcmZyb2cuY29tLmNuIiwiYXZhdGFyVXJsIjoiaHR0cDovL3d3dy44ZGlhbmhvdS5jb20vYXBpL2F2YXRhci9hdmF0YXItMzhkNWY2NDEtOTE5OC00ZGY3LWE3YmEtYzc1MzA5MDE4NTE5LnBuZyIsImZ1bGxuYW1lIjoiR29HTyAiLCJleHBpcmVzIjoxNDMzNzQyMTU1MDM0LCJyb2xlcyI6WyJBRFZJU09SIiwiQURWSVNFRSJdfQ==.2pVAS4uju3KBIVNBj8Kk+pS9DSJrepa2vtNHoYi10JA='},'body':{'memberId':'IAM-A-07-19-2014-9576CBEA','avatarUrl':'http://8dianhou.careerfrog.com.cn/api/avatar/avatar-4dda6282-9b7a-4ec3-bd38-0e65fcedb4c8.png','fullname':'123','headline':'www','countryCode':'cn','industryCode':'96'}}";
//	String str = "{'head':{'aid':'badianhouGateway_app','X-AUTH-TOKEN':' M='},'body':{'advisorId':'IAM-A-07-19-2014-9576CBEA'}}";

	  JSONObject jsonObject = JSONObject.fromObject(str);
	  String info = jsonObject.toString();
	  HttpClient client = new HttpClient();
//	   PostMethod method = new PostMethod("http://localhost:8080/badianhouGateway/web/user/login");
//	   PostMethod method = new PostMethod("http://app.careerfrog.com.cn/badianhouGateway/web/pushMsg/sendPush");
	   PostMethod method = new PostMethod("http://localhost:8080/badianhouGateway/web/sendMsg/getMsg");
//	   PostMethod method = new PostMethod("https://api.jpush.cn/v3/push");
//	   PostMethod method = new PostMethod("https://api.jpush.cn/v3/push/validate");
//	   PostMethod method = new PostMethod("http://app.careerfrog.com.cn/badianhouGateway/web/base/getTimepl");
//	   PostMethod method = new PostMethod("http://localhost:8080/badianhouGateway/web/answer/putComment");
//	   PostMethod method = new PostMethod("https://api.jpush.cn/v3/push");
//	   PostMethod method = new PostMethod("http://localhost:8080/badianhouGateway/web/answer/enshrineAnswer");
//	   PostMethod method = new PostMethod("http://app.careerfrog.com.cn/badianhouGateway/web/user/getVerificationCode");
//	   PostMethod method = new PostMethod("http://localhost:8080/badianhouGateway/web/useraccount/changPhone");
	   method.setRequestBody(info);
	   client.executeMethod(method);
//	   System.out.println(method.getResponseBodyAsString());
//	   System.out.println(method.getResponseHeader("X-AUTH-TOKEN"));
	}
}
