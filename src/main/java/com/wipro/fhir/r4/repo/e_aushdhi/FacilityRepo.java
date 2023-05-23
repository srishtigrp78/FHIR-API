package com.wipro.fhir.r4.repo.e_aushdhi;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.wipro.fhir.r4.data.e_aushdhi.M_Facility;


@Repository
@RestResource(exported = false)
public interface FacilityRepo extends CrudRepository<M_Facility, Integer>{
	
	
	@Query("SELECT f FROM M_Facility f WHERE f.eAushadhiFacilityId = :eAushadhiFacilityId AND deleted=0")
	public M_Facility getAmritFacilityID(@Param("eAushadhiFacilityId") Integer eAushadhiFacilityId);
	
	@Query("SELECT f FROM M_Facility f WHERE f.facilityID = :facilityID AND deleted=0")
	public M_Facility geteAushadhiFacilityID(@Param("facilityID") Integer facilityID);
	
	
	@Query("SELECT f FROM M_Facility f WHERE f.eAushadhiFacilityId IS NOT NULL AND deleted=0")
	public ArrayList<M_Facility> getFacilityDetails();

}
