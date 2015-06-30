package com.visionet.project.platform.customer.repository.impl;

import org.springframework.stereotype.Repository;

import com.visionet.project.base.exception.LogicException;
import com.visionet.project.base.repository.impl.CommonImplRepository;
import com.visionet.project.platform.customer.domain.entity.QuartzLog;
import com.visionet.project.platform.customer.repository.QuartzLogRepository;
@Repository
public class QuartzLogRepositoryImpl extends CommonImplRepository<QuartzLog> implements QuartzLogRepository  {

	public QuartzLogRepositoryImpl() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	



	@Override
	public void saveOrUpdate(QuartzLog quartzLog) throws LogicException {
		// TODO Auto-generated method stub
		if(quartzLog.getId()!=null){
			super.update(quartzLog);
		}else{
			super.save(quartzLog);
		}
	}



}
