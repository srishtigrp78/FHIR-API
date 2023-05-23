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
