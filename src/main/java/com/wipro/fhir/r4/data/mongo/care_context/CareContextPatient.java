package com.wipro.fhir.r4.data.mongo.care_context;

import java.util.ArrayList;

public class CareContextPatient {

	String referenceNumber;
	String display;
	ArrayList<CareContextDetials> careContexts;
	
	public String getReferencenumber() {
		return referenceNumber;
	}
	public void setReferencenumber(String referencenumber) {
		this.referenceNumber = referencenumber;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public ArrayList<CareContextDetials> getCarecontexts() {
		return careContexts;
	}
	public void setCarecontexts(ArrayList<CareContextDetials> carecontexts) {
		this.careContexts = carecontexts;
	}
}
