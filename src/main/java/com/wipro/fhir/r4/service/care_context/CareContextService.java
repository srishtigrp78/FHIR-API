package com.wipro.fhir.r4.service.care_context;

import com.wipro.fhir.r4.utils.exception.FHIRException;

public interface CareContextService {
	public String generateOTPForCareContext(String request) throws FHIRException;
	public String validateOTPAndCreateCareContext(String request) throws FHIRException;
}
