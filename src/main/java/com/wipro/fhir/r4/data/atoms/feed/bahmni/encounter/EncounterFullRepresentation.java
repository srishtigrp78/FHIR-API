package com.wipro.fhir.r4.data.atoms.feed.bahmni.encounter;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

import com.google.gson.annotations.Expose;

@Component
@Document(collection = "Clinical_Data_Higher_HealthCare_Center")
public class EncounterFullRepresentation {
	@Id
	@Expose
	@Field(value = "id")
	private String id;

	private List<BahmniDiagnoses> bahmniDiagnoses;
	private List<Observations> observations;

	// private String accessionNotes;

	private String encounterType;
	private String visitType;
	private String patientId;
	private String reason;
	private String patientUuid;

	private List<DrugOrders> drugOrders;

	private String locationUuid;
	private String visitUuid;
	private Boolean associatedToPatientProgram;
	private String patientProgramUuid;
	private String encounterUuid;
	private Date encounterDateTime;
	private String encounterTypeUuid;
	private String visitTypeUuid;
	private String disposition;
	private String locationName;

	// private String orders;
	private List<Providers> providers;
//	@Transient
//	private List<Observations> observationsReg;
//	@Transient
//	private List<Observations> observationsConsultation;

	// private String context;
	// private String extensions;

	public String getPatientId() {
		return patientId;
	}

//	public List<Observations> getObservationsReg() {
//		return observationsReg;
//	}
//
//
//	public void setObservationsReg(List<Observations> observationsReg) {
//		this.observationsReg = observationsReg;
//	}
//
//
//	public List<Observations> getObservationsConsultation() {
//		return observationsConsultation;
//	}
//
//
//	public void setObservationsConsultation(List<Observations> observationsConsultation) {
//		this.observationsConsultation = observationsConsultation;
//	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<BahmniDiagnoses> getBahmniDiagnoses() {
		return bahmniDiagnoses;
	}

	public void setBahmniDiagnoses(List<BahmniDiagnoses> bahmniDiagnoses) {
		this.bahmniDiagnoses = bahmniDiagnoses;
	}

	public List<Observations> getObservations() {
		return observations;
	}

	public void setObservations(List<Observations> observations) {
		this.observations = observations;
	}

	public String getEncounterType() {
		return encounterType;
	}

	public void setEncounterType(String encounterType) {
		this.encounterType = encounterType;
	}

	public String getVisitType() {
		return visitType;
	}

	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPatientUuid() {
		return patientUuid;
	}

	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}

	public List<DrugOrders> getDrugOrders() {
		return drugOrders;
	}

	public void setDrugOrders(List<DrugOrders> drugOrders) {
		this.drugOrders = drugOrders;
	}

	public String getLocationUuid() {
		return locationUuid;
	}

	public void setLocationUuid(String locationUuid) {
		this.locationUuid = locationUuid;
	}

	public String getVisitUuid() {
		return visitUuid;
	}

	public void setVisitUuid(String visitUuid) {
		this.visitUuid = visitUuid;
	}

	public Boolean getAssociatedToPatientProgram() {
		return associatedToPatientProgram;
	}

	public void setAssociatedToPatientProgram(Boolean associatedToPatientProgram) {
		this.associatedToPatientProgram = associatedToPatientProgram;
	}

	public String getPatientProgramUuid() {
		return patientProgramUuid;
	}

	public void setPatientProgramUuid(String patientProgramUuid) {
		this.patientProgramUuid = patientProgramUuid;
	}

	public String getEncounterUuid() {
		return encounterUuid;
	}

	public void setEncounterUuid(String encounterUuid) {
		this.encounterUuid = encounterUuid;
	}

	public Date getEncounterDateTime() {
		return encounterDateTime;
	}

	public void setEncounterDateTime(Date encounterDateTime) {
		this.encounterDateTime = encounterDateTime;
	}

	public String getEncounterTypeUuid() {
		return encounterTypeUuid;
	}

	public void setEncounterTypeUuid(String encounterTypeUuid) {
		this.encounterTypeUuid = encounterTypeUuid;
	}

	public String getVisitTypeUuid() {
		return visitTypeUuid;
	}

	public void setVisitTypeUuid(String visitTypeUuid) {
		this.visitTypeUuid = visitTypeUuid;
	}

	public String getDisposition() {
		return disposition;
	}

	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public List<Providers> getProviders() {
		return providers;
	}

	public void setProviders(List<Providers> providers) {
		this.providers = providers;
	}

}
