package com.wipro.fhir.data.healthID;

public class ConfirmAadhaarBio {

	String txnId;
	String pid;
	String bioType;
	String authType;
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getBioType() {
		return bioType;
	}
	public void setBioType(String bioType) {
		this.bioType = bioType;
	}
	public String getAuthType() {
		return authType;
	}
	public void setAuthType(String authType) {
		this.authType = authType;
	}
	
}
