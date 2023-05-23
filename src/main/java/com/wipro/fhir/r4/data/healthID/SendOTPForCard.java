package com.wipro.fhir.r4.data.healthID;

public class SendOTPForCard {
	
	String authMethod;
	String healthid;
	String healthIdNumber;
	public String getAuthMethod() {
		return authMethod;
	}
	public void setAuthMethod(String authMethod) {
		this.authMethod = authMethod;
	}
	public String getHealthid() {
		return healthid;
	}
	public void setHealthid(String healthid) {
		this.healthid = healthid;
	}
	public String getHealthIdNumber() {
		return healthIdNumber;
	}
	public void setHealthIdNumber(String healthIdNumber) {
		this.healthIdNumber = healthIdNumber;
	}
	

}
