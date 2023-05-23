package com.wipro.fhir.r4.data.atoms.feed.bahmni.patient;

import org.springframework.stereotype.Component;

@Component
public class OpenMRSPatientIdentifierType {
	private String uuid;
	private String display;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}

}
