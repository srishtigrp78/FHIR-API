package com.wipro.fhir.r4.controller.patient_data_handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.fhir.r4.data.request_handler.ResourceRequestHandler;
import com.wipro.fhir.r4.service.patient_data_handler.HigherHealthFacilityServiceImpl;
import com.wipro.fhir.r4.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = "/higher/health/facility", headers = "Authorization")
public class HigherHealthFacilityController {

	@Autowired
	private HigherHealthFacilityServiceImpl higherHealthFacilityServiceImpl;

	@CrossOrigin
	@ApiOperation(value = "update bengenid for higher health facility beneficiary", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/update/bengenid" }, method = { RequestMethod.POST })
	public String feedPatientDemographicData(@RequestBody ResourceRequestHandler resourceRequestHandler) {

		OutputResponse response = new OutputResponse();
		try {
			String s = higherHealthFacilityServiceImpl
					.updateBengenIDToHigherHealthFacilityBeneficiary(resourceRequestHandler);
			if (s != null)
				response.setResponse(s);
			else
				response.setError(5000, "Error in updating Beneficary ID to higher health data");
		} catch (Exception e) {
			response.setError(5000, e.getMessage());
			response.setError(5000, "Error in updating Beneficary ID to higher health data. " + e.getMessage());
		}

		return response.toString();

	}

	@CrossOrigin
	@ApiOperation(value = "get clinical data from higher health facility", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/get/clinical/data" }, method = { RequestMethod.POST })
	public String getCLinicalDataHigherhealthFacility(@RequestBody ResourceRequestHandler resourceRequestHandler) {

		OutputResponse response = new OutputResponse();
		try {
			String s = higherHealthFacilityServiceImpl.getCLinicalDataHigherhealthFacility(resourceRequestHandler);
			if (s != null)
				response.setResponse(s);
			else
				response.setError(5000, "Error in getting higher health data");
		} catch (Exception e) {
			response.setError(5000, e.getMessage());
			response.setError(5000, "Error in getting higher health data. " + e.getMessage());
		}

		return response.toString();

	}
}
