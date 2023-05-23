package com.wipro.fhir.r4.data.healthID;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
@Entity
@Table(name = "m_benhealthidmapping")
public class BenHealthIDMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "benHealthID")
	Integer benHealthID;
	@Expose
	@Column(name = "HealthIdNumber")
    String healthIdNumber;
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapId;
	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;
	@Transient
	private Long beneficiaryID;
	@Expose
	@Column(name = "HealthId")
    String healthId;
	@Expose
	@Column(name = "AuthenticationMode")
    String authenticationMode;
	
	public String getAuthenticationMode() {
		return authenticationMode;
	}
	public void setAuthenticationMode(String authenticationMode) {
		this.authenticationMode = authenticationMode;
	}
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted = false;
	@Expose
	@Column(name = "Processed")
	private String processed="N";
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;
	public Integer getBenHealthID() {
		return benHealthID;
	}
	public void setBenHealthID(Integer benHealthID) {
		this.benHealthID = benHealthID;
	}
	public String getHealthIdNumber() {
		return healthIdNumber;
	}
	public void setHealthIdNumber(String healthIdNumber) {
		this.healthIdNumber = healthIdNumber;
	}
	public Integer getProviderServiceMapID() {
		return providerServiceMapId;
	}
	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapId = providerServiceMapID;
	}
	public Long getBeneficiaryRegId() {
		return beneficiaryRegID;
	}
	public void setBeneficiaryRegId(Long beneficiaryRegId) {
		this.beneficiaryRegID = beneficiaryRegId;
	}
	public String getHealthId() {
		return healthId;
	}
	public void setHealthId(String healthId) {
		this.healthId = healthId;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public String getProcessed() {
		return processed;
	}
	public void setProcessed(String processed) {
		this.processed = processed;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Timestamp getLastModDate() {
		return lastModDate;
	}
	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}
	public Long getBeneficiaryID() {
		return beneficiaryID;
	}
	public void setBeneficiaryID(Long beneficiaryID) {
		this.beneficiaryID = beneficiaryID;
	}
	
}
