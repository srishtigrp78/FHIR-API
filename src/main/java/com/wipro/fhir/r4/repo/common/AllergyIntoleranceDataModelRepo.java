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
package com.wipro.fhir.r4.repo.common;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.wipro.fhir.r4.data.resource_model.AllergyIntoleranceDataModel;

@Repository
@RestResource(exported = false)
public interface AllergyIntoleranceDataModelRepo extends CrudRepository<AllergyIntoleranceDataModel, Long> {
//	@Query(nativeQuery = true, value = "CALL db_iemr.FHIR_R_AllergyIntolerance(:beneficiaryRegID_IN, "
//			+ " :visitCode_IN, @0, @1, @2, @3, @4, @5, @6, @7, @8, @9, @10 );")
//	List<AllergyIntoleranceDataModel> allergyIntoleranceSp(@Param("beneficiaryRegID_IN") Long beneficiaryRegID_IN,
//			@Param("visitCode_IN") Long visitCode_IN);

}
