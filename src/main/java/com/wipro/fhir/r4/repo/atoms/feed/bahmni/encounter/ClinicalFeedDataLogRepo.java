package com.wipro.fhir.r4.repo.atoms.feed.bahmni.encounter;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.wipro.fhir.r4.data.atoms.feed.bahmni.encounter.ClinicalFeedDataLog;

@Repository
@RestResource(exported = false)
public interface ClinicalFeedDataLogRepo extends MongoRepository<ClinicalFeedDataLog, String> {
	ClinicalFeedDataLog findOneByEntrySuccessOrderByIdDesc(Boolean b);
}
