package com.wipro.fhir.r4.repo.e_aushdhi;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.wipro.fhir.r4.data.e_aushdhi.M_Van;




@Repository
@RestResource(exported = false)
public interface VanMasterRepo extends CrudRepository<M_Van, Integer>{
	
	@Query("SELECT f.vanID FROM M_Van f WHERE f.facilityID = :facilityID AND deleted=0")
	public Integer getvanID(@Param("facilityID") Integer facilityID);

}
