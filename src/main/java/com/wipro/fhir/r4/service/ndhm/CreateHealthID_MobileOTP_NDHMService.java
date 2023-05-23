package com.wipro.fhir.r4.service.ndhm;

import com.wipro.fhir.r4.data.healthID.HealthIDResponse;
import com.wipro.fhir.r4.utils.exception.FHIRException;

public interface CreateHealthID_MobileOTP_NDHMService {
	
	public String generateOTP(String request) throws FHIRException;
	
	public String validateOTP(String request) throws FHIRException;
	
	public HealthIDResponse createHealthID(String requestOBJ,String NDHM_OTP_TOKEN) throws FHIRException;

}
