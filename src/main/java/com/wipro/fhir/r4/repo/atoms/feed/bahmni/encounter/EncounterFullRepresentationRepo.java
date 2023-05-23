package com.wipro.fhir.r4.repo.atoms.feed.bahmni.encounter;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.wipro.fhir.r4.data.atoms.feed.bahmni.encounter.EncounterFullRepresentation;

@Repository
@RestResource(exported = false)
public interface EncounterFullRepresentationRepo extends MongoRepository<EncounterFullRepresentation, String> {
	List<EncounterFullRepresentation> findByPatientId(String externalId);

	List<EncounterFullRepresentation> findByPatientIdOrderByVisitUuid(String externalId);
}
