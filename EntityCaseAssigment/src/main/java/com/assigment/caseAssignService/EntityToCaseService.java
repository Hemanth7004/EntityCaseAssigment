package com.assigment.caseAssignService;

import java.util.List;

import com.assigment.caseAssignEntity.EntityToCases;

public interface EntityToCaseService {
	
	public List<EntityToCases> updateEntitytoCase(String caseNumber, EntityToCases entityCase) throws Exception;
	public int totalEntityByCase(String caseNumber);
}