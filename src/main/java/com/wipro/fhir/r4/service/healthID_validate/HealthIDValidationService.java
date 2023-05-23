package com.wipro.fhir.r4.service.healthID_validate;

import com.wipro.fhir.r4.utils.exception.FHIRException;

public interface HealthIDValidationService {
	public String generateOTPForHealthIDValidation(String request) throws FHIRException;
	public String validateOTPAndHealthID(String request) throws FHIRException;
}
