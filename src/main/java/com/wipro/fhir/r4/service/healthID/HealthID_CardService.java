package com.wipro.fhir.r4.service.healthID;

import com.wipro.fhir.r4.utils.exception.FHIRException;

public interface HealthID_CardService {
	public String generateOTP(String request) throws FHIRException;
	
	public String verifyOTPAndGenerateCard(String request) throws FHIRException;
}
