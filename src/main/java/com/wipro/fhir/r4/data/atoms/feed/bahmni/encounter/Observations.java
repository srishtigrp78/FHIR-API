package com.wipro.fhir.r4.data.atoms.feed.bahmni.encounter;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Observations {
	//private Date encounterDateTime;
	//private Date visitStartDateTime;
	private String targetObsRelation;

	private List<GroupMembers> groupMembers;
	private List<Providers> providers;

	private String isAbnormal;
	private String duration;
	private String encounterUuid;
	private String obsGroupUuid;
	private String creatorName;
	private Integer conceptSortWeight;
	private String parentConceptUuid;
	private String hiNormal;
	private String lowNormal;
	private String formNamespace;
	private String formFieldPath;
	private String interpretation;
	private String status;
	private String complexData;

	private Concept concept;

	private String valueAsString;
	private String conceptUuid;
	private String uuid;
	private Boolean voided;
	private String voidReason;
	private Boolean unknown;
	//private Date observationDateTime;
	private String abnormal;
	private String conceptNameToDisplay;
	private String orderUuid;
	private String comment;
	private String value;
	private String type;
	
//	List<GroupMembers> ConsultationGroupMembers;
//	List<GroupMembers> RegistrationGroupMembers;
	public String getTargetObsRelation() {
		return targetObsRelation;
	}
	public void setTargetObsRelation(String targetObsRelation) {
		this.targetObsRelation = targetObsRelation;
	}
	public List<GroupMembers> getGroupMembers() {
		return groupMembers;
	}
	public void setGroupMembers(List<GroupMembers> groupMembers) {
		this.groupMembers = groupMembers;
	}
	public List<Providers> getProviders() {
		return providers;
	}
	public void setProviders(List<Providers> providers) {
		this.providers = providers;
	}
	public String getIsAbnormal() {
		return isAbnormal;
	}
	public void setIsAbnormal(String isAbnormal) {
		this.isAbnormal = isAbnormal;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getEncounterUuid() {
		return encounterUuid;
	}
	public void setEncounterUuid(String encounterUuid) {
		this.encounterUuid = encounterUuid;
	}
	public String getObsGroupUuid() {
		return obsGroupUuid;
	}
	public void setObsGroupUuid(String obsGroupUuid) {
		this.obsGroupUuid = obsGroupUuid;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public Integer getConceptSortWeight() {
		return conceptSortWeight;
	}
	public void setConceptSortWeight(Integer conceptSortWeight) {
		this.conceptSortWeight = conceptSortWeight;
	}
	public String getParentConceptUuid() {
		return parentConceptUuid;
	}
	public void setParentConceptUuid(String parentConceptUuid) {
		this.parentConceptUuid = parentConceptUuid;
	}
	public String getHiNormal() {
		return hiNormal;
	}
	public void setHiNormal(String hiNormal) {
		this.hiNormal = hiNormal;
	}
	public String getLowNormal() {
		return lowNormal;
	}
	public void setLowNormal(String lowNormal) {
		this.lowNormal = lowNormal;
	}
	public String getFormNamespace() {
		return formNamespace;
	}
	public void setFormNamespace(String formNamespace) {
		this.formNamespace = formNamespace;
	}
	public String getFormFieldPath() {
		return formFieldPath;
	}
	public void setFormFieldPath(String formFieldPath) {
		this.formFieldPath = formFieldPath;
	}
	public String getInterpretation() {
		return interpretation;
	}
	public void setInterpretation(String interpretation) {
		this.interpretation = interpretation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComplexData() {
		return complexData;
	}
	public void setComplexData(String complexData) {
		this.complexData = complexData;
	}
	public Concept getConcept() {
		return concept;
	}
	public void setConcept(Concept concept) {
		this.concept = concept;
	}
	public String getValueAsString() {
		return valueAsString;
	}
	public void setValueAsString(String valueAsString) {
		this.valueAsString = valueAsString;
	}
	public String getConceptUuid() {
		return conceptUuid;
	}
	public void setConceptUuid(String conceptUuid) {
		this.conceptUuid = conceptUuid;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Boolean getVoided() {
		return voided;
	}
	public void setVoided(Boolean voided) {
		this.voided = voided;
	}
	public String getVoidReason() {
		return voidReason;
	}
	public void setVoidReason(String voidReason) {
		this.voidReason = voidReason;
	}
	public Boolean getUnknown() {
		return unknown;
	}
	public void setUnknown(Boolean unknown) {
		this.unknown = unknown;
	}
	public String getAbnormal() {
		return abnormal;
	}
	public void setAbnormal(String abnormal) {
		this.abnormal = abnormal;
	}
	public String getConceptNameToDisplay() {
		return conceptNameToDisplay;
	}
	public void setConceptNameToDisplay(String conceptNameToDisplay) {
		this.conceptNameToDisplay = conceptNameToDisplay;
	}
	public String getOrderUuid() {
		return orderUuid;
	}
//	public List<GroupMembers> getConsultationGroupMembers() {
//		return ConsultationGroupMembers;
//	}
//	public void setConsultationGroupMembers(List<GroupMembers> consultationGroupMembers) {
//		ConsultationGroupMembers = consultationGroupMembers;
//	}
//	public List<GroupMembers> getRegistrationGroupMembers() {
//		return RegistrationGroupMembers;
//	}
//	public void setRegistrationGroupMembers(List<GroupMembers> registrationGroupMembers) {
//		RegistrationGroupMembers = registrationGroupMembers;
//	}
	public void setOrderUuid(String orderUuid) {
		this.orderUuid = orderUuid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
