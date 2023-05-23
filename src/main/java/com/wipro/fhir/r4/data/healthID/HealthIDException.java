package com.wipro.fhir.r4.data.healthID;

public class HealthIDException {
 String code;
 String message;
 Details details[];
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Details[] getDetails() {
	return details;
}
public void setDetails(Details[] details) {
	this.details = details;
}
 
}
