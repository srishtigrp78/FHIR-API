package com.wipro.fhir.r4.service.ndhm;

import com.wipro.fhir.r4.utils.exception.FHIRException;

public interface GenerateSession_NDHMService {
	
	public String generateNDHMAuthToken() throws FHIRException;

	public String getNDHMAuthToken() throws FHIRException;

}
