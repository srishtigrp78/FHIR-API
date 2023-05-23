package com.wipro.fhir.r4.controller.healthID;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.fhir.r4.service.healthID.HealthIDService;
import com.wipro.fhir.r4.utils.exception.FHIRException;
import com.wipro.fhir.r4.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping(value = "/healthID", headers = "Authorization")
public class HealthIDController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	@Autowired
	private HealthIDService healthID;

	/***
	 * 
	 * @param request
	 * @param Authorization
	 * @return BenRegID of beneficiary after mapping
	 */
	@CrossOrigin
	@ApiOperation(value = "Map ABHA to beneficiary", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/mapHealthIDToBeneficiary" }, method = { RequestMethod.POST })
	public String mapHealthIDToBeneficiary(
			@ApiParam(value = "{\"beneficiaryRegID\":\"Long\",\"beneficiaryID\":\"Long\",\"healthId\":\"String\",\"healthIdNumber\":\"String\""
					+ "providerServiceMapId\":\"Integer\",\"createdBy\":\"String\"}") @RequestBody String request,
			@RequestHeader(value = "Authorization") String Authorization) {
		logger.info("NDHM_FHIR Map ABHA to beneficiary API request " + request);
		OutputResponse response = new OutputResponse();
		try {
			if (request != null) {
				String s = healthID.mapHealthIDToBeneficiary(request);
				response.setResponse(s);
			} else
				throw new FHIRException("NDHM_FHIR Empty request object");
		} catch (FHIRException e) {
			response.setError(5000, e.getMessage());
			logger.error(e.toString());
		}
		logger.info("NDHM_FHIR Map ABHA to beneficiary API response " + response.toString());
		return response.toString();
	}

	/***
	 * 
	 * @param comingRequest
	 * @return ABHA of Beneficiary
	 */
	@CrossOrigin()
	@ApiOperation(value = "Get Beneficiary ABHA details", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getBenhealthID" }, method = { RequestMethod.POST })
	public String getBenhealthID(
			@ApiParam(value = "{\"beneficiaryRegID\":\"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();

		logger.info("NDHM_FHIR Request obj to fetch beneficiary ABHA details :" + comingRequest);
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj.length() > 0) {
				Long benRegID = obj.getLong("beneficiaryRegID");
				String res = healthID.getBenHealthID(benRegID);
				response.setResponse(res);
			} else {
				logger.info("NDHM_FHIR Invalid Request Data.");
				response.setError(5000, "NDHM_FHIR Invalid request");
			}
		} catch (Exception e) {
			response.setError(5000, e.getMessage());
			logger.error("NDHM_FHIR Error while getting beneficiary ABHA:" + e);
		}
		logger.info("NDHM_FHIR get beneficiary ABHA response:" + response.toString());
		return response.toString();
	}
}
