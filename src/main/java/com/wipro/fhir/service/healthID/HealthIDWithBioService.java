package com.wipro.fhir.service.healthID;

import com.wipro.fhir.utils.exception.FHIRException;

public interface HealthIDWithBioService {
	

	public String verifyBio(String request) throws FHIRException;
	public String generateMobileOTP(String request) throws FHIRException;
	public String confirmWithAadhaarBio(String request) throws FHIRException;
	
}
