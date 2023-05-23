package com.wipro.fhir.r4.repo.e_aushdhi;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.wipro.fhir.r4.data.e_aushdhi.E_AusdhFacilityProcessLog;

@Repository
@RestResource(exported = false)
public interface E_AusdhFacilityProcessLogRepo extends CrudRepository<E_AusdhFacilityProcessLog, Integer> {

	List<E_AusdhFacilityProcessLog> findByAmrithFacilityIdAndEaushadiFacilityId(Integer afId, Integer efId);

	List<E_AusdhFacilityProcessLog> findByAmrithFacilityId(Integer afId);
}
