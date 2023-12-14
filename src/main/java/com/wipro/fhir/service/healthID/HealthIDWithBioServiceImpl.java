package com.wipro.fhir.service.healthID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.wipro.fhir.repo.healthID.HealthIDRepo;
import com.wipro.fhir.service.ndhm.CreateHealthID_Aadhaar_NDHMService;
import com.wipro.fhir.utils.exception.FHIRException;
@Service
@PropertySource("classpath:application.properties")
public class HealthIDWithBioServiceImpl implements HealthIDWithBioService{
	
	@Autowired
	private HealthIDRepo healthIDRepo;

	@Autowired
	private CreateHealthID_Aadhaar_NDHMService createHealthID_Aadhaar_NDHMService;
	
	@Override
	public String verifyBio(String request) throws FHIRException {
		String response = null;
		try {
			if (request != null ) {
			  response = createHealthID_Aadhaar_NDHMService.verifyBio(request);
		} else
			throw new FHIRException("NDHM_FHIR Error while Verifying Bio");
	} catch (Exception e) {
			throw new FHIRException(e.getMessage());
		}
		return response;
	}
	
	@Override
	public String generateMobileOTP(String request) throws FHIRException {
		String response = null;
		try {
			if (request != null) {
				response = createHealthID_Aadhaar_NDHMService.generateMobileOTP(request);
			} else
				throw new FHIRException("NDHM_FHIR Error Entered OTP is incorrect");
		} catch (Exception e) {
			throw new FHIRException(e.getMessage());
		}
		return response;
	}
	 

	@Override
	public String confirmWithAadhaarBio(String request) throws FHIRException {
		String response = null;
		try {
			if (request != null ) {
			  response = createHealthID_Aadhaar_NDHMService.confirmWithAadhaarBio(request);
		} else
			throw new FHIRException("NDHM_FHIR Error while Verifying Bio");
	} catch (Exception e) {
			throw new FHIRException(e.getMessage());
		}
		return response;
	}
}
