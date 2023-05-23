package com.wipro.fhir.r4.data.atoms.feed.bahmni.encounter;

import org.springframework.stereotype.Component;

@Component
public class DrugOrders {
	private Concept concept;

	private String instructions;
	private String uuid;
	private String orderType;
	private String orderGroup;
//	private Date dateCreated;
//	private Date dateChanged;
//	private Date dateStopped;
	private String orderNumber;
	private String careSetting;
	private String action;
	private String commentToFulfiller;
//	private Date autoExpireDate;
	private String urgency;
	private String previousOrderUuid;

	private Drug drug;

	private String drugNonCoded;
	private String dosingInstructionType;

	private DosingInstructions dosingInstructions;

//	private Date dateActivated;
//	private Date scheduledDate;
//	private Date effectiveStartDate;
// private Date effectiveStopDate;
	private String orderReasonText;
	private Integer duration;
	private String durationUnits;
	private Boolean voided;
	private String voidReason;
	private String orderReasonConcept;
	private String sortWeight;

}
