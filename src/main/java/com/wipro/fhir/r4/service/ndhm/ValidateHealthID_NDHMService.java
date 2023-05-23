package com.wipro.fhir.r4.service.ndhm;

import com.wipro.fhir.r4.utils.exception.FHIRException;

public interface ValidateHealthID_NDHMService {
	
	public String generateOTPForHealthIDValidation(String request) throws FHIRException;
	
	public String validateOTPForHealthIDValidation(String request) throws FHIRException;
}
