package com.wipro.fhir.r4.repo.mongo.amrit_resource;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.wipro.fhir.r4.data.mongo.care_context.PatientCareContexts;

@Repository
@RestResource(exported = false)
public interface PatientCareContextsMongoRepo extends MongoRepository<PatientCareContexts, String> {
	public PatientCareContexts findByIdentifier(String benID);
}
