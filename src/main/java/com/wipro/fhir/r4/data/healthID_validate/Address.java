package com.wipro.fhir.r4.data.healthID_validate;

public class Address {
	String Line;
	String District;
	String State;
	String PinCode;
    public String getLine() {
		return Line;
	}
	public void setLine(String line) {
		Line = line;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getPinCode() {
		return PinCode;
	}
	public void setPinCode(String pinCode) {
		PinCode = pinCode;
	}
	
}
