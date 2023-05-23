package com.wipro.fhir.r4.service.patient_data_handler;

import java.util.List;

import com.wipro.fhir.r4.data.patient_data_handler.PatientDemographicModel_NDHM_Patient_Profile;
import com.wipro.fhir.r4.data.request_handler.ResourceRequestHandler;
import com.wipro.fhir.r4.utils.exception.FHIRException;

public interface PatientDataGatewayService {
	public List<PatientDemographicModel_NDHM_Patient_Profile> feedPatientProfileToMongoDB(
			List<PatientDemographicModel_NDHM_Patient_Profile> ndhm_Patient_Profile_List) throws FHIRException;

	public String generatePatientProfileAMRIT_SaveTo_Mongo(String Authorization) throws FHIRException;

	public String generatePatientProfileAMRIT_SaveTo_Mongo(String Authorization,
			ResourceRequestHandler resourceRequestHandler) throws FHIRException;

	public String searchPatientProfileMongo(String Authorization, ResourceRequestHandler resourceRequestHandler)
			throws FHIRException;

	public String searchPatientProfileMongoPagination(Integer pageNo) throws FHIRException;
}
