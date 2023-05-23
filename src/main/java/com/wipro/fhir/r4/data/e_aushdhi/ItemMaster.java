package com.wipro.fhir.r4.data.e_aushdhi;


import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.google.gson.annotations.Expose;



@Entity
@Table(name = "m_item")
public class ItemMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name="ItemID")
	private Integer itemID;
	
	@Expose
	@Column(name="ItemName")
	private String itemName;
	
	@Expose
	@Column(name="isEDL")
	private Boolean isEDL;
	
	@Expose
	@Column(name="ItemDesc")
	private String itemDesc; 
	
	@Expose
	@Column(name="ItemCode")
	private String itemCode; 
	
	@Expose
	@Column(name="ItemCategoryID")
	private Integer itemCategoryID; 
	

	@Expose
	@Column(name="IsMedical")
	private Boolean isMedical;
		
	@Expose
	@Column(name="ItemFormID")
	private Integer itemFormID; 
	
	
	@Expose
	@Column(name="PharmacologyCategoryID")
	private Integer pharmacologyCategoryID;
	

	
	@Expose
	@Column(name="ManufacturerID")
	private Integer manufacturerID;
	


	@Expose
	@Column(name="Strength")
	private String strength;
	
	@Expose
	@Column(name="UOMID")
	private Integer uomID;
	

	@Expose
	@Column(name="IsScheduledDrug")
	private Boolean isScheduledDrug;
	
	@Expose
	@Column(name="Composition")
	private String composition;

	@Expose
	@Column(name="RouteID")
	private Integer routeID;
	

	
	@Expose
	@Column(name="ProviderServiceMapID")
	private Integer providerServiceMapID;
	

	
	@Expose
	@Column(name="Status")
	private String status;
	
	@Expose
	@Column(name="Discontinued",insertable = false, updatable = true)
	private Boolean discontinued;
	
	@Expose
	@Column(name="Deleted",insertable = false, updatable = true)
	private Boolean deleted; 
	
	@Expose
	@Column(name="Processed",insertable = false, updatable = true)
	private Character processed; 
	
	@Expose
	@Column(name="CreatedBy")
	private String createdBy; 
	
	@Expose
	@Column(name="CreatedDate",insertable = false, updatable = false)
	private Date createdDate;
	
	@Expose
	@Column(name="ModifiedBy")
	private String modifiedBy;
	
	@Expose
	@Column(name="LastModDate",insertable = false, updatable = false)
	private Date lastModDate;
	

	
	@Expose
	@Column(name = "Sctcode")
	private String sctCode;
	
	@Expose
	@Column(name = "SctTerm")
	private String sctTerm;
	
	@Expose
	@Column(name = "isEaushadi")
	private Boolean isEaushadi;
	
	

	
//	public M_itemfacilitymapping getM_itemfacilitymapping() {
//		return m_itemfacilitymapping;
//	}
//
//	public void setM_itemfacilitymapping(M_itemfacilitymapping m_itemfacilitymapping) {
//		this.m_itemfacilitymapping = m_itemfacilitymapping;
//	}

	public String getSctCode() {
		return sctCode;
	}

	public void setSctCode(String sctCode) {
		this.sctCode = sctCode;
	}

	public String getSctTerm() {
		return sctTerm;
	}

	public void setSctTerm(String sctTerm) {
		this.sctTerm = sctTerm;
	}

	public Integer getItemID() {
		return itemID;
	}

	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Boolean getIsEDL() {
		return isEDL;
	}

	public void setIsEDL(Boolean isEDL) {
		this.isEDL = isEDL;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Integer getItemCategoryID() {
		return itemCategoryID;
	}

	public void setItemCategoryID(Integer itemCategoryID) {
		this.itemCategoryID = itemCategoryID;
	}




	public Boolean getIsMedical() {
		return isMedical;
	}

	public void setIsMedical(Boolean isMedical) {
		this.isMedical = isMedical;
	}

	public Integer getItemFormID() {
		return itemFormID;
	}

	public void setItemFormID(Integer itemFormID) {
		this.itemFormID = itemFormID;
	}




	public Integer getPharmacologyCategoryID() {
		return pharmacologyCategoryID;
	}

	public void setPharmacologyCategoryID(Integer pharmacologyCategoryID) {
		this.pharmacologyCategoryID = pharmacologyCategoryID;
	}



	public Integer getManufacturerID() {
		return manufacturerID;
	}

	public void setManufacturerID(Integer manufacturerID) {
		this.manufacturerID = manufacturerID;
	}





	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public Integer getUomID() {
		return uomID;
	}

	public void setUomID(Integer uomID) {
		this.uomID = uomID;
	}





	public Boolean getIsScheduledDrug() {
		return isScheduledDrug;
	}

	public void setIsScheduledDrug(Boolean isScheduledDrug) {
		this.isScheduledDrug = isScheduledDrug;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	public Integer getRouteID() {
		return routeID;
	}

	public void setRouteID(Integer routeID) {
		this.routeID = routeID;
	}



	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(Boolean discontinued) {
		this.discontinued = discontinued;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Character getProcessed() {
		return processed;
	}

	public void setProcessed(Character processed) {
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

	
	
	public Boolean getIsEaushadi() {
		return isEaushadi;
	}

	public void setIsEaushadi(Boolean isEaushadi) {
		this.isEaushadi = isEaushadi;
	}

	public ItemMaster() {
	}

	public ItemMaster(Integer itemID, String ItemName) {
		// TODO Auto-generated constructor stub
		this.itemID=itemID;
		this.itemName=ItemName;
	}
	
	
}
