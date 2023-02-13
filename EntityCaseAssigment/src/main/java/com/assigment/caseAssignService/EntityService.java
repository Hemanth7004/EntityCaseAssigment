package com.assigment.caseAssignService;

import java.util.List;

import com.assigment.caseAssignEntity.Entities;

public interface EntityService {

	public List<Entities> getAllEntities();
	public List<Entities> addEntities(List<Entities> entities);	
}