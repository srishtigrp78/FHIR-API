package com.wipro.fhir.r4.repo.patient_data_handler;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.fhir.r4.data.patient_data_handler.TRG_PatientResourceData;

@Repository
@RestResource(exported = false)
public interface TRG_PatientResourceData_Repo extends CrudRepository<TRG_PatientResourceData, Long> {

	@Query(nativeQuery = true, value = " SELECT * FROM db_identity.trg_patientresourcedata "
			+ " WHERE beneficiaryID is not null AND (processed is null OR processed is false ) ORDER BY createdDate LIMIT 20")
	List<TRG_PatientResourceData> getByProcessedOrderByCreatedDateLimit20();

	@Query(nativeQuery = true, value = " SELECT * FROM db_identity.trg_patientresourcedata "
			+ " WHERE beneficiaryID  =:benId  AND (processed is null OR processed is false) ORDER BY id desc LIMIT 1")
	List<TRG_PatientResourceData> getByBenIdLatestRecord(@Param("benId") Long benId);

	@Transactional
	@Modifying
	@Query(" UPDATE TRG_PatientResourceData SET processed = true WHERE id IN :ids ")
	int updateProcessedFlagForProfileCreated(@Param("ids") List<Long> ids);
}
