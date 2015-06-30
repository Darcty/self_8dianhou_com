package com.visionet.project.platform.customer.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.visionet.project.platform.customer.domain.entity.QuartzLog;
import com.visionet.project.platform.customer.repository.QuartzLogRepository;
import com.visionet.project.platform.customer.service.QuartzLogService;

@Transactional
@Service
public class QuartzLogServiceImpl implements QuartzLogService{
	
	@Resource
	private QuartzLogRepository iQRepository;

	public void saveOrUpdate(QuartzLog quartzLog) {
		
		iQRepository.saveOrUpdate(quartzLog);
	}



}
