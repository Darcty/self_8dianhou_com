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
public class AppMessageHeader implements Serializable{

	private static final long serialVersionUID = 7283244987912681054L;
    
	private Character success;
	private String msg;
	
	
	public AppMessageHeader(){
	}
	
	public AppMessageHeader(Character success){
		this.success = success;
	}
	
	public AppMessageHeader(Character success,String msg){
		this.success = success;
		this.msg = msg;
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
