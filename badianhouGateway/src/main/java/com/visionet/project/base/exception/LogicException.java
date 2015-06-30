/**
 * Copyright 2014 the original author or authors. All rights reserved.
 */
package com.visionet.project.base.exception;

import com.visionet.platform.framework.exception.BaseRuntimeException;

/**
 * @author Sin
 * @since 0.0.1
 * 
 */
public class LogicException extends BaseRuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8378484197472305808L;

	/**
	 * 
	 */
	public LogicException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public LogicException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public LogicException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public LogicException(Throwable cause) {
		super(cause);
	}

}
