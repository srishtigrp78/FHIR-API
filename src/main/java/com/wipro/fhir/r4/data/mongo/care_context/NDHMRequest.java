package com.wipro.fhir.r4.data.mongo.care_context;

public class NDHMRequest {
	String requestId;
	String timestamp;
	Query query;
	AddCareContext link;
	String transactionId;
	Credential credential;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	public AddCareContext getLink() {
		return link;
	}

	public void setLink(AddCareContext link) {
		this.link = link;
	}
}
