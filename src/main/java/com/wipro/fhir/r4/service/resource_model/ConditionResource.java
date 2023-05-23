package com.wipro.fhir.r4.service.resource_model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.fhir.r4.data.request_handler.ResourceRequestHandler;
import com.wipro.fhir.r4.data.resource_model.ConditionChiefComplaintsDataModel;
import com.wipro.fhir.r4.data.resource_model.ConditionDiagnosisDataModel;
import com.wipro.fhir.r4.repo.common.PatientEligibleForResourceCreationRepo;
import com.wipro.fhir.r4.service.common.CommonService;

/***
 * 
 * @author NE298657
 *
 */

@Service
public class ConditionResource {
	@Autowired
	private CommonService commonService;

	@Autowired
	private PatientEligibleForResourceCreationRepo patientEligibleForResourceCreationRepo;
	@Autowired
	private ConditionDiagnosisDataModel conditionDataModel;
	@Autowired
	private ConditionChiefComplaintsDataModel conditionChiefComplaintsDataModel;

	private String UUID;
	private Condition condition;

	/***
	 * 
	 * @param patient
	 * @param resourceRequestHandler
	 * @param conditionType          - chiefcomplaints, diagnosis
	 * @return
	 */
	public List<Condition> getCondition(Patient patient, ResourceRequestHandler resourceRequestHandler,
			String conditionType) {

		List<Object[]> rsObjListDiagnosis = patientEligibleForResourceCreationRepo
				.callConditionSP(resourceRequestHandler.getBeneficiaryRegID(), resourceRequestHandler.getVisitCode());

		if (conditionType != null && conditionType.equalsIgnoreCase("chiefcomplaints")) {
			List<Object[]> chiefComplaints = patientEligibleForResourceCreationRepo.callChiefComplaintsConditionSP(
					resourceRequestHandler.getBeneficiaryRegID(), resourceRequestHandler.getVisitCode());
			List<ConditionChiefComplaintsDataModel> conditionChiefComplaintsList = conditionChiefComplaintsDataModel
					.getConditionChiefComplaintList(chiefComplaints);

			return generateConditionResource_ChiefComplaints(patient, conditionChiefComplaintsList);

		} else if (conditionType != null && conditionType.equalsIgnoreCase("diagnosis")) {
			List<Object[]> diagnosisList = patientEligibleForResourceCreationRepo.callConditionSP(
					resourceRequestHandler.getBeneficiaryRegID(), resourceRequestHandler.getVisitCode());
			List<ConditionDiagnosisDataModel> conditionDiagnosisList = conditionDataModel
					.getConditionList(diagnosisList);

			return generateConditionResource_EncounterDiagnosis(patient, conditionDiagnosisList);

		}
		return null;

	}

	private List<Condition> generateConditionResource_ChiefComplaints(Patient patient,
			List<ConditionChiefComplaintsDataModel> conditionChiefComplaintsList) {

		List<Condition> conditionResourceList = new ArrayList<>();

		CodeableConcept ccClinicalStatus;
		Coding cClinicalStatus;

		CodeableConcept ccCategory;
		Coding cCategory;
		List<CodeableConcept> ccCategoryList;

		CodeableConcept ccCode;
		Coding cCode;

		for (ConditionChiefComplaintsDataModel chiefComplaint : conditionChiefComplaintsList) {
			condition = new Condition();
			condition.setId("Condition/" + commonService.getUUID());
			condition.setRecordedDate(new Time(chiefComplaint.getCreatedDate().getTime()));

			// condition-clinical-status
			ccClinicalStatus = new CodeableConcept();
			cClinicalStatus = new Coding();
			cClinicalStatus.setSystem("http://terminology.hl7.org/CodeSystem/condition-clinical");
			cClinicalStatus.setCode("active");
			cClinicalStatus.setDisplay("Active");
			ccClinicalStatus.addCoding(cClinicalStatus);
			condition.setClinicalStatus(ccClinicalStatus);

			// condition-category
			ccCategory = new CodeableConcept();
			cCategory = new Coding();
			cCategory.setSystem("http://terminology.hl7.org/CodeSystem/condition-category");
			cCategory.setCode("problem-list-item");
			cCategory.setDisplay("Problem List Item");
			ccCategory.addCoding(cCategory);
			ccCategory.setText("Problem List Item");
			ccCategoryList = new ArrayList<>();
			ccCategoryList.add(ccCategory);
			condition.setCategory(ccCategoryList);

			// chief complaints code
			ccCode = new CodeableConcept();
			cCode = new Coding();
			if (chiefComplaint.getSCTCode() != null) {
				cCode.setSystem("http://snomed.info/sct");
				cCode.setCode(chiefComplaint.getSCTCode());
			}
			cCode.setDisplay(chiefComplaint.getChiefComplaint());

			ccCode.setText(chiefComplaint.getChiefComplaint());
			ccCode.addCoding(cCode);
			condition.setCode(ccCode);

			// referance - patient
			condition.setSubject(new Reference(patient.getIdElement().getValue()));
			conditionResourceList.add(condition);
		}

		return conditionResourceList;
	}

	private List<Condition> generateConditionResource_EncounterDiagnosis(Patient patient,
			List<ConditionDiagnosisDataModel> conditionList) {

		List<Condition> conditionResourceList = new ArrayList<>();

		CodeableConcept ccClinicalStatus;
		Coding cClinicalStatus;

		CodeableConcept ccCategory;
		Coding cCategory;
		List<CodeableConcept> ccCategoryList;

		CodeableConcept ccCode;
		Coding cCode;

		for (ConditionDiagnosisDataModel diagnosis : conditionList) {
			condition = new Condition();
			condition.setId("Condition/" + commonService.getUUID());
			condition.setRecordedDate(new Time(diagnosis.getCreatedDate().getTime()));

			// condition-clinical-status
			ccClinicalStatus = new CodeableConcept();
			cClinicalStatus = new Coding();
			cClinicalStatus.setSystem("http://terminology.hl7.org/CodeSystem/condition-clinical");
			cClinicalStatus.setCode("active");
			cClinicalStatus.setDisplay("Active");
			ccClinicalStatus.addCoding(cClinicalStatus);
			condition.setClinicalStatus(ccClinicalStatus);

			// condition-category
			ccCategory = new CodeableConcept();
			cCategory = new Coding();
			cCategory.setSystem("http://terminology.hl7.org/CodeSystem/condition-category");
			cCategory.setCode("encounter-diagnosis");
			cCategory.setDisplay("Encounter Diagnosis");
			ccCategory.addCoding(cCategory);
			ccCategory.setText("Encounter Diagnosis");
			ccCategoryList = new ArrayList<>();
			ccCategoryList.add(ccCategory);
			condition.setCategory(ccCategoryList);

			// chief complaints code
			ccCode = new CodeableConcept();
			cCode = new Coding();
			if (diagnosis.getSctcode() != null) {
				cCode.setSystem("http://snomed.info/sct");
				cCode.setCode(diagnosis.getSctcode());
			}
			if (diagnosis.getSctTerm() != null) {
				cCode.setDisplay(diagnosis.getSctTerm());
				ccCode.setText(diagnosis.getSctTerm());
			}

			ccCode.addCoding(cCode);

			condition.setCode(ccCode);

			// referance - patient
			condition.setSubject(new Reference(patient.getIdElement().getValue()));
			conditionResourceList.add(condition);
		}

		return conditionResourceList;
	}

}
