/**
 * Copyright 2014 the original author or authors. All rights reserved.
 */
package com.visionet.project.domain;

import java.io.Serializable;

/**
 * @author huwk
 * @since 0.0.1
 *
 */
public class AppMessageBody<T> implements Serializable {

	private static final long serialVersionUID = 9193227697604245496L;

	private T payload;
	private Character success;
	private String msg;
	private String isRegistered ;
	
	public AppMessageBody(){
		
	}
	public AppMessageBody(T payload){
		this.payload = payload;
	}

	public AppMessageBody(T payload,Character success){
		this.payload = payload;
	}
	
	public AppMessageBody(Character success){
		this.success = success;
	}
	
	public AppMessageBody(Character success,String msg){
		this.success = success;
		this.msg = msg;
	}
	
	
	/**
	 * @return the isRegistered
	 */
	public String getIsRegistered() {
		return isRegistered;
	}
	/**
	 * @param isRegistered the isRegistered to set
	 */
	public void setIsRegistered(String isRegistered) {
		this.isRegistered = isRegistered;
	}
	/**
	 * @return the payload
	 */
	public T getPayload() {
		return payload;
	}

	/**
	 * @param payload the payload to set
	 */
	public void setPayload(T payload) {
		this.payload = payload;
	}
	/**
	 * @return the success
	 */
	public Character getSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(Character success) {
		this.success = success;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
