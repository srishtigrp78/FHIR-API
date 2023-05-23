package com.wipro.fhir.r4.repo.mongo.amrit_resource;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.wipro.fhir.r4.data.mongo.amrit_resource.TempCollection;

@Repository
@RestResource(exported = false)
public interface TempCollectionRepo extends MongoRepository<TempCollection, String> {
	List<TempCollection> findByBeneficiaryRegIDAndVisitCode(Long beneficiaryRegID, Long visitCode);
}
