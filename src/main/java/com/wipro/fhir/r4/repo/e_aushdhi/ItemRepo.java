package com.wipro.fhir.r4.repo.e_aushdhi;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.wipro.fhir.r4.data.e_aushdhi.ItemMaster;


@Repository
@RestResource(exported = false)
public interface ItemRepo extends CrudRepository<ItemMaster, Integer> {
	
	@Query("SELECT f FROM ItemMaster f WHERE f.itemName = :drugname AND f.providerServiceMapID = :providerServiceMapID AND itemCode = :brandid AND deleted=0")
     public ItemMaster checkItemExists(@Param("drugname") String drugname, @Param("providerServiceMapID") Integer providerServiceMapID, @Param("brandid") String brandid);
	

	
	@Query(value = "select * from m_item f "
			+ "join m_itemfacilitymapping g on f.itemID=g.itemID "
			+ "where g.facilityID=:mainFacilityID and f.itemName=:drugname "
			+ " and f.itemCode=:brandid and f.deleted=0 and g.deleted=0 ", nativeQuery = true)
	public ItemMaster checkItemExistForMainFacility(@Param("mainFacilityID") Integer mainFacilityID, @Param("drugname") String drugname, @Param("brandid") String brandid);
//	

}
