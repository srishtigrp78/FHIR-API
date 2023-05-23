package com.wipro.fhir.r4.service.healthID_validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.fhir.r4.service.healthID.HealthIDServiceImpl;
import com.wipro.fhir.r4.service.ndhm.ValidateHealthID_NDHMService;
import com.wipro.fhir.r4.utils.exception.FHIRException;
import com.wipro.fhir.r4.utils.http.HttpUtils;

@Service
public class HealthIDValidationServiceImpl implements HealthIDValidationService {
	@Autowired
	HealthIDServiceImpl healthID;
	@Autowired
	HttpUtils httpUtils;

	@Autowired
	private ValidateHealthID_NDHMService validateHealthID_NDHMService;

	@Override
	public String generateOTPForHealthIDValidation(String request) throws FHIRException {
		String OTPres = null;
		try {
			OTPres = validateHealthID_NDHMService.generateOTPForHealthIDValidation(request);
		} catch (Exception e) {
			throw new FHIRException(e.getMessage());
		}
		if (OTPres != null)
			return OTPres;
		else
			throw new FHIRException("NDHM_FHIR Error while generating OTP");
	}

	@Override
	public String validateOTPAndHealthID(String request) throws FHIRException {
		String OTPres = null;
		try {
			OTPres = validateHealthID_NDHMService.validateOTPForHealthIDValidation(request);
		} catch (Exception e) {
			throw new FHIRException(e.getMessage());
		}
		if (OTPres != null)
			return OTPres;
		else
			throw new FHIRException("NDHM_FHIR Error while validating OTP");

	}

}
