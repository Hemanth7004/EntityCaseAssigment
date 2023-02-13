package com.assigment;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.assigment.caseAssignEntity.EntityToCases;
import com.assigment.caseAssignRepository.EntityToCaseRepository;

@DataJpaTest
public class EntityToCaseTest {

	@Autowired
	private EntityToCaseRepository entityToCaseRepository;
		
	@Test
	@Rollback(value = false)
	public void insertToEntityCase() {
		List<EntityToCases> entityCaseList = new ArrayList<>();
		EntityToCases entityTocase1 = new EntityToCases(null, "Case1", null);
		EntityToCases entityTocase2 = new EntityToCases(null, "Case2", null);
		EntityToCases entityTocase3 = new EntityToCases(null, "Case1", null);
		
		entityCaseList.add(entityTocase1);
		entityCaseList.add(entityTocase2);
		entityCaseList.add(entityTocase3);
		
		entityToCaseRepository.saveAll(entityCaseList);
		findNumberOfEntityByCase();
	}
	
	public void findNumberOfEntityByCase() {
		String findCase = "Case1";
		List<EntityToCases> response = entityToCaseRepository.findAllByCaseNumber(findCase);
		
		Assertions.assertThat(response.get(0).getCaseNumber()).isEqualTo(findCase);
	}
}