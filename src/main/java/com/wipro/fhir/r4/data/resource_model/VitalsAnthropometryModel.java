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
public class VitalsAnthropometryModel {
	/**
	 * default value
	 */
	private static final long serialVersionUID = 1L;

	private Long beneficiaryRegID;
	private Integer providerServiceMapID;
	private Long visitCode;
	private BigDecimal Temperature;
	private Short pulseRate;
	private Short respiratoryRate;
	private Short systolicBP_1stReading;
	private Short diastolicBP_1stReading;
	private String bloodPressureStatus;
	private Short bloodGlucose_Fasting;
	private Short bloodGlucose_Random;
	private BigDecimal weight_Kg;
	private BigDecimal height_cm;
	private BigDecimal BMI;
	private String createdBy;
	private Timestamp createdDate;

	public VitalsAnthropometryModel() {
	}

	public VitalsAnthropometryModel(Object[] objArr) {

		this.beneficiaryRegID = ((BigInteger) objArr[0]).longValue();
		this.providerServiceMapID = (Integer) objArr[1];
		this.visitCode = ((BigInteger) objArr[2]).longValue();
		if (objArr[3] != null)
			this.Temperature = (BigDecimal) objArr[3];
		if (objArr[4] != null)
			this.pulseRate = (Short) objArr[4];
		if (objArr[5] != null)
			this.respiratoryRate = (Short) objArr[5];
		if (objArr[6] != null)
			this.systolicBP_1stReading = (Short) objArr[6];
		if (objArr[7] != null)
			this.diastolicBP_1stReading = (Short) objArr[7];
		// skipping 8, 9, 10
		if (objArr[11] != null)
			this.bloodPressureStatus = (String) objArr[11];
		if (objArr[12] != null)
			this.bloodGlucose_Fasting = (Short) objArr[12];
		if (objArr[13] != null)
			this.bloodGlucose_Random = (Short) objArr[13];
		if (objArr[14] != null)
			this.weight_Kg = (BigDecimal) objArr[14];
		if (objArr[15] != null)
			this.height_cm = (BigDecimal) objArr[15];
		if (objArr[16] != null)
			this.BMI = (BigDecimal) objArr[16];
		this.createdDate = (Timestamp) objArr[17];
		this.createdBy = (String) objArr[18];

	}

	public List<VitalsAnthropometryModel> getVitalsAndAnthropometryList(List<Object[]> resultSetList) {
		VitalsAnthropometryModel vitalsAnthropometryModelOBJ;
		List<VitalsAnthropometryModel> vitalsAnthropometryModelList = new ArrayList<VitalsAnthropometryModel>();
		if (resultSetList != null && resultSetList.size() > 0) {
			for (Object[] objArr : resultSetList) {
				vitalsAnthropometryModelOBJ = new VitalsAnthropometryModel(objArr);
				vitalsAnthropometryModelList.add(vitalsAnthropometryModelOBJ);
			}
		}
		return vitalsAnthropometryModelList;
	}

}
