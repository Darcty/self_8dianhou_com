package com.visionet.project.platform.customer.repository;

import com.visionet.project.base.exception.LogicException;
import com.visionet.project.platform.customer.domain.entity.QuartzLog;



public interface QuartzLogRepository {
	
	public void saveOrUpdate(QuartzLog quartzLog) throws LogicException;
}
