package com.wipro.fhir.r4.data.mongo.care_context;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.google.gson.annotations.Expose;

@Document(collection = "NDHMResponses")
public class NDHMResponse {
	@Id
	@Expose
	@Field(value = "id")
	private String id;
	
	@Expose
	@Field(value = "requestid")
	private String requestID;

	@Expose
	@Field(value = "responsedata")
	private String responseData;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRequestID() {
		return requestID;
	}

	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}

	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}
	
}
