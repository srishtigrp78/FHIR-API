package com.wipro.fhir.r4.data.atoms.feed.bahmni.encounter;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FirstDiagnosis {
	private String order;
	private String certainty;
	private String freeTextAnswer;

	private CodedAnswer codedAnswer;

	private String existingObs;
	//private Date diagnosisDateTime;
	private Boolean voided;
	private String voidReason;
	private String comments;
	private List<Providers> providers;
	private String diagnosisStatusConcept;
	private String firstDiagnosis;
	private String latestDiagnosis;
	private Boolean revised;
	private String previousObs;
	private String encounterUuid;
	private String creatorName;

}
