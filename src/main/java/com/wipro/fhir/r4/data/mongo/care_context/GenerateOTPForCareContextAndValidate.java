package com.wipro.fhir.r4.data.mongo.care_context;

public class GenerateOTPForCareContextAndValidate {//give common name

	String authenticationMode;
	String healthID;
	String healthIdNumber;
	public String getAuthenticationMode() {
		return authenticationMode;
	}
	public void setAuthenticationMode(String authenticationMode) {
		this.authenticationMode = authenticationMode;
	}
	public String getHealthID() {
		return healthID;
	}
	public void setHealthID(String healthID) {
		this.healthID = healthID;
	}
	public String getHealthIdNumber() {
		return healthIdNumber;
	}
	public void setHealthIdNumber(String healthIdNumber) {
		this.healthIdNumber = healthIdNumber;
     }
	
}
