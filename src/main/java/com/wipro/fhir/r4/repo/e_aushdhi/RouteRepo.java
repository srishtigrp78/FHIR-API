package com.wipro.fhir.r4.repo.e_aushdhi;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.wipro.fhir.r4.data.e_aushdhi.M_Route;


@Repository
@RestResource(exported = false)
public interface RouteRepo extends CrudRepository<M_Route, Integer> {

	@Query("SELECT f FROM M_Route f WHERE f.routeName = :routeName AND deleted=0")
    public M_Route getItemRouteID(@Param("routeName") String routeName);
}
