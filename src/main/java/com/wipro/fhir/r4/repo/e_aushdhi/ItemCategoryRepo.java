package com.wipro.fhir.r4.repo.e_aushdhi;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.wipro.fhir.r4.data.e_aushdhi.M_ItemCategory;



@Repository
@RestResource(exported = false)
public interface ItemCategoryRepo extends CrudRepository<M_ItemCategory, Integer> {
	
	@Query("SELECT f FROM M_ItemCategory f WHERE f.itemCategoryName = :itemCategoryName AND f.providerServiceMapID = :providerServiceMapID AND deleted=0")
    public M_ItemCategory getItemCategoryID(@Param("itemCategoryName") String itemCategoryName, @Param("providerServiceMapID") Integer providerServiceMapID);

}
