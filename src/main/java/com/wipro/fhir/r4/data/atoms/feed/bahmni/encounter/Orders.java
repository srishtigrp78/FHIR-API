package com.wipro.fhir.r4.data.atoms.feed.bahmni.encounter;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Orders {
	private List<Concept> concept;

	private String instructions;
	private Boolean uuid;
	private String orderType;
	private String orderGroup;
	private Date dateCreated;
	private String dateChanged;
	private String dateStopped;
	private String orderNumber;
	private String careSetting;
	private Date action;
	private String commentToFulfiller;
	private String autoExpireDate;
	private String urgency;
	private String previousOrderUuid;
}
