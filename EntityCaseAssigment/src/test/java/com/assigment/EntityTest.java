package com.assigment;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.assigment.caseAssignEntity.Entities;
import com.assigment.caseAssignEntity.EntityToCases;
import com.assigment.caseAssignRepository.EntitiesRepository;

@DataJpaTest
public class EntityTest {

	@Autowired
	private EntitiesRepository entitiesRepository;
	
	@Test
	@Rollback(value = false)
	public void testCreateEntity() {
		List<EntityToCases> entityCaseList = new ArrayList<>();
		EntityToCases entityTocase1 = new EntityToCases(null, "Case1", null);
		EntityToCases entityTocase2 = new EntityToCases(null, "Case2", null);
		EntityToCases entityTocase3 = new EntityToCases(null, "Case1", null);
		
		entityCaseList.add(entityTocase1);
		entityCaseList.add(entityTocase2);
		entityCaseList.add(entityTocase3);
		
		Entities entity = new Entities(null, "Entity1","Address1", "entity1@gmail.com", "Company1",false, null,entityCaseList);
		Entities entityresponse = entitiesRepository.save(entity);
		
	    Assertions.assertThat(entityresponse.getId()).isGreaterThan(0);    
	}
}
