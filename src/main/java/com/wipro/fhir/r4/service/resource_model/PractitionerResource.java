package com.wipro.fhir.r4.service.resource_model;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.StringType;
import org.springframework.stereotype.Service;

@Service
public class PractitionerResource {

//	private String UUID;
	private Practitioner practitioner;

	public Practitioner getPractitioner() {
		return generatePractitionerResource();

	}

	// generating dummy Practitioner resource
	private Practitioner generatePractitionerResource() {
		practitioner = new Practitioner();

		practitioner.setId("Practitioner/MAX1456");

		List<Identifier> iList = new ArrayList<>();
		Identifier i = new Identifier();
		i.setSystem("https://www.mciindia.in/doctor");
		i.setValue("MAX1456");
		iList.add(i);
		practitioner.setIdentifier(iList);

		List<HumanName> pNameList = new ArrayList<>();
		HumanName hName = new HumanName();

		hName.setText("Harsh Dhave");

		List<StringType> stList = new ArrayList<>();
		StringType st = new StringType();
		st.setValue("Dr");
		stList.add(st);
		hName.setPrefix(stList);

		List<StringType> stList1 = new ArrayList<>();
		StringType st1 = new StringType();
		st.setValue("MBBS");
		stList1.add(st1);
		hName.setSuffix(stList1);

		pNameList.add(hName);

		practitioner.setName(pNameList);

		return practitioner;
	}
}
