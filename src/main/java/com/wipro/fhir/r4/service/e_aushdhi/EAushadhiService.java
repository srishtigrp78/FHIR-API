package com.wipro.fhir.r4.service.e_aushdhi;

import java.util.List;

import com.wipro.fhir.r4.utils.exception.FHIRException;

public interface EAushadhiService {

	public String syncDispenseDetailsToEAushadhi(String request, String Authorization) throws FHIRException;

	public void getStockDetailsFromEAushadhi();

	public String getEaushadhiStoreDetailsByFacilityID(String request) throws FHIRException;

	public String getFacilityStockProcessLog(String request) throws FHIRException;


	public String updateSyncStatusForEAushadhiDispense(List<String> syncedIssueDetails) throws FHIRException;
}
