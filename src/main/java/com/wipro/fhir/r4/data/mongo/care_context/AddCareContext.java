package com.wipro.fhir.r4.data.mongo.care_context;

public class AddCareContext {

	String accessToken;
	CareContextPatient patient;
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public CareContextPatient getPatient() {
		return patient;
	}
	public void setPatient(CareContextPatient patient) {
		this.patient = patient;
	}
	
}
