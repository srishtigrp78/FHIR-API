package com.wipro.fhir.r4.service.ndhm;

import com.wipro.fhir.r4.utils.exception.FHIRException;

public interface LinkCareContext_NDHMService {

	
	public String generateOTPForCareContext(String request) throws FHIRException;
	public String validateOTPForCareContext(String request) throws FHIRException;
	public String addCareContext(String request,String ndhmOTPToken) throws FHIRException;
}
