package com.wipro.fhir.r4.service.healthID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import com.wipro.fhir.r4.data.healthID.BenHealthIDMapping;

import com.wipro.fhir.r4.repo.healthID.BenHealthIDMappingRepo;

import com.wipro.fhir.r4.utils.exception.FHIRException;
import com.wipro.fhir.r4.utils.http.HttpUtils;
import com.wipro.fhir.r4.utils.mapper.InputMapper;

@Service
public class HealthIDServiceImpl implements HealthIDService {
	@Autowired
	HttpUtils httpUtils;
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private BenHealthIDMappingRepo benHealthIDMappingRepo;

	public String mapHealthIDToBeneficiary(String request) throws FHIRException {
		BenHealthIDMapping health = InputMapper.gson().fromJson(request, BenHealthIDMapping.class);
		try {
			if (health.getBeneficiaryRegId() == null && health.getBeneficiaryID() == null)
				throw new FHIRException("Error in mapping request");
			if (health.getBeneficiaryRegId() != null)
				health = benHealthIDMappingRepo.save(health);
			else {
				if (health.getBeneficiaryID() != null) {
					Long check1 = benHealthIDMappingRepo.getBenRegID(health.getBeneficiaryID());
					health.setBeneficiaryRegId(check1);
					health = benHealthIDMappingRepo.save(health);
				}
			}
		} catch (Exception e) {
			throw new FHIRException("Error in saving data");
		}
		return new Gson().toJson(health);
	}

	public String getBenHealthID(Long benRegID) {
		Map<String, Object> resMap = new HashMap<>();

		ArrayList<BenHealthIDMapping> healthDetailsList = benHealthIDMappingRepo.getHealthDetails(benRegID);
		resMap.put("BenHealthDetails", new Gson().toJson(healthDetailsList));

		return resMap.toString();
	}
}