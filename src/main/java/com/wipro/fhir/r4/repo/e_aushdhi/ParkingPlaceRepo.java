package com.wipro.fhir.r4.repo.e_aushdhi;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.wipro.fhir.r4.data.e_aushdhi.M_Parkingplace;

@Repository
@RestResource(exported = false)
public interface ParkingPlaceRepo extends CrudRepository<M_Parkingplace, Integer> {

	@Query("SELECT f.parkingPlaceID FROM M_Parkingplace f WHERE f.facilityID = :facilityID AND deleted=0")
	public Integer getParkingPlaceID(@Param("facilityID") Integer facilityID);
}
