/**
 * Copyright 2014 the original author or authors. All rights reserved.
 */
package com.visionet.project.base.dto;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 公用定时job
 * @author Gao
 * @since 0.0.1
 *
 */
public abstract class AbstractSchedule {
	protected transient final Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * before Job invoke
	 */
	protected void beforeSchedule(){
		
	}
	/**
	 * after Job invoke
	 */
	protected void afterSchedule(){
		
	}
	/**
	 * the Job invoke method
	 */
	protected abstract void scheduleMethod();
	public void doJob(){
		try {
			beforeSchedule();
			scheduleMethod();
			afterSchedule();
		} catch (Exception e) {
			log.error("this is a exception in the schedule job in the time of ["+new Date()+"],your job might be not terminated regularly");
		}
		
	}
}
