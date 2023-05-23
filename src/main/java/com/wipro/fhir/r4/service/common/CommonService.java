package com.wipro.fhir.r4.service.common;

import java.util.List;

import org.springframework.data.domain.Page;

import com.wipro.fhir.r4.data.mongo.amrit_resource.AMRIT_ResourceMongo;
import com.wipro.fhir.r4.data.mongo.amrit_resource.TempCollection;
import com.wipro.fhir.r4.data.mongo.care_context.NDHMRequest;
import com.wipro.fhir.r4.data.patient_data_handler.PatientDemographicModel_NDHM_Patient_Profile;
import com.wipro.fhir.r4.data.request_handler.PatientEligibleForResourceCreation;
import com.wipro.fhir.r4.data.request_handler.ResourceRequestHandler;
import com.wipro.fhir.r4.utils.exception.FHIRException;

public interface CommonService {

	public List<PatientEligibleForResourceCreation> getPatientListForResourceEligible() throws FHIRException;

	public String getAuthKey() throws FHIRException;

	public int saveResourceToMongo(AMRIT_ResourceMongo aMRIT_Resource) throws FHIRException;

	public String processResourceOperation() throws FHIRException;

	public String getUUID();

	public String ndhmUserAuthenticate() throws FHIRException;

	public int saveTempResourceToMongo(TempCollection tempCollection) throws FHIRException;

	public List<TempCollection> fetchTempResourceFromMongo(ResourceRequestHandler resourceRequestHandler)
			throws FHIRException;

	public NDHMRequest getRequestIDAndTimeStamp();

	public String getMongoNDHMResponse(String requestID) throws FHIRException;

	// Bahmni
	public List<PatientDemographicModel_NDHM_Patient_Profile> savePatientProfileDataToMongo(
			List<PatientDemographicModel_NDHM_Patient_Profile> patientProfile_list) throws FHIRException;

	// patient profile creation processing
	public String processPatientProfileCreationAMRIT() throws FHIRException;

	public Page<PatientDemographicModel_NDHM_Patient_Profile> searchPatientProfileFromMongo(
			ResourceRequestHandler resourceRequestHandler) throws FHIRException;

}
