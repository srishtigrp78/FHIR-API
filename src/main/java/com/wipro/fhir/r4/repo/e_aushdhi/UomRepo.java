package com.wipro.fhir.r4.repo.e_aushdhi;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.wipro.fhir.r4.data.e_aushdhi.M_ItemForm;
import com.wipro.fhir.r4.data.e_aushdhi.M_Uom;

@Repository
@RestResource(exported = false)
public interface UomRepo extends CrudRepository<M_Uom, Integer> {
	
	@Query("SELECT f FROM M_Uom f WHERE f.uOMName = :uomName AND f.providerServiceMapID = :providerServiceMapID AND deleted=0")
    public M_Uom getUOMID(@Param("uomName") String uomName, @Param("providerServiceMapID") Integer providerServiceMapID);

}
