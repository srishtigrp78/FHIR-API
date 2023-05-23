package com.wipro.fhir.r4.data.atoms.feed.bahmni.patient;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class OpenMRSPersonAddress {
	private String uuid;
	private boolean preferred;
	private boolean voided;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private String address5;
	private String address6;
	private String address7;
	private String address8;
	private String cityVillage;
	private String countyDistrict;
	private String stateProvince;
	private String country;
	private String postalCode;
}
