package com.wipro.fhir.r4.data.request_handler;

import org.springframework.stereotype.Component;

import com.google.gson.annotations.Expose;

/***
 * 
 * @author NE298657
 *
 */

@Component

public class ResourceRequestHandler {
	// patient ||
	private Long beneficiaryID;
	// Encounter/ care-context
	private Long visitCode;
	private Long beneficiaryRegID;
	private Long benFlowID;

	// 27-10-2021
	@Expose
	private String healthId;
	@Expose
	private String healthIdNumber;
	@Expose
	private String amritId;
	@Expose
	private String externalId;
	@Expose
	private Integer pageNo;
	@Expose
	private String phoneNo;
	@Expose
	private String state;
	@Expose
	private String district;
	@Expose
	private String village;

	public String getHealthId() {
		return healthId;
	}

	public void setHealthId(String healthId) {
		this.healthId = healthId;
	}

	public String getHealthIdNumber() {
		return healthIdNumber;
	}

	public void setHealthIdNumber(String healthIdNumber) {
		this.healthIdNumber = healthIdNumber;
	}

	public String getAmritId() {
		return amritId;
	}

	public void setAmritId(String amritId) {
		this.amritId = amritId;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public Long getBenFlowID() {
		return benFlowID;
	}

	public void setBenFlowID(Long benFlowID) {
		this.benFlowID = benFlowID;
	}

	public Long getVisitCode() {
		return visitCode;
	}

	public void setVisitCode(Long visitCode) {
		this.visitCode = visitCode;
	}

	public Long getBeneficiaryID() {
		return beneficiaryID;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public void setBeneficiaryID(Long beneficiaryID) {
		this.beneficiaryID = beneficiaryID;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

}
