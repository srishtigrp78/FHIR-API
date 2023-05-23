package com.wipro.fhir.r4.service.healthID;

import com.wipro.fhir.r4.utils.exception.FHIRException;

public interface HealthID_WithMobileOTPService {
	 public String generateOTP(String request) throws FHIRException;
	 String verifyOTPandGenerateHealthID(String request) throws FHIRException;
}
