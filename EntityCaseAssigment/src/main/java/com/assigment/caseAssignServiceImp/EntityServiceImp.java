package com.assigment.caseAssignServiceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assigment.caseAssignEntity.Entities;
import com.assigment.caseAssignRepository.EntitiesRepository;
import com.assigment.caseAssignService.EntityService;
import com.assigment.exceptions.EmptyInputException;

@Service
public class EntityServiceImp implements EntityService {

	@Autowired
	private EntitiesRepository entitiesRepository;

	public List<Entities> getAllEntities() {
		List<Entities> entity = new ArrayList<>();
		try {
			entity = entitiesRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return entity;
	}

	@Override
	public List<Entities> addEntities(List<Entities> entities) {
		List<Entities> entity = null;
		try {
			for (Entities data: entities) {
				if (data.getName().isEmpty() || data.getEntityToCases().size() == 0) {
					throw new EmptyInputException("601", "Input Fields are Empty");
				}
			}
			entity = entitiesRepository.saveAll(entities);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return entity;
	}
}