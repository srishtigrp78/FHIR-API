package com.wipro.fhir.r4.data.healthID;

import lombok.Data;

public class MobileOTP {
	
	String mobile;
	String txnId;
	
	public String getMobileNumber() {
		return mobile;
	}
	public void setMobileNumber(String mobile) {
		this.mobile = mobile;
	}
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

}
