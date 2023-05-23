package com.wipro.fhir.r4.service.healthID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.wipro.fhir.r4.data.healthID.HealthIDRequest;
import com.wipro.fhir.r4.data.healthID.HealthIDResponse;
import com.wipro.fhir.r4.repo.healthID.HealthIDRepo;
import com.wipro.fhir.r4.service.ndhm.CreateHealthID_MobileOTP_NDHMService;
import com.wipro.fhir.r4.utils.exception.FHIRException;
import com.wipro.fhir.r4.utils.http.HttpUtils;
import com.wipro.fhir.r4.utils.mapper.InputMapper;
@Service
public class HealthID_WithMobileOTPServiceImpl implements HealthID_WithMobileOTPService {
	@Autowired
	HttpUtils httpUtils;

	@Autowired
	private HealthIDRepo healthIDRepo;
	@Autowired
	private CreateHealthID_MobileOTP_NDHMService createHealthID_MobileOTP_NDHM;

	@Override
	public String generateOTP(String request) throws FHIRException {
		String OTPres = null;
		try {
			OTPres = createHealthID_MobileOTP_NDHM.generateOTP(request);
		} catch (Exception e) {
			throw new FHIRException(e.getMessage());
		}
		if (OTPres != null)
			return OTPres;
		else
			throw new FHIRException("NDHM_FHIR Error while generating OTP");
	}

	@Override
	public String verifyOTPandGenerateHealthID(String request) throws FHIRException {
		String res = null;
		try {
			HealthIDRequest healthOBJ = InputMapper.gson().fromJson(request, HealthIDRequest.class);
			String ndhmOTPToken = createHealthID_MobileOTP_NDHM.validateOTP(request);
			if (ndhmOTPToken != null) {
				HealthIDResponse health = createHealthID_MobileOTP_NDHM.createHealthID(request, ndhmOTPToken);
				if (health != null) {
					HealthIDResponse health1 = saveHealthIDResponse(health, healthOBJ);
					res = new Gson().toJson(health1);
				} else
					throw new FHIRException("NDHM_FHIR Error while creating ABHA");

			} else {
				throw new FHIRException("NDHM_FHIR Error while validating OTP");
			}

		} catch (Exception e) {
			throw new FHIRException(e.getMessage());
		}
		if (res != null)
			return res;
		else
			throw new FHIRException("NDHM_FHIR Error while validating OTP");

	}

	private HealthIDResponse saveHealthIDResponse(HealthIDResponse health, HealthIDRequest healthOBJ) {
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
