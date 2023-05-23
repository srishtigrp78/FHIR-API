package com.wipro.fhir.r4.data.mongo.care_context;

public class Query {
 String id;
 String purpose;
 String authMode;
 Requester requester;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPurpose() {
	return purpose;
}
public void setPurpose(String purpose) {
	this.purpose = purpose;
}
public Requester getRequester() {
	return requester;
}
public void setRequester(Requester requester) {
	this.requester = requester;
}
public String getAuthMode() {
	return authMode;
}
public void setAuthMode(String authMode) {
	this.authMode = authMode;
}
}
