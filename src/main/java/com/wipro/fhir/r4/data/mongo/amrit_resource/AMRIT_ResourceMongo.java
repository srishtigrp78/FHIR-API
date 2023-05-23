package com.wipro.fhir.r4.data.mongo.amrit_resource;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.google.gson.annotations.Expose;

@Document(collection = "AMRIT_Resource")
public class AMRIT_ResourceMongo {

	@Id
	@Expose
	@Field(value = "id")
	private String id;

	@Expose
	@Field(value = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Expose
	@Field(value = "BeneficiaryID")
	private Long beneficiaryID;

	@Expose
	@Field(value = "NationalHealthID")
	private String nationalHealthID;

	@Expose
	@Field(value = "VisitCode")
	private Long visitCode;

	@Expose
	@Field(value = "ResourceType")
	private String resourceType;

	@Expose
	@Field(value = "ResourceJson")
	private String resourceJson;

	@Expose
	@Field(value = "CreateDate")
	private Timestamp createDate = new Timestamp(System.currentTimeMillis());

	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public String getNationalHealthID() {
		return nationalHealthID;
	}

	public void setNationalHealthID(String nationalHealthID) {
		this.nationalHealthID = nationalHealthID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getBeneficiaryID() {
		return beneficiaryID;
	}

	public void setBeneficiaryID(Long beneficiaryID) {
		this.beneficiaryID = beneficiaryID;
	}

	public Long getVisitCode() {
		return visitCode;
	}

	public void setVisitCode(Long visitCode) {
		this.visitCode = visitCode;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceJson() {
		return resourceJson;
	}

	public void setResourceJson(String resourceJson) {
		this.resourceJson = resourceJson;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}
