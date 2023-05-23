package com.wipro.fhir.r4.config.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.fhir.r4.service.e_aushdhi.EAushadhiServiceImpl;



@Service
@Transactional
public class ScheduleForEAushadhiStockAddition implements Job{
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
    private EAushadhiServiceImpl eAushadhiServiceImpl;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		logger.info("Started job for e-aushadhi stock addition " + arg0.getClass().getName());
		eAushadhiServiceImpl.getStockDetailsFromEAushadhi();
		logger.info("Completed job for e-aushadhi stock addition " + arg0.getClass().getName());
	}
}
