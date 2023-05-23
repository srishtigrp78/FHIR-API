package com.wipro.fhir.r4.service.ndhm;

import com.wipro.fhir.r4.data.healthID.HealthIDResponse;
import com.wipro.fhir.r4.data.healthID.VerifyOTP;
import com.wipro.fhir.r4.utils.exception.FHIRException;

public interface CreateHealthID_Aadhaar_NDHMService {
	
	public String generateOTP(String request) throws FHIRException;
	public String verifyOTP(String request) throws FHIRException;
	public HealthIDResponse createHealthIDWithUID(String request) throws FHIRException;
	public String checkAndGenerateMobileOTP(String request) throws FHIRException;
	String verifyMobileOTP(String request) throws FHIRException;
}
