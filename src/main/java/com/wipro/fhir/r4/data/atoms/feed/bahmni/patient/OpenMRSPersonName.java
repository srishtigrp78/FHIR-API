package com.wipro.fhir.r4.data.atoms.feed.bahmni.patient;

import org.springframework.stereotype.Component;

@Component
public class OpenMRSPersonName {
	private String uuid;
	private String givenName;
	private String middleName;
	private String familyName;
	private String familyName2;
	private boolean voided;
	private String display;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getFamilyName2() {
		return familyName2;
	}
	public void setFamilyName2(String familyName2) {
		this.familyName2 = familyName2;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public boolean isVoided() {
		return voided;
	}
	public void setVoided(boolean voided) {
		this.voided = voided;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	
}
