package com.wipro.fhir.r4.service.healthID;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.wipro.fhir.r4.service.ndhm.GenerateHealthID_CardService;
import com.wipro.fhir.r4.utils.exception.FHIRException;

/**
 * @author SH20094090 Date 09-11-2021
 */

@Service
public class HealthID_CardServiceImpl implements HealthID_CardService {
	@Autowired
	private GenerateHealthID_CardService generateHealthID_CardServiceImpl;

	@Override
	public String generateOTP(String request) throws FHIRException {
		String OTPres = null;
		try {
			OTPres = generateHealthID_CardServiceImpl.generateOTP(request);
		} catch (Exception e) {
			throw new FHIRException(e.getMessage());
		}
		if (OTPres != null)
			return OTPres;
		else
			throw new FHIRException("NDHM_FHIR Error while generating OTP");
	}

	@Override
	public String verifyOTPAndGenerateCard(String request) throws FHIRException {
		String res = null;
		try {
			String ndhmXToken = generateHealthID_CardServiceImpl.validateOTP(request);
			HashMap<String, String> map = new HashMap<String, String>();
			if (ndhmXToken != null) {
				String card = generateHealthID_CardServiceImpl.generateCard(request, ndhmXToken);
				if (card != null) {
					map.put("data", card);
					res = new Gson().toJson(map);
				} else
					throw new FHIRException("NDHM_FHIR Error while generating ABHA card");

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

}
