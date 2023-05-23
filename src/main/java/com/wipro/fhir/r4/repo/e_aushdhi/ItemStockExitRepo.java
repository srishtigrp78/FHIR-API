package com.wipro.fhir.r4.repo.e_aushdhi;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.wipro.fhir.r4.data.e_aushdhi.ItemStockExit;

@Repository
@RestResource(exported = false)
public interface ItemStockExitRepo extends CrudRepository<ItemStockExit, Long> {
	
	@Query("SELECT f FROM ItemStockExit f WHERE f.exitTypeID = :patientIssueID AND f.itemStockEntryID = :itemStockEntryID AND deleted=0")
	public ItemStockExit getItemExitDetails(@Param("patientIssueID") Long patientIssueID, @Param("itemStockEntryID") Integer itemStockEntryID);

}
