package com.wipro.fhir.r4.service.ndhm;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.wipro.fhir.r4.data.mongo.care_context.NDHMRequest;
import com.wipro.fhir.r4.utils.exception.FHIRException;

public interface Common_NDHMService {
	public HttpHeaders getHeaders(String ndhmAuthToken);
	public HttpHeaders getHeaders(String ndhmAuthToken,String sbx);
	public NDHMRequest getRequestIDAndTimeStamp();
	public String getMongoNDHMResponse(String requestID) throws FHIRException ;
	public String getBody(ResponseEntity<String> res) throws FHIRException;
	public String getStatusCode(ResponseEntity<String> res) throws FHIRException;
	public HttpHeaders getHeadersWithXtoken(String ndhmAuthToken,String X_Token);
}
