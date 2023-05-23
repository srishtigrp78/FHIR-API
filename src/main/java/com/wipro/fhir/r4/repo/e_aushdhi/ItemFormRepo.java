package com.wipro.fhir.r4.repo.e_aushdhi;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.wipro.fhir.r4.data.e_aushdhi.M_ItemForm;


@Repository
@RestResource(exported = false)
public interface ItemFormRepo extends CrudRepository<M_ItemForm, Integer> {
	
	@Query("SELECT f FROM M_ItemForm f WHERE f.itemForm = :itemtypename AND deleted=0")
    public M_ItemForm getItemFormID(@Param("itemtypename") String itemtypename);

}
