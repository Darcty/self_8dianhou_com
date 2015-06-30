/**
 * Copyright 2014 the original author or authors. All rights reserved.
 */
package com.visionet.project.domain;

import java.io.Serializable;

/**
 * @author huwk
 * @since 0.0.1
 */
public class AppMessage<T> implements Serializable{

	private static final long serialVersionUID = 3356388292870223319L;

	private AppResponseHeader head;
	private AppMessageBody<T> body;
	
	public AppMessage(){
		
	}
	
	public AppMessage(Character success){
		this.body = new AppMessageBody<T>(success);
	}
	public AppMessage(Character success,String msg){
		this.body = new AppMessageBody<T>(success,msg);
	}
    public AppMessage(Character success,T payload){
    	this.body = new AppMessageBody<T>(payload,success);
    }
    public AppMessage(T payload){
    	this.body = new AppMessageBody<T>(payload,'Y');
    }
    
    public T getPayload(){
    	if(body != null){
    		return body.getPayload();
    	}
    	return null;
    }
    
    public void setPayLoad(T payload){
    	if(body != null){
    		body.setPayload(payload);
    	}else{
    		body = new AppMessageBody<T>(payload);
    	}
    }
    
    public Character getSuccess(){
    	if(body != null){
    		return body.getSuccess();
    	}
    	return null;
    }
    
    public void setSuccess(Character success){
    	if(body != null){
    		body.setSuccess(success);
    	}else{
    		body = new AppMessageBody<T>(success);
    	}
    }
    
    public String getMsg(){
    	if(body != null ){
    		return body.getMsg();
    	}
    	return null;
    }
    
    public void setMsg(String msg){
    	if(body != null){
    		body.setMsg(msg);
    	}else{
    		body = new AppMessageBody<T>();
    		body.setMsg(msg);
    	}
    }
    
    public String getIsRegistered(){
    	if(body != null ){
    		return body.getIsRegistered();
    	}
    	return null;
    }
    
    public void setIsRegistered(String isRegistered){
    	if(body != null){
    		body.setIsRegistered(isRegistered);
    	}else{
    		body = new AppMessageBody<T>();
    		body.setIsRegistered(isRegistered);
    	}
    }
    
    public AppResponseHeader getHead(){
    	if(head != null){
    		return head;
    	}
    	return null;
    }
    public void setHead(int code,String message,String url){
    	if(head != null){
    		head.setCode(code);
    		head.setMessage(message);
    		head.setUrl(url);
    	}else{
    		this.head = new AppResponseHeader(code, message, url);
    	}
    }
}
