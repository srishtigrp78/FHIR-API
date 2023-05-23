package com.wipro.fhir.r4.controller.healthID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.fhir.r4.service.healthID.HealthIDWithUIDService;
import com.wipro.fhir.r4.utils.exception.FHIRException;
import com.wipro.fhir.r4.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping(value = "/healthIDWithUID", headers = "Authorization")
public class CreateHealthID_WithUID {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	@Autowired
	private HealthIDWithUIDService HealthIDWithUIDService;

	@CrossOrigin
	@ApiOperation(value = "generate OTP", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/generateOTP" }, method = { RequestMethod.POST })
	public String generateOTP(@ApiParam(value = "{\"mobile\":\"String\"}") @RequestBody String request,
			@RequestHeader(value = "Authorization") String Authorization) {

		OutputResponse response = new OutputResponse();
		logger.info("NDHM_FHIR generate Aadhar OTP API request" + request);
		try {
			if (request != null) {
				String s = HealthIDWithUIDService.generateOTP(request);
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
	@ApiOperation(value = "verify OTP", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/verifyOTP" }, method = { RequestMethod.POST })
	public String verifyOTP(@ApiParam(value = "{\"OTP\":\"String\", \"txnId\":\"String\"}") @RequestBody String request,
			@RequestHeader(value = "Authorization") String Authorization) {

		OutputResponse response = new OutputResponse();
		logger.info("NDHM_FHIR generate Aadhar OTP API request" + request);
		try {
			if (request != null) {
				String s = HealthIDWithUIDService.verifyOTP(request);
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
	@ApiOperation(value = "check And Generate OTP", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/checkAndGenerateMobileOTP" }, method = { RequestMethod.POST })
	public String checkAndGenerateMobileOTP(@ApiParam(value = "{\"mobile\":\"String\", \"txnId\":\"String\"}") @RequestBody String request,
			@RequestHeader(value = "Authorization") String Authorization) {

		OutputResponse response = new OutputResponse();
		logger.info("NDHM_FHIR generate Aadhar OTP API request" + request);
		try {
			if (request != null) {
				String s = HealthIDWithUIDService.checkAndGenerateOTP(request);
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
	@ApiOperation(value = "verify mobile OTP", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/verifyMobileOTP" }, method = { RequestMethod.POST })
	public String verifyMobileOTP(@ApiParam(value = "{\"mobileOTP\":\"String\", \"txnId\":\"String\"}") @RequestBody String request,
			@RequestHeader(value = "Authorization") String Authorization) {

		OutputResponse response = new OutputResponse();
		logger.info("NDHM_FHIR generate Aadhar OTP API request" + request);
		try {
			if (request != null) {
				String s = HealthIDWithUIDService.verifyMobileOTP(request);
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
	@ApiOperation(value = "create ABHA with UID", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/createHealthIDWithUID" }, method = { RequestMethod.POST })
	public String createHealthIDWithUID(
			@ApiParam(value = "{\"otp\":\"String\",\"txnId\":\"String\",\"address\":\"String\",\"dayOfBirth\":\"String\",\"email\":\"String\",\"profilePhoto\":\"String\",\"password\":\"String\","
					+ "\"healthId\":\"String\",\"healthIdNumber\":\"String\",\"firstName\":\"String\",\"gender\":\"String\",\"lastName\":\"String\",\"middleName\":\"String\",\"monthOfBirth\":\"String\","
					+ "\"name\":\"String\",\"pincode\":\"Integer\",\"yearOfBirth\":\"String\",\"providerServiceMapId\":\"Integer\",\"createdBy\":\"String\"}") @RequestBody String request,
			@RequestHeader(value = "Authorization") String Authorization) {

		OutputResponse response = new OutputResponse();
		logger.info("NDHM_FHIR validate Aadhar OTP and create ABHA API request" + request);
		try {
			if (request != null) {
				String s = HealthIDWithUIDService.createHealthIDWithUID(request);
				response.setResponse(s);
			} else
				throw new FHIRException("NDHM_FHIR Empty request object");
		} catch (FHIRException e) {
			response.setError(5000, e.getMessage());
			logger.error(e.toString());
		}
		logger.info("NDHM_FHIR validate Aadhar OTP and create ABHA API response" + response.toString());
		return response.toString();
	}

}
