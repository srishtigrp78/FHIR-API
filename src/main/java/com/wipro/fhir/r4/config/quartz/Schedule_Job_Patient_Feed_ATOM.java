package com.wipro.fhir.r4.config.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.fhir.r4.service.atoms.feed.bahmni.PatientFeedWorker;

@Service
@Transactional
public class Schedule_Job_Patient_Feed_ATOM implements Job{
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private PatientFeedWorker patientFeedWorkerService;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("Started job for parsing Patient feed " + arg0.getClass().getName());

		try {
			// process resource creation
			patientFeedWorkerService.patientFeedManager();
//			System.out.println("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error("Unexpected error:" , e);
		}
		logger.info("Completed job for parsing Patient feed " + arg0.getClass().getName());
	}

}
