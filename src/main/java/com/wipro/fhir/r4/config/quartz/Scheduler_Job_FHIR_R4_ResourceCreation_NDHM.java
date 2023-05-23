package com.wipro.fhir.r4.config.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.fhir.r4.service.common.CommonService;

/***
 * 
 * @author NE298657
 *
 */

@Service
@Transactional
public class Scheduler_Job_FHIR_R4_ResourceCreation_NDHM implements Job {
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private CommonService commonService;

	// run the schedular for resource operation(creation, process and mongo save)
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("Started job for FHIR resource creation " + arg0.getClass().getName());

		try {
			// process resource creation
			commonService.processResourceOperation();
//			System.out.println("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error("Unexpected error:" , e);
		}
		logger.info("Completed job for FHIR resource creation " + arg0.getClass().getName());
	}

}
