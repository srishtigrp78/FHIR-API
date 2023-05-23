package com.wipro.fhir.r4.controller.healthCard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.fhir.r4.service.healthID.HealthID_CardService;
import com.wipro.fhir.r4.utils.exception.FHIRException;
import com.wipro.fhir.r4.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author SH20094090 Date 09-11-2021
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/healthIDCard", headers = "Authorization")
public class GenerateHealthIDCardController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	@Autowired
	private HealthID_CardService healthID_CardService;

	@CrossOrigin
	@ApiOperation(value = "Generate OTP for ABHA card", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/generateOTP" }, method = { RequestMethod.POST })
	public String mapHealthIDToBeneficiary(
			@ApiParam(value = "{\"authMethod\":\"String\",\"healthid\":\"String\",\"healthIdNumber\":\"String\"}") @RequestBody String request,
			@RequestHeader(value = "Authorization") String Authorization) {
		logger.info("NDHM_FHIR generate OTP for ABHA card API request " + request);
		OutputResponse response = new OutputResponse();
		try {
			if (request != null) {
				String s = healthID_CardService.generateOTP(request);
				response.setResponse(s);
			} else
				throw new FHIRException("NDHM_FHIR Empty request object");
		} catch (FHIRException e) {
			response.setError(5000, e.getMessage());
			logger.error(e.toString());
		}
		logger.info("NDHM_FHIR generate OTP for ABHA card API response " + response.toString());
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "Generate OTP for ABHA card", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/verifyOTPAndGenerateHealthCard" }, method = { RequestMethod.POST })
	public String verifyOTPAndGenerateHealthCard(
			@ApiParam(value = "{\"otp\":\"String\",\"txnId\":\"String\",\"authMethod\":\"String\"}") @RequestBody String request,
			@RequestHeader(value = "Authorization") String Authorization) {
		logger.info("NDHM_FHIR verify OTP and generate ABHA card API request " + request);
		OutputResponse response = new OutputResponse();
		try {
			if (request != null) {
				String s = healthID_CardService.verifyOTPAndGenerateCard(request);
				response.setResponse(s);
			} else
				throw new FHIRException("NDHM_FHIR Empty request object");
		} catch (FHIRException e) {
			response.setError(5000, e.getMessage());
			logger.error(e.toString());
		}
		logger.info("NDHM_FHIR generate ABHA card API response " + response.toString());
		return response.toString();
	}

}
