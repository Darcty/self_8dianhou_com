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
public class AppResponseHeader implements Serializable{


	private static final long serialVersionUID = -4957574295377650409L;
	
	private Integer code;
	private String message;
	private String url;
	
	public AppResponseHeader(Integer code,String message,String url){
		this.code = code;
		this.message = message;
		this.url = url;
	}
	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String toString(){
		return code+" "+message+" "+url;
	}
}
