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
public class AppointmentDataModel implements Serializable {

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
	private String status;
	private Timestamp requestDate;
	private Integer userID;
	private String sName;
	private Integer designationID;
	private String designationName;
	private Timestamp createdDate;
	private String createdBy;

	public AppointmentDataModel() {
	}

	public AppointmentDataModel(Object[] objArr) {
		this.id = ((BigInteger) objArr[0]).longValue();
		this.beneficiaryRegID = ((BigInteger) objArr[1]).longValue();
		this.visitCode = ((BigInteger) objArr[2]).longValue();
		this.providerServiceMapID = (Integer) objArr[3];
		this.vanID = (Integer) objArr[4];

		this.status = (String) objArr[5];
		this.requestDate = (Timestamp) objArr[6];
		this.userID = (Integer) objArr[7];
		this.sName = (String) objArr[8];
		this.designationID = (Integer) objArr[9];
		this.designationName = (String) objArr[10];

		this.createdDate = (Timestamp) objArr[11];
		this.createdBy = (String) objArr[12];

	}

	public List<AppointmentDataModel> getAppointmentList(List<Object[]> resultSetList) {
		AppointmentDataModel appointmentOBJ;
		List<AppointmentDataModel> appointmentList = new ArrayList<AppointmentDataModel>();
		if (resultSetList != null && resultSetList.size() > 0) {
			for (Object[] objArr : resultSetList) {
				appointmentOBJ = new AppointmentDataModel(objArr);
				appointmentList.add(appointmentOBJ);
			}
		}
		return appointmentList;
	}

}
