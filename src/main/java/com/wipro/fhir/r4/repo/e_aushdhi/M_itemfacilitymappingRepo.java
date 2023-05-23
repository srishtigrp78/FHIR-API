package com.wipro.fhir.r4.repo.e_aushdhi;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.wipro.fhir.r4.data.e_aushdhi.M_itemfacilitymapping;


@Repository
@RestResource(exported = false)
public interface M_itemfacilitymappingRepo extends CrudRepository<M_itemfacilitymapping, Integer>{
	

	@Query("SELECT f FROM M_itemfacilitymapping f WHERE f.itemID = :itemID AND f.facilityID = :facilityID AND f.providerServiceMapID = :providerServiceMapID AND deleted=0")
	public M_itemfacilitymapping checkItemFacilityMapping(@Param("itemID") Integer itemID, @Param("facilityID") Integer facilityID, @Param("providerServiceMapID") Integer providerServiceMapID);
}
