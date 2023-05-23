package com.wipro.fhir.r4.data.request_handler;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.wipro.fhir.r4.data.patient.PatientDemographicDetails;

@Component
public class PatientSearchAPIResponse {

	private ArrayList<PatientDemographicDetails> data;

	public ArrayList<PatientDemographicDetails> getData() {
		return data;
	}

	public void setData(ArrayList<PatientDemographicDetails> data) {
		this.data = data;
	}

}
