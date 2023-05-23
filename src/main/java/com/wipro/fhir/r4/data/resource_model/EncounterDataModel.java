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
public class EncounterDataModel implements Serializable {

	/**
	 * default value
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long beneficiaryRegID;
	private Long visitCode;
	private Integer providerServiceMapID;
	private Integer vanID;
	private Integer nurseFlag;
	private Integer docFlag;
	private Integer specialistFlag;
	private Timestamp createdDate;
	private String createdBy;

	public EncounterDataModel() {
	}

	public EncounterDataModel(Object[] objArr) {
		this.id = ((BigInteger) objArr[0]).longValue();
		this.beneficiaryRegID = ((BigInteger) objArr[1]).longValue();
		this.visitCode = ((BigInteger) objArr[2]).longValue();
		this.providerServiceMapID = (Integer) objArr[3];
		this.vanID = (Integer) objArr[4];

		if (objArr[5] != null)
			this.nurseFlag = ((Short) objArr[5]).intValue();
		if (objArr[6] != null)
			this.docFlag = ((Short) objArr[6]).intValue();
		if (objArr[7] != null)
			this.specialistFlag = ((Short) objArr[7]).intValue();

		this.createdDate = (Timestamp) objArr[8];
		this.createdBy = (String) objArr[9];

	}

	public List<EncounterDataModel> getEncounterList(List<Object[]> resultSetList) {
		EncounterDataModel encounterOBJ;
		List<EncounterDataModel> encounterList = new ArrayList<EncounterDataModel>();
		if (resultSetList != null && resultSetList.size() > 0) {
			for (Object[] objArr : resultSetList) {
				encounterOBJ = new EncounterDataModel(objArr);
				encounterList.add(encounterOBJ);
			}
		}
		return encounterList;
	}

}
