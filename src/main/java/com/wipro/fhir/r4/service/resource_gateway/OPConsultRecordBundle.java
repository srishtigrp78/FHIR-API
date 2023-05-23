package com.wipro.fhir.r4.service.resource_gateway;

import com.wipro.fhir.r4.data.request_handler.PatientEligibleForResourceCreation;
import com.wipro.fhir.r4.data.request_handler.ResourceRequestHandler;
import com.wipro.fhir.r4.utils.exception.FHIRException;

/***
 * 
 * @author NE298657
 *
 */

public interface OPConsultRecordBundle {

	public String getOPConsultRecordBundle(ResourceRequestHandler resourceRequestHandler,
			PatientEligibleForResourceCreation p) throws FHIRException;

	public int processOPConsultRecordBundle(ResourceRequestHandler resourceRequestHandler,
			PatientEligibleForResourceCreation p) throws FHIRException;
}
