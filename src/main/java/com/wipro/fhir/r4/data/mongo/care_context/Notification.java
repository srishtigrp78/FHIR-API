package com.wipro.fhir.r4.data.mongo.care_context;

public class Notification {

	String phoneNo;
	HIP hip;
	
	public Notification(String phoneNo, HIP hip) {
		super();
		this.phoneNo = phoneNo;
		this.hip = hip;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public HIP getHip() {
		return hip;
	}
	public void setHip(HIP hip) {
		this.hip = hip;
	}
}
