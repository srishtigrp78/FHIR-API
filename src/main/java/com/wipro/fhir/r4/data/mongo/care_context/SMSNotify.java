package com.wipro.fhir.r4.data.mongo.care_context;

public class SMSNotify {
	String requestId;
	String timestamp;
	Notification notification;
	public SMSNotify(String requestId, String timestamp, Notification notification) {
		super();
		this.requestId = requestId;
		this.timestamp = timestamp;
		this.notification = notification;
	}
	
}
