package com.wipro.fhir.r4.service.healthID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.wipro.fhir.r4.data.healthID.HealthIDRequestAadhar;
import com.wipro.fhir.r4.data.healthID.HealthIDResponse;

import com.wipro.fhir.r4.repo.healthID.HealthIDRepo;
import com.wipro.fhir.r4.service.ndhm.CreateHealthID_Aadhaar_NDHMService;
import com.wipro.fhir.r4.utils.exception.FHIRException;
import com.wipro.fhir.r4.utils.mapper.InputMapper;

@Service
@PropertySource("classpath:application.properties")
public class HealthIDWithUIDServiceImpl implements HealthIDWithUIDService {

	@Autowired
	private HealthIDRepo healthIDRepo;

	@Autowired
	private CreateHealthID_Aadhaar_NDHMService createHealthID_Aadhaar_NDHMService;

	@Override
	public String generateOTP(String request) throws FHIRException {
		String OTPres = null;
		try {
			OTPres = createHealthID_Aadhaar_NDHMService.generateOTP(request);
		} catch (Exception e) {
			throw new FHIRException(e.getMessage());
		}
		if (OTPres != null)
			return OTPres;
		else
			throw new FHIRException("NDHM_FHIR Error while generating OTP");
	}
	
	@Override
	public String verifyOTP(String request) throws FHIRException {
		String response = null;
		try {
			if (request != null ) {
			  response = createHealthID_Aadhaar_NDHMService.verifyOTP(request);
		} else
			throw new FHIRException("NDHM_FHIR Error Entered OTP is incorrect");
	} catch (Exception e) {
			throw new FHIRException(e.getMessage());
		}
		return response;
	}
	
	@Override
	public String checkAndGenerateOTP(String request) throws FHIRException {
		String response = null;
		try {
			if (request != null ) {
				response = createHealthID_Aadhaar_NDHMService.checkAndGenerateMobileOTP(request);
		} else
			throw new FHIRException("NDHM_FHIR Error Entered OTP is incorrect");
	} catch (Exception e) {
			throw new FHIRException(e.getMessage());
		}
		return response;
	}
	
	@Override
	public String verifyMobileOTP(String request) throws FHIRException {
		String response = null;
		try {
			if (request != null ) {
				response = createHealthID_Aadhaar_NDHMService.verifyMobileOTP(request);
		} else
			throw new FHIRException("NDHM_FHIR Error Entered OTP is incorrect");
	} catch (Exception e) {
			throw new FHIRException(e.getMessage());
		}
		return response;
	}

	@Override
	public String createHealthIDWithUID(String request) throws FHIRException {
		String res = null;
		try {
			HealthIDRequestAadhar obj = InputMapper.gson().fromJson(request, HealthIDRequestAadhar.class);
			HealthIDResponse health = createHealthID_Aadhaar_NDHMService.createHealthIDWithUID(request);
			if (health != null) {
				HealthIDResponse health1 = saveHealthIDResponse(health, obj);
				res = new Gson().toJson(health1);
			} else
				throw new FHIRException("NDHM_FHIR Error while creating ABHA");

		} catch (Exception e) {
			throw new FHIRException(e.getMessage());
		}
		return res;
	}

	private HealthIDResponse saveHealthIDResponse(HealthIDResponse health, HealthIDRequestAadhar healthOBJ) {
		String temp = "";
		if (health.getAuthMethods() != null && health.getAuthMethods().size() > 0) {
			for (int a = 0; a < health.getAuthMethods().size(); a++) {
				temp = temp + health.getAuthMethods().get(a) + "||";
			}
		}
		if (temp.length() > 2)
			temp = temp.substring(0, temp.length() - 2);
		if (temp.equalsIgnoreCase(""))
			temp = null;
		health.setAuthMethod(temp);
		if (healthOBJ.getCreatedBy() != null)
			health.setCreatedBy(healthOBJ.getCreatedBy());
		if (healthOBJ.getTxnId() != null)
			health.setTxnId(healthOBJ.getTxnId());
		if (healthOBJ.getProviderServiceMapID() != null)
			health.setProviderServiceMapID(healthOBJ.getProviderServiceMapID());
		HealthIDResponse health1 = healthIDRepo.save(health);
		return health1;
	}

}
