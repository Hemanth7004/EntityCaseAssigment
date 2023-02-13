package com.assigment.caseAssignRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assigment.caseAssignEntity.EntityToCases;

@Repository
public interface EntityToCaseRepository extends JpaRepository<EntityToCases, Long>{
	
	@Modifying
	@Query(value="update ENTITY_TO_CASES set CASE_NUMBER = :caseNumber where CASE_NUMBER = :caseNumber",nativeQuery=true)
	public void updateEnityCases(@Param("caseNumber")String caseNumber);
	
	@Query(value="select * from ENTITY_TO_CASES where CASE_NUMBER = :caseNumber",nativeQuery=true)
	public List<EntityToCases> findAllByCaseNumber(@Param("caseNumber")String caseNumber);
}