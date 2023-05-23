package com.wipro.fhir.r4.service.resource_gateway;

import com.wipro.fhir.r4.data.request_handler.PatientEligibleForResourceCreation;
import com.wipro.fhir.r4.data.request_handler.ResourceRequestHandler;
import com.wipro.fhir.r4.utils.exception.FHIRException;

public interface DiagnosticReportRecord {

	public int processDiagnosticReportRecordBundle(ResourceRequestHandler resourceRequestHandler,
			PatientEligibleForResourceCreation p) throws FHIRException;

	public String getDiagnosticReportRecordBundle( ResourceRequestHandler resourceRequestHandler,
			PatientEligibleForResourceCreation p) throws FHIRException;

}
