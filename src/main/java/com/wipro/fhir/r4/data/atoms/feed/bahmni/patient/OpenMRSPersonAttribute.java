package com.wipro.fhir.r4.data.atoms.feed.bahmni.patient;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class OpenMRSPersonAttribute {
	private String uuid;
	private boolean voided;
	private Object value;
	private OpenMRSPersonAttributeType attributeType;
}
