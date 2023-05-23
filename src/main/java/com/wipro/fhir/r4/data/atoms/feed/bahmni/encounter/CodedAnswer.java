package com.wipro.fhir.r4.data.atoms.feed.bahmni.encounter;

import org.springframework.stereotype.Component;

@Component
public class CodedAnswer {
	private String uuid;
	private String name;
	private String dataType;
	private String shortName;
	private String conceptClass;
	private String hiNormal;
	private String lowNormal;
	private Boolean set;

	//private String mappings;
}
