package com.wipro.fhir.r4.data.resource_model;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
//@Entity
//@Table(name = "t_benallergyhistory")
//@NamedStoredProcedureQueries({
//		@NamedStoredProcedureQuery(name = "AllergyIntoleranceDataModel.allergyIntoleranceSp", procedureName = "db_iemr.FHIR_R_AllergyIntolerance", resultClasses = {
//				AllergyIntoleranceDataModel.class }, parameters = {
//						@StoredProcedureParameter(mode = ParameterMode.IN, name = "beneficiaryRegID_IN", type = Long.class),
//						@StoredProcedureParameter(mode = ParameterMode.IN, name = "visitCode_IN", type = Long.class),
//						@StoredProcedureParameter(mode = ParameterMode.OUT, name = "beneficiaryRegID_OUT", type = Long.class),
//						@StoredProcedureParameter(mode = ParameterMode.OUT, name = "visitCode_OUT", type = Long.class),
//						@StoredProcedureParameter(mode = ParameterMode.OUT, name = "providerServiceMapID_OUT", type = Integer.class),
//						@StoredProcedureParameter(mode = ParameterMode.OUT, name = "vanID_OUT", type = Integer.class),
//						@StoredProcedureParameter(mode = ParameterMode.OUT, name = "allergyStatus_OUT", type = String.class),
//						@StoredProcedureParameter(mode = ParameterMode.OUT, name = "allergyType_OUT", type = String.class),
//						@StoredProcedureParameter(mode = ParameterMode.OUT, name = "sctcode_OUT", type = String.class),
//						@StoredProcedureParameter(mode = ParameterMode.OUT, name = "sctTerm_OUT", type = String.class),
//						@StoredProcedureParameter(mode = ParameterMode.OUT, name = "createdDate_OUT", type = Timestamp.class),
//						@StoredProcedureParameter(mode = ParameterMode.OUT, name = "createdBy_OUT", type = String.class) }) })

public class AllergyIntoleranceDataModel implements Serializable {
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
	private String allergyStatus;
	private String allergyType;
	private String sctcode;
	private String sctTerm;
	private Timestamp createdDate;
	private String createdBy;
	private String allergicReactionType;

	public AllergyIntoleranceDataModel() {
	}

	public AllergyIntoleranceDataModel(Object[] objArr) {
		this.id = ((BigInteger) objArr[0]).longValue();
		this.beneficiaryRegID = ((BigInteger) objArr[1]).longValue();
		this.visitCode = ((BigInteger) objArr[2]).longValue();
		this.providerServiceMapID = (Integer) objArr[3];
		this.vanID = (Integer) objArr[4];
		this.allergyStatus = (String) objArr[5];
		this.allergyType = (String) objArr[6];
		this.sctcode = (String) objArr[7];
		this.sctTerm = (String) objArr[8];
		this.createdDate = (Timestamp) objArr[9];
		this.createdBy = (String) objArr[10];
		this.allergicReactionType = (String) objArr[11];

	}

	public List<AllergyIntoleranceDataModel> getAllergyList(List<Object[]> resultSetList) {
		AllergyIntoleranceDataModel allergyOBJ;
		List<AllergyIntoleranceDataModel> allergyList = new ArrayList<AllergyIntoleranceDataModel>();
		if (resultSetList != null && resultSetList.size() > 0) {
			for (Object[] objArr : resultSetList) {
				allergyOBJ = new AllergyIntoleranceDataModel(objArr);
				allergyList.add(allergyOBJ);
			}
		}
		return allergyList;
	}

}
