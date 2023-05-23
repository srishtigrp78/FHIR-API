package com.wipro.fhir.r4.data.patient;

import org.springframework.stereotype.Component;

/***
 * 
 * @author NE298657
 *
 */

@Component
public class PatientPhoneMaps {

	private String phoneNo;
	private Integer benRelationshipID;

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Integer getBenRelationshipID() {
		return benRelationshipID;
	}

	public void setBenRelationshipID(Integer benRelationshipID) {
		this.benRelationshipID = benRelationshipID;
	}

}
