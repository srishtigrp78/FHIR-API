package com.wipro.fhir.r4.repo.e_aushdhi;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.fhir.r4.data.e_aushdhi.ItemStockEntry;

@Repository
@RestResource(exported = false)
public interface ItemStockEntryRepo extends CrudRepository<ItemStockEntry, Integer> {

	@Query("SELECT f FROM ItemStockEntry f WHERE f.facilityID = :amritFacilityID AND f.itemID = :itemId AND f.batchNo = :batchno AND deleted=0")
	public ItemStockEntry checkItemEntryExits(@Param("amritFacilityID") Integer amritFacilityID,
			@Param("itemId") Integer itemId, @Param("batchno") String batchno);

//	@Transactional
//	@Modifying
//	@Query("update ItemStockEntry set quantity=:inhandqty, "
//			+ " quantityInHand=:inhandqty, expiryDate=:expDate where "
//			+ "itemStockEntryID=:itemStockEntryID")
//	public int updateItemEntryDetails(@Param("itemStockEntryID") Long itemStockEntryID,
//			@Param("inhandqty") Integer inhandqty, @Param("expDate") Date expDate);

	@Transactional
	@Modifying
	@Query("update ItemStockEntry set " + " quantityInHand=:inhandqty, expiryDate=:expDate where "
			+ "itemStockEntryID=:itemStockEntryID")
	public int updateItemEntryDetails(@Param("itemStockEntryID") Long itemStockEntryID,
			@Param("inhandqty") Integer inhandqty, @Param("expDate") Date expDate);

	@Transactional
	@Modifying
	@Query("update ItemStockEntry set vanSerialNo=:itemStockEntryID where " + "itemStockEntryID=:itemStockEntryID")
	public int updateVanSerialNo(@Param("itemStockEntryID") Long itemStockEntryID);
}
