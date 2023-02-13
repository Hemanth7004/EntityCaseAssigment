package com.assigment.caseAssignServiceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assigment.caseAssignEntity.Entities;
import com.assigment.caseAssignEntity.EntityToCases;
import com.assigment.caseAssignRepository.EntitiesRepository;
import com.assigment.caseAssignRepository.EntityToCaseRepository;
import com.assigment.caseAssignService.EntityToCaseService;
import com.assigment.exceptions.EmptyInputException;
import com.assigment.exceptions.ResourceNotFoundException;

@Service
public class EntityToCaseServiceImp implements EntityToCaseService {

	@Autowired
	private EntityToCaseRepository entityToCaseRepository;

	@Autowired
	private EntitiesRepository entitiesRepository;

	@Override
	public List<EntityToCases> updateEntitytoCase(String caseNumber, EntityToCases entityToCases) throws Exception {
		List<EntityToCases> editedentity = new ArrayList<>();
		try {
			if(entityToCases.getCaseNumber().isEmpty()) {
				throw new EmptyInputException("601", "Case Number Is Empty");
			}
			List<EntityToCases> entity = entityToCaseRepository.findAllByCaseNumber(caseNumber);
			if(entity.isEmpty()) {
				throw new ResourceNotFoundException("Details Not Found For CaseNumber " + caseNumber);
			}
			for (EntityToCases data : entity) {
				data.setCaseNumber(entityToCases.getCaseNumber());
				editedentity.add(data);
			}
			entityToCaseRepository.saveAll(editedentity);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return editedentity;
	}

	@Override
	public int totalEntityByCase(String caseNumber) {
		List<Entities> totalEntity = new ArrayList<>();
		try {
			List<EntityToCases> entity = entityToCaseRepository.findAllByCaseNumber(caseNumber);
			List<String> entityIds = entity.stream().map(m -> m.getEntityId().toString()).collect(Collectors.toList());
			
			totalEntity = entitiesRepository.findAllCases(entityIds);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return totalEntity.size();
	}
}