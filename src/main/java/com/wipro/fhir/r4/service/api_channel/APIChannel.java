package com.wipro.fhir.r4.service.api_channel;

import com.wipro.fhir.r4.data.request_handler.ResourceRequestHandler;
import com.wipro.fhir.r4.utils.exception.FHIRException;

/***
 * 
 * @author NE298657
 *
 */
public interface APIChannel {

	public String benSearchByBenID(String Authorization, ResourceRequestHandler patientResourceRequest)
			throws FHIRException;

	public String userAuthentication() throws FHIRException;

}
