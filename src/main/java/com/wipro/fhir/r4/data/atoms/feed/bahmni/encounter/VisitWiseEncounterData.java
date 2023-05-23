package com.wipro.fhir.r4.data.atoms.feed.bahmni.encounter;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class VisitWiseEncounterData {

	private String visitUuid;
	private Date encounterDateTime;
	private String visitTypeUuid;
	private String visitType;

	private String patientId;

	private List<BahmniDiagnoses> bahmniDiagnoses;

	private List<GroupMembers> observationsGMReg;
	private List<GroupMembers> observationsGMConsultation;

	private List<DrugOrders> drugOrders;

	public String getVisitUuid() {
		return visitUuid;
	}

	public void setVisitUuid(String visitUuid) {
		this.visitUuid = visitUuid;
	}

	public Date getEncounterDateTime() {
		return encounterDateTime;
	}

	public void setEncounterDateTime(Date encounterDateTime) {
		this.encounterDateTime = encounterDateTime;
	}

	public String getVisitTypeUuid() {
		return visitTypeUuid;
	}

	public void setVisitTypeUuid(String visitTypeUuid) {
		this.visitTypeUuid = visitTypeUuid;
	}

	public String getVisitType() {
		return visitType;
	}

	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public List<BahmniDiagnoses> getBahmniDiagnoses() {
		return bahmniDiagnoses;
	}

	public void setBahmniDiagnoses(List<BahmniDiagnoses> bahmniDiagnoses) {
		this.bahmniDiagnoses = bahmniDiagnoses;
	}

	public List<GroupMembers> getObservationsGMReg() {
		return observationsGMReg;
	}

	public void setObservationsGMReg(List<GroupMembers> observationsGMReg) {
		this.observationsGMReg = observationsGMReg;
	}

	public List<GroupMembers> getObservationsGMConsultation() {
		return observationsGMConsultation;
	}

	public void setObservationsGMConsultation(List<GroupMembers> observationsGMConsultation) {
		this.observationsGMConsultation = observationsGMConsultation;
	}

	public List<DrugOrders> getDrugOrders() {
		return drugOrders;
	}

	public void setDrugOrders(List<DrugOrders> drugOrders) {
		this.drugOrders = drugOrders;
	}

}
