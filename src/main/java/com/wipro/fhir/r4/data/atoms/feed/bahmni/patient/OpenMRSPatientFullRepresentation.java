package com.wipro.fhir.r4.data.atoms.feed.bahmni.patient;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class OpenMRSPatientFullRepresentation {
	private String uuid;
	private List<OpenMRSPatientIdentifier> identifiers;
	private OpenMRSPerson person;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public List<OpenMRSPatientIdentifier> getIdentifiers() {
		return identifiers;
	}
	public void setIdentifiers(List<OpenMRSPatientIdentifier> identifiers) {
		this.identifiers = identifiers;
	}
	public OpenMRSPerson getPerson() {
		return person;
	}
	public void setPerson(OpenMRSPerson person) {
		this.person = person;
	}
	
}
