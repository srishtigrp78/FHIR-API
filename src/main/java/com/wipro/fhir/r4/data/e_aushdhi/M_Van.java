package com.wipro.fhir.r4.data.e_aushdhi;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.google.gson.annotations.Expose;




@Entity
@Table(name="m_van")

public class M_Van {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="VanID")
	private Integer vanID;
	
	@Expose
	@Column(name="VanName")
	private String vanName;
	@Expose
	@Column(name="VehicalNo")
	private String vehicalNo;
	@Expose
	@Column(name="VanTypeID")
	private Integer vanTypeID;
	
	@Expose
	@Column(name="ProviderServiceMapID")
	private Integer providerServiceMapID;
	
	@Expose
	@Column(name="SwymedDomain")
	private String swymedDomain;
	
	@Expose
	@Column(name="SwymedID")
	private String swymedID;
	
	@Expose
	@Column(name="SwymedEmailID")
	private String swymedEmail;
	
	
	
	
	@Expose
	@Column(name="CountryID")
	private Integer countryID;

	
	@Expose
	@Column(name="StateID")
	private Integer stateID;
	

	

	
	@Expose
	@Column(name="ParkingPlaceID")
	private Integer parkingPlaceID;
	

	
	@Expose
	@Column(name="IsFacility")
	private Boolean isFacility;
	
	

	
	@Expose
	@Column(name="FacilityID")
	private Integer facilityID;
	


	

	@Expose
	@Column(name = "Deleted",insertable = false, updatable = true)
	private Boolean deleted; 
	@Expose
	@Column(name = "Processed",insertable = false, updatable = true)
	private String processed;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate" ,insertable = false, updatable = false)
	private Date createdDate;
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy; 
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Date lastModDate;
	
	
	@Expose
	@Column(name="vanSpokeMapped", insertable = false, updatable = false)
	private Boolean vanSpokeMapped;
	
	
	@Expose
	@Column(name = "vanfetosenseIDmapped", insertable = false, updatable = false)
	private Boolean vanfetosenseIDmapped;
	

	
	
	
	


	public String getVanName() {
		return vanName;
	}

	public void setVanName(String vanName) {
		this.vanName = vanName;
	}

	public String getVehicalNo() {
		return vehicalNo;
	}

	public void setVehicalNo(String vehicalNo) {
		this.vehicalNo = vehicalNo;
	}

	public Integer getVanTypeID() {
		return vanTypeID;
	}

	public void setVanTypeID(Integer vanTypeID) {
		this.vanTypeID = vanTypeID;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	
	

	public Integer getCountryID() {
		return countryID;
	}

	public void setCountryID(Integer countryID) {
		this.countryID = countryID;
	}

	


	public Integer getStateID() {
		return stateID;
	}

	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}

	

	


	public Integer getParkingPlaceID() {
		return parkingPlaceID;
	}

	public void setParkingPlaceID(Integer parkingPlaceID) {
		this.parkingPlaceID = parkingPlaceID;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Date lastModDate) {
		this.lastModDate = lastModDate;
	}

	public Integer getVanID() {
		return vanID;
	}
	



	
	
	
	
}
