package com.wipro.fhir.r4.data.resource_model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class LabTestAndComponentModel {

	/**
	 * default value
	 */
	private static final long serialVersionUID = 1L;

	// @Id
	// @GeneratedValue
	private Long id;
	private Long beneficiaryRegID;
	private Long visitCode;
	private Integer providerServiceMapID;
	private Integer vanID;
	private Integer procedureID;
	private Integer componentID;
	private String procedureName;
	private String testComponentName;
	private String testResultValue;
	private BigDecimal rangeMin;
	private BigDecimal rangeMax;
	private String loincCode;
	private String loincValue;
	private Timestamp createdDate;
	private String createdBy;
	private String remarks;
	private String snomedCTCode = "snomedCode";
	private String snomedCTTerm = "snomedTerm";
	private String testResultUnit;

	public LabTestAndComponentModel() {
	}

	public LabTestAndComponentModel(Object[] objArr) {
		this.id = ((BigInteger) objArr[0]).longValue();
		this.beneficiaryRegID = ((BigInteger) objArr[1]).longValue();
		this.visitCode = ((BigInteger) objArr[2]).longValue();
		this.providerServiceMapID = (Integer) objArr[3];
		this.vanID = (Integer) objArr[4];
		this.procedureID = (Integer) objArr[5];
		this.componentID = (Integer) objArr[6];
		this.procedureName = (String) objArr[7];
		this.testComponentName = (String) objArr[8];
		this.testResultValue = (String) objArr[9];
		this.rangeMin = (BigDecimal) objArr[10];
		this.rangeMax = (BigDecimal) objArr[11];
		this.loincCode = (String) objArr[12];
		this.loincValue = (String) objArr[13];
		this.createdDate = (Timestamp) objArr[14];
		this.createdBy = (String) objArr[15];
		this.remarks = (String) objArr[16];
		this.testResultUnit = (String) objArr[17];

	}

	public List<LabTestAndComponentModel> getlabTestAndComponentList(List<Object[]> resultSetList) {
		LabTestAndComponentModel labTestAndComponentModel;
		List<LabTestAndComponentModel> labTestAndComponentModelList = new ArrayList<LabTestAndComponentModel>();
		if (resultSetList != null && resultSetList.size() > 0) {
			for (Object[] objArr : resultSetList) {
				labTestAndComponentModel = new LabTestAndComponentModel(objArr);
				labTestAndComponentModelList.add(labTestAndComponentModel);
			}
		}
		return labTestAndComponentModelList;
	}

}
