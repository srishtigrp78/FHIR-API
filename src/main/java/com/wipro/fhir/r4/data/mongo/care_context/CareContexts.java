package com.wipro.fhir.r4.data.mongo.care_context;

import com.google.gson.annotations.Expose;

public class CareContexts {

	@Expose
	private String ReferenceNumber;

	@Expose
	private String Display;

	public String getReferenceNumber() {
		return ReferenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		ReferenceNumber = referenceNumber;
	}

	public String getDisplay() {
		return Display;
	}

	public void setDisplay(String display) {
		Display = display;
	}

}
