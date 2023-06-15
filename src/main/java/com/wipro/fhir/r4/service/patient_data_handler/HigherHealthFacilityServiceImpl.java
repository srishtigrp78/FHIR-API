/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.wipro.fhir.r4.service.patient_data_handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.wipro.fhir.r4.data.atoms.feed.bahmni.encounter.EncounterFullRepresentation;
import com.wipro.fhir.r4.data.atoms.feed.bahmni.encounter.GroupMembers;
import com.wipro.fhir.r4.data.atoms.feed.bahmni.encounter.Observations;
import com.wipro.fhir.r4.data.atoms.feed.bahmni.encounter.VisitWiseEncounterData;
import com.wipro.fhir.r4.data.patient_data_handler.PatientDemographicModel_NDHM_Patient_Profile;
import com.wipro.fhir.r4.data.request_handler.ResourceRequestHandler;
import com.wipro.fhir.r4.repo.atoms.feed.bahmni.encounter.EncounterFullRepresentationRepo;
import com.wipro.fhir.r4.repo.patient_data_handler.PatientDemographicModel_NDHM_Patient_Profile_Repo;
import com.wipro.fhir.r4.utils.exception.FHIRException;

@Service
public class HigherHealthFacilityServiceImpl {
	@Autowired
	private PatientDemographicModel_NDHM_Patient_Profile_Repo patientProfileRepo;
	@Autowired
	private EncounterFullRepresentationRepo encounterFullRepresentationRepo;

	public String updateBengenIDToHigherHealthFacilityBeneficiary(ResourceRequestHandler reqObj) throws FHIRException {
		List<PatientDemographicModel_NDHM_Patient_Profile> resultSet = patientProfileRepo
				.findByExternalId(reqObj.getExternalId());

		HashMap<String, String> identifier;
		for (PatientDemographicModel_NDHM_Patient_Profile obj : resultSet) {
			identifier = new HashMap<>();
			identifier.put("amritId", reqObj.getAmritId());
			obj.setAmritId(reqObj.getAmritId());
			obj.getProfile().getPatient().getIdentifiers().add(identifier);
		}
		patientProfileRepo.save(resultSet);
		return "Beneficiary ID updated successfully";
	}

	public String getCLinicalDataHigherhealthFacility(ResourceRequestHandler reqObj) throws FHIRException {
		List<EncounterFullRepresentation> resultList = new ArrayList<EncounterFullRepresentation>();
		List<VisitWiseEncounterData> visitList = new ArrayList<>();

		List<PatientDemographicModel_NDHM_Patient_Profile> resultSet = patientProfileRepo
				.findByAmritId(reqObj.getAmritId());
		// List<EncounterFullRepresentation> result = new
		// ArrayList<EncounterFullRepresentation>();
		if (resultSet != null && resultSet.size() > 0) {
			String externalID = resultSet.get(0).getExternalId();
			resultList = encounterFullRepresentationRepo.findByPatientId(externalID);
			// String visitID = null;
			if (resultList != null && resultList.size() > 0) {

				visitList = getVisitWiseEncounterData(resultList);
//				for (EncounterFullRepresentation obj : resultList) {
//					visitID = obj.getVisitUuid();
//					if (!checkIfVisitExist(result, visitID))
//						result = getDetailsByVisitId(resultList, visitID, result);
//				}
			}
//			resultList = mapEncounterData(resultList);
		}
		return new Gson().toJson(visitList);
	}

	//// ------------------------------------------------------------------

	// List<VisitWiseEncounterData> visitList = new
	// ArrayList<VisitWiseEncounterData>();

	VisitWiseEncounterData visitWiseEncounterData;
	List<GroupMembers> grpMembersFinalReg;
	List<GroupMembers> grpMembersFinalCon;

	public List<VisitWiseEncounterData> getVisitWiseEncounterData(List<EncounterFullRepresentation> resultList) {
		Map<String, VisitWiseEncounterData> visitUUIDMap = new HashMap<>();
		List<VisitWiseEncounterData> visitList = new ArrayList<VisitWiseEncounterData>();
		Map<String, String> checkProcessedEncounter = new HashMap<>();

		for (EncounterFullRepresentation obj : resultList) {
			if (!checkProcessedEncounter.containsKey(obj.getVisitUuid() + obj.getEncounterType())) {

				grpMembersFinalReg = null;
				grpMembersFinalCon = null;
				if (obj.getVisitUuid() != null && !visitUUIDMap.containsKey(obj.getVisitUuid())) {
					visitWiseEncounterData = new VisitWiseEncounterData();
					grpMembersFinalReg = new ArrayList<>();
					grpMembersFinalCon = new ArrayList<>();

					visitWiseEncounterData.setVisitUuid(obj.getVisitUuid());
					if (obj.getEncounterDateTime() != null)
						visitWiseEncounterData.setEncounterDateTime(obj.getEncounterDateTime());
					if (obj.getVisitType() != null)
						visitWiseEncounterData.setVisitType(obj.getVisitType());
					if (obj.getVisitTypeUuid() != null)
						visitWiseEncounterData.setVisitTypeUuid(obj.getVisitTypeUuid());
					if (obj.getPatientId() != null)
						visitWiseEncounterData.setPatientId(obj.getPatientId());

				} else {
					if (obj.getVisitUuid() != null) {
						visitWiseEncounterData = visitUUIDMap.get(obj.getVisitUuid());
						grpMembersFinalReg = visitWiseEncounterData.getObservationsGMReg();
						grpMembersFinalCon = visitWiseEncounterData.getObservationsGMConsultation();
					}
				}

				if (obj.getEncounterType().equalsIgnoreCase("consultation") && visitWiseEncounterData != null) {
					if (visitWiseEncounterData.getBahmniDiagnoses() == null && obj.getBahmniDiagnoses() != null)
						visitWiseEncounterData.setBahmniDiagnoses(obj.getBahmniDiagnoses());
					if (visitWiseEncounterData.getDrugOrders() == null && obj.getDrugOrders() != null)
						visitWiseEncounterData.setDrugOrders(obj.getDrugOrders());
				}

				if (obj.getObservations() != null && obj.getObservations().size() > 0) {
					for (Observations o : obj.getObservations()) {
						finalfamilymember = new ArrayList<>();
						List<GroupMembers> grpMembers = getSerializedGroupMembersNew(o.getGroupMembers());
						if (grpMembers != null && grpMembers.size() > 0) {
							if (obj.getEncounterType().equalsIgnoreCase("consultation") && grpMembersFinalCon != null) {
								grpMembersFinalCon.addAll(grpMembers);
								visitWiseEncounterData.setObservationsGMConsultation(grpMembersFinalCon);
							} else if (obj.getEncounterType().equalsIgnoreCase("reg") && grpMembersFinalReg != null) {
								grpMembersFinalReg.addAll(grpMembers);
								visitWiseEncounterData.setObservationsGMReg(grpMembersFinalReg);
							}
						}
					}
				}

				visitUUIDMap.put(obj.getVisitUuid(), visitWiseEncounterData);
				checkProcessedEncounter.put(obj.getVisitUuid() + obj.getEncounterType(), "true");
			}
		}
		visitUUIDMap.forEach((k, v) -> visitList.add(v));
		return visitList;
	}

	/// ---------------------------------------------------------------------------------------------------

	@Deprecated
	private boolean checkIfVisitExist(List<EncounterFullRepresentation> resultList, String visitID) {
		for (EncounterFullRepresentation obj : resultList) {
			if (visitID.equalsIgnoreCase(obj.getVisitUuid())) {
				return true;
			}
		}
		return false;
	}

//	@Deprecated
//	private List<EncounterFullRepresentation> getDetailsByVisitId(List<EncounterFullRepresentation> resultList,
//			String visitID, List<EncounterFullRepresentation> result) {
//		EncounterFullRepresentation obj1 = null;
//		List<Observations> consultationObs = new ArrayList<Observations>();
//		for (EncounterFullRepresentation obj : resultList) {
//			if (visitID.equalsIgnoreCase(obj.getVisitUuid()) && obj.getEncounterType().equalsIgnoreCase("reg")) {
//				if (obj1 == null)
//					obj1 = obj;
//				if (obj.getObservations() != null && obj.getObservations().size() > 0) {
//					for (Observations obs : obj.getObservations()) {
//						if (obs.getGroupMembers() != null && obs.getGroupMembers().size() > 0) {
//							List<GroupMembers> group = getSerializedGroupMembers(obs.getGroupMembers());
//							obs.setRegistrationGroupMembers(group);
//							finalfamilymember = new ArrayList<GroupMembers>();
//							prevFamilyMember = null;
//						}
//					}
//					obj1.setObservationsReg(obj.getObservations());
//				}
//			} else if (visitID.equalsIgnoreCase(obj.getVisitUuid())
//					&& obj.getEncounterType().equalsIgnoreCase("consultation")) {
//				if (obj1 == null)
//					obj1 = obj;
//				if (obj.getObservations() != null && obj.getObservations().size() > 0) {
//					for (Observations obs : obj.getObservations()) {
//						if (obs.getGroupMembers() != null && obs.getGroupMembers().size() > 0) {
//							List<GroupMembers> consultationgroup = getSerializedGroupMembers(obs.getGroupMembers());
//							obs.setConsultationGroupMembers(consultationgroup);
//							finalfamilymember = new ArrayList<GroupMembers>();
//							prevFamilyMember = null;
//						}
//						consultationObs = obj.getObservations();
//					}
//				}
//			}
//		}
//		if (obj1 != null && consultationObs != null) {
//			obj1.setObservationsConsultation(consultationObs);
//			result.add(obj1);
//		}
//		return result;
//	}

//	private List<EncounterFullRepresentation> mapEncounterData(List<EncounterFullRepresentation> resultList) {
//		// TODO Auto-generated method stub
//		if (resultList != null && resultList.size() > 0) {
//			for (EncounterFullRepresentation obj : resultList) {
//				if (obj.getObservations() != null && obj.getObservations().size() > 0) {
//					for (Observations obs : obj.getObservations()) {
//						if (obs.getGroupMembers() != null && obs.getGroupMembers().size() > 0) {
//							List<GroupMembers> group = getSerializedGroupMembers(obs.getGroupMembers());
//							obs.setFinalGroupMembers(group);
//							finalfamilymember = new ArrayList<GroupMembers>();
//							prevFamilyMember = null;
//						}
//					}
//				}
//			}
//		}
//		return resultList;
//	}

//	@Deprecated
//	private List<GroupMembers> getSerializedGroupMembers(List<GroupMembers> groupMembers) {
//		// TODO Auto-generated method stub
//		List<GroupMembers> temp = groupMembers;
//		prevFamilyMember = groupMembers;
//		for (int i = 0; i < groupMembers.size(); i++) {
//			temp = groupMembers.get(i).getGroupMembers();
//
//			if (temp != null && temp.size() > 0) {
//				temp = getSerializedGroupMembers(temp);
//				prevFamilyMember = temp;
//			} else {
//				if (prevFamilyMember.get(i) != null) {
//					prevFamilyMember.get(i).setGroupMembers(null);
//					finalfamilymember.add(prevFamilyMember.get(i));
//				}
//			}
//		}
//		return finalfamilymember;
//	}

	List<GroupMembers> finalfamilymember = new ArrayList<GroupMembers>();
	// List<GroupMembers> prevFamilyMember;

	private List<GroupMembers> getSerializedGroupMembersNew(List<GroupMembers> groupMembers) {
		// TODO Auto-generated method stub
		for (GroupMembers gm : groupMembers) {
			if (gm.getGroupMembers() == null || gm.getGroupMembers().size() == 0) {
				finalfamilymember.add(gm);
			} else {
				getSerializedGroupMembersNew(gm.getGroupMembers());
			}
		}
		return finalfamilymember;
	}
}
