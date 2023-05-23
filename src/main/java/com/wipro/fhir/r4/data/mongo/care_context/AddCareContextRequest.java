package com.wipro.fhir.r4.data.mongo.care_context;

public class AddCareContextRequest {
	
	String beneficiaryID;
	String healthID;
	String visitCode;
	String visitCategory;
	String healthIdNumber;
	public String getBeneficiaryID() {
		return beneficiaryID;
	}
	public void setBeneficiaryID(String beneficiaryID) {
		this.beneficiaryID = beneficiaryID;
	}
	public String getHealthID() {
		return healthID;
	}
	public void setHealthID(String healthID) {
		this.healthID = healthID;
	}
	public String getVisitCode() {
		return visitCode;
	}
	public void setVisitCode(String visitCode) {
		this.visitCode = visitCode;
	}
	public String getVisitCategory() {
		return visitCategory;
	}
	public void setVisitCategory(String visitCategory) {
		this.visitCategory = visitCategory;
	}
	public String getHealthIdNumber() {
		return healthIdNumber;
	}
	public void setHealthIdNumber(String healthIdNumber) {
		this.healthIdNumber = healthIdNumber;
	}
	
}
