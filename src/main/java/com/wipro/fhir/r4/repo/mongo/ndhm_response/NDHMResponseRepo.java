package com.wipro.fhir.r4.repo.mongo.ndhm_response;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.wipro.fhir.r4.data.mongo.care_context.NDHMResponse;
import com.wipro.fhir.r4.repo.mongo.amrit_resource.AMRIT_ResourceMongoRepo;

@Repository
@RestResource(exported = false)
public interface NDHMResponseRepo extends MongoRepository<NDHMResponse, String>{

	public NDHMResponse findByRequestID(String id);

}
