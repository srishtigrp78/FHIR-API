package com.wipro.fhir.r4.repo.mongo.amrit_resource;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.wipro.fhir.r4.data.mongo.amrit_resource.AMRIT_ResourceMongo;

/***
 * 
 * @author NE298657
 *
 */
@Repository
@RestResource(exported = false)
public interface AMRIT_ResourceMongoRepo extends MongoRepository<AMRIT_ResourceMongo, String> {

}
