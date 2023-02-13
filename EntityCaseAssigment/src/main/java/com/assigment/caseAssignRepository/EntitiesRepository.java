package com.assigment.caseAssignRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assigment.caseAssignEntity.Entities;

@Repository
public interface EntitiesRepository extends JpaRepository<Entities, Long>{

	@Query(value="select * from Entities where id in (:ids)",nativeQuery=true)
	public List<Entities> findAllCases(@Param("ids")List<String> ids);
}