package com.wipro.fhir.r4.service.healthID;

import com.wipro.fhir.r4.utils.exception.FHIRException;

public interface HealthIDWithUIDService {

	public String generateOTP(String request) throws FHIRException;
	public String verifyOTP(String request) throws FHIRException;
	public String createHealthIDWithUID(String request) throws FHIRException;
	String checkAndGenerateOTP(String request) throws FHIRException;
	String verifyMobileOTP(String request) throws FHIRException;
}
