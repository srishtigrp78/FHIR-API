package com.wipro.fhir.r4.service.healthID;

import com.wipro.fhir.r4.utils.exception.FHIRException;

public interface HealthIDService {
 String mapHealthIDToBeneficiary(String request) throws FHIRException;
 public String getBenHealthID(Long benRegID);
}
