package com.wipro.fhir.r4.service.ndhm;


import com.wipro.fhir.r4.utils.exception.FHIRException;

public interface GenerateHealthID_CardService {
	public String generateOTP(String request) throws FHIRException;

	public String validateOTP(String request) throws FHIRException;

	public String generateCard(String requestOBJ, String NDHM_Auth_TOKEN) throws FHIRException;
}
