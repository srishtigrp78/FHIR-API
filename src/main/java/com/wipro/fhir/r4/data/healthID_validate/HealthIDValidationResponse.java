package com.wipro.fhir.r4.data.healthID_validate;

public class HealthIDValidationResponse {
	
  String RequestId;
  String Timestamp;
  AuthNDHM Auth;
public String getRequestId() {
	return RequestId;
}
public void setRequestId(String requestId) {
	RequestId = requestId;
}
public String getTimestamp() {
	return Timestamp;
}
public void setTimestamp(String timestamp) {
	Timestamp = timestamp;
}
public AuthNDHM getAuth() {
	return Auth;
}
public void setAuth(AuthNDHM auth) {
	Auth = auth;
}
}
