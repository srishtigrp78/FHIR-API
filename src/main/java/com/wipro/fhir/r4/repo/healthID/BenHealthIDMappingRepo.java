package com.wipro.fhir.r4.repo.healthID;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.fhir.r4.data.healthID.BenHealthIDMapping;

@Repository
@RestResource(exported = false)
public interface BenHealthIDMappingRepo extends CrudRepository<BenHealthIDMapping, Long> {

	@Query(value = "SELECT BenRegId FROM db_identity.m_beneficiaryregidmapping where beneficiaryid= :beneficiaryID ", nativeQuery = true)
	Long getBenRegID(@Param("beneficiaryID") Long beneficiaryID);

	@Query(" SELECT bvd from BenHealthIDMapping bvd WHERE bvd.beneficiaryRegID = :benRegID")
	public ArrayList<BenHealthIDMapping> getHealthDetails(@Param("benRegID") Long benRegID);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE db_iemr.t_benvisitdetail SET HealthID= :healthID,HealthIdNumber= :healthIdNumber,CarecontextLinkDate=CURRENT_TIMESTAMP() WHERE VisitCode= :visitCode ", nativeQuery = true)
	Integer updateHealthIDAndHealthIDNumberForCareContext(@Param("healthID") String healthID, @Param("healthIdNumber") String healthIdNumber, @Param("visitCode") String visitCode);


	@Transactional
	@Modifying
	@Query(value = "UPDATE db_iemr.t_benvisitdetail SET HealthID= :healthID,CarecontextLinkDate=CURRENT_TIMESTAMP() WHERE VisitCode= :visitCode ", nativeQuery = true)
	Integer updateHealthIDForCareContext(@Param("healthID") String healthID, @Param("visitCode") String visitCode);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE db_iemr.t_benvisitdetail SET HealthIdNumber = :healthIdNumber,CarecontextLinkDate=CURRENT_TIMESTAMP() WHERE VisitCode= :visitCode ", nativeQuery = true)
	Integer updateHealthIDNumberForCareContext(@Param("healthIdNumber") String healthIdNumber, @Param("visitCode") String visitCode);

	@Query(nativeQuery = true, value = " SELECT HealthID FROM t_benvisitdetail t WHERE t.VisitCode = :visitCode")
	public List<String> getLinkedHealthIDForVisit(@Param("visitCode") Long visitCode);

	@Query(value = "SELECT beneficiaryid FROM db_identity.m_beneficiaryregidmapping "
			+ " WHERE BenRegId= :BenRegId ", nativeQuery = true)
	Long getBenID(@Param("BenRegId") Long BenRegId);
}
