package com.assigment.caseAssignRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assigment.caseAssignEntity.Cases;

@Repository
public interface CaseRepository extends JpaRepository<Cases, Long>{

	@Query(value="select * from Cases where CASE_NUMBER = :caseNumber",nativeQuery=true)
	public Cases findByCaseNumber(@Param("caseNumber")String caseNumber);	
}