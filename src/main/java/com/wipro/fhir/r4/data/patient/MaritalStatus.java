package com.wipro.fhir.r4.data.patient;

import org.springframework.stereotype.Component;

/***
 * 
 * @author NE298657
 *
 */

@Component
public class MaritalStatus {

	private Integer maritalStatusID;
	private String status;

	public Integer getMaritalStatusID() {
		return maritalStatusID;
	}

	public void setMaritalStatusID(Integer maritalStatusID) {
		this.maritalStatusID = maritalStatusID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
