package com.wipro.fhir.r4.data.atoms.feed.bahmni.encounter;

import org.springframework.stereotype.Component;

@Component
public class DosingInstructions {
	private Integer dose;
	private String doseUnits;
	private String route;
	private String frequency;
	private Boolean asNeeded;
	private String administrationInstructions;
	private Integer quantity;
	private String quantityUnits;
	private String numberOfRefills;
}
