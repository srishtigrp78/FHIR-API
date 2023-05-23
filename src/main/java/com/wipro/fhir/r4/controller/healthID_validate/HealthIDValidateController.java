package com.wipro.fhir.r4.controller.healthID_validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.fhir.r4.service.healthID_validate.HealthIDValidationService;
import com.wipro.fhir.r4.utils.exception.FHIRException;
import com.wipro.fhir.r4.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping(value = "/validate", headers = "Authorization")
public class HealthIDValidateController {

	@Autowired
	private HealthIDValidationService healthIDValidationService;
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@CrossOrigin
	@ApiOperation(value = "generate OTP for ABHA Validation", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/generateOTPForHealthIDValidation" }, method = { RequestMethod.POST })
	public String generateOTPForHealthIDValidation(
			@ApiParam(value = "{\"healthID\":\"String\",\"isValidate\":\"Boolean\",\"authenticationMode\":\"String\"}") @RequestBody String request,
			@RequestHeader(value = "Authorization") String Authorization) {

		OutputResponse response = new OutputResponse();
		logger.info("NDHM_FHIR Generate Mobile OTP for ABHA validate API request" + request);
		try {
			if (request != null) {
				String s = healthIDValidationService.generateOTPForHealthIDValidation(request);
				response.setResponse(s);
			} else
				throw new FHIRException("NDHM_FHIR Empty request object");
		} catch (FHIRException e) {
			response.setError(5000, e.getMessage());
			logger.error(e.getMessage());
		}
		logger.info("NDHM_FHIR Generate Mobile OTP for ABHA validate API response" + response.toString());
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "verify OTP for ABHA validation", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/verifyOTPForHealthIDValidation" }, method = { RequestMethod.POST })
	public String verifyOTPForHealthIDValidation(
			@ApiParam(value = "{\"otp\":\"String\",\"txnId\":\"String\",\"healthID\":\"String\"}") @RequestBody String request,
			@RequestHeader(value = "Authorization") String Authorization) {

		OutputResponse response = new OutputResponse();
		logger.info("NDHM_FHIR verify OTP for ABHA validate API request" + request);
		try {
			if (request != null) {
				String s = healthIDValidationService.validateOTPAndHealthID(request);
				response.setResponse(s);
			} else
				throw new FHIRException("NDHM_FHIR Empty request object");
		} catch (FHIRException e) {
			response.setError(5000, e.getMessage());
			logger.error(e.getMessage());
		}
		logger.info("NDHM_FHIR verify OTP for ABHA validate API response" + response.toString());
		return response.toString();
	}
}
