package com.wipro.fhir.r4.data.resource_model;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ConditionDiagnosisDataModel implements Serializable {

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
	private String sctcode;
	private String sctTerm;
	private Timestamp createdDate;
	private String createdBy;

	public ConditionDiagnosisDataModel() {
	}

	public ConditionDiagnosisDataModel(Object[] objArr) {
		this.id = ((BigInteger) objArr[0]).longValue();
		this.beneficiaryRegID = ((BigInteger) objArr[1]).longValue();
		this.visitCode = ((BigInteger) objArr[2]).longValue();
		this.providerServiceMapID = (Integer) objArr[3];
		this.vanID = (Integer) objArr[4];
		this.sctTerm = (String) objArr[5];
		this.sctcode = (String) objArr[6];
		this.createdDate = (Timestamp) objArr[7];
		this.createdBy = (String) objArr[8];

	}

	public List<ConditionDiagnosisDataModel> getConditionList(List<Object[]> resultSetList) {
		ConditionDiagnosisDataModel conditionOBJ;
		List<ConditionDiagnosisDataModel> conditionList = new ArrayList<ConditionDiagnosisDataModel>();
		if (resultSetList != null && resultSetList.size() > 0) {
			for (Object[] objArr : resultSetList) {
				conditionOBJ = new ConditionDiagnosisDataModel(objArr);
				conditionList.add(conditionOBJ);
			}
		}
		return conditionList;
	}

}
