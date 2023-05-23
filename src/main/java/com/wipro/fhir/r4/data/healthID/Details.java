package com.wipro.fhir.r4.data.healthID;

public class Details {
 String message;
 String code;
 Attribute attribute;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public Attribute getAttribute() {
	return attribute;
}
public void setAttribute(Attribute attribute) {
	this.attribute = attribute;
}
 
}
