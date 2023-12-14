package com.wipro.fhir.controller.healthID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.fhir.service.healthID.HealthIDWithBioService;
import com.wipro.fhir.service.healthID.HealthIDWithUIDService;
import com.wipro.fhir.utils.exception.FHIRException;
import com.wipro.fhir.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping(value = "/healthIDWithBio", headers = "Authorization")
public class CreateHealthIDWithBio {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	@Autowired
	private HealthIDWithBioService healthIDWithBioService;
	
	@CrossOrigin
	@ApiOperation(value = "Verify Bio", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/verifyBio" }, method = { RequestMethod.POST })
	public String verifyBio(@ApiParam(value = "{\"Aadhaar\":\"String\", \"pid\":\"String\",\"bioType\":\"String\"}") @RequestBody String request,
			@RequestHeader(value = "Authorization") String Authorization) {

		OutputResponse response = new OutputResponse();
		logger.info("NDHM_FHIR verify Bio API request" + request);
		try {
			if (request != null) {
				String s = healthIDWithBioService.verifyBio(request);
				response.setResponse(s);
			} else
				throw new FHIRException("NDHM_FHIR Empty request object");

		} catch (FHIRException e) {
			response.setError(5000, e.getMessage());
			logger.error(e.toString());
		}
		logger.info("NDHM_FHIR verify Bio API response" + response.toString());
		return response.toString();
	}
	
	
	@CrossOrigin
	@ApiOperation(value = "generate Mobile OTP", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/generateMobileOTP" }, method = { RequestMethod.POST })
	public String checkAndGenerateMobileOTP(
			@ApiParam(value = "{\"mobile\":\"String\", \"txnId\":\"String\"}") @RequestBody String request,
			@RequestHeader(value = "Authorization") String Authorization) {
		OutputResponse response = new OutputResponse();
		logger.info("NDHM_FHIR generate Aadhar OTP API request" + request);
		try {
			if (request != null) {
				String s = healthIDWithBioService.generateMobileOTP(request);
				response.setResponse(s);
			} else
				throw new FHIRException("NDHM_FHIR Empty request object");
		} catch (FHIRException e) {
			response.setError(5000, e.getMessage());
			logger.error(e.toString());
		}
		logger.info("NDHM_FHIR generate OTP API response" + response.toString());
		return response.toString();
	}

	@CrossOrigin
	@ApiOperation(value = "Confirm with Aadhaar Bio", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/confirmWithAadhaarBio" }, method = { RequestMethod.POST })
	public String confirmWithAadhaarBio(@ApiParam(value = "{\"txnId\":\"String\", \"pid\":\"String\",\"bioType\":\"String\",\"authType\":\"String\"}") @RequestBody String request,
			@RequestHeader(value = "Authorization") String Authorization) {

		OutputResponse response = new OutputResponse();
		logger.info("NDHM_FHIR Confirm Aadhaar Bio API request" + request);
		try {
			if (request != null) {
				String s = healthIDWithBioService.confirmWithAadhaarBio(request);
				response.setResponse(s);
			} else
				throw new FHIRException("NDHM_FHIR Empty request object");

		} catch (FHIRException e) {
			response.setError(5000, e.getMessage());
			logger.error(e.toString());
		}
		logger.info("NDHM_FHIR Confirm Aadhaar Bio API response" + response.toString());
		return response.toString();
	}
}
