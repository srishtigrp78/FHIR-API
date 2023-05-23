package com.wipro.fhir.r4.repo.atoms.feed.bahmni.patient;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.wipro.fhir.r4.data.atoms.feed.bahmni.patient.FeedDataLog;

@Repository
@RestResource(exported = false)
public interface FeedDataLogRepo extends MongoRepository<FeedDataLog, String> {

	FeedDataLog findOneByEntrySuccessOrderByIdDesc(Boolean b);

	// @Query("{'_id':-1}")
}
