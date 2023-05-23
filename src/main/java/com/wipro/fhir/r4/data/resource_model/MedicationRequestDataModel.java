package com.wipro.fhir.r4.data.resource_model;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class MedicationRequestDataModel {

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

	private String drugForm;
	private String genericDrugName;
	private String snomedCTCodeDrug;
	private String snomedCTTermDrug;

	private String drugStrength;
	private String drugDose;

	private String drugRoute;
	private String snomedCTCodeROA;
	private String snomedCTTermROA;

	private String drugFrequency;

	private String duration;
	private String durationUnit;

	private String instructions;

	private String additionalInstructions;
	private String snomedCTCodeAI;
	private String snomedCTTermAI;

	private Integer qtyPrescribed;

	private Timestamp createdDate;
	private String createdBy;

	public MedicationRequestDataModel() {
	}

	public MedicationRequestDataModel(Object[] objArr) {
		this.id = ((BigInteger) objArr[0]).longValue();
		this.beneficiaryRegID = ((BigInteger) objArr[1]).longValue();
		this.visitCode = ((BigInteger) objArr[2]).longValue();
		this.providerServiceMapID = (Integer) objArr[3];
		this.vanID = (Integer) objArr[4];

		this.drugForm = (String) objArr[5];
		this.genericDrugName = (String) objArr[6];
		this.drugStrength = (String) objArr[7];
		this.drugDose = (String) objArr[8];
		this.drugRoute = (String) objArr[9];
		this.drugFrequency = (String) objArr[10];

		this.duration = (String) objArr[11];
		this.durationUnit = (String) objArr[12];

		this.instructions = (String) objArr[13];
		this.qtyPrescribed = (Integer) objArr[14];

		this.snomedCTCodeDrug = (String) objArr[15];
		this.snomedCTTermDrug = (String) objArr[16];
		this.createdDate = (Timestamp) objArr[17];
		this.createdBy = (String) objArr[18];

	}

	public List<MedicationRequestDataModel> getMedicationRequestList(List<Object[]> resultSetList) {
		MedicationRequestDataModel medicationOBJ;
		List<MedicationRequestDataModel> medicationList = new ArrayList<MedicationRequestDataModel>();
		if (resultSetList != null && resultSetList.size() > 0) {
			for (Object[] objArr : resultSetList) {
				medicationOBJ = new MedicationRequestDataModel(objArr);
				medicationList.add(medicationOBJ);
			}
		}
		return medicationList;
	}

}
