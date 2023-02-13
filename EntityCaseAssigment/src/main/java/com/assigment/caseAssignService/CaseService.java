package com.assigment.caseAssignService;

import java.util.List;

import com.assigment.caseAssignEntity.Cases;

public interface CaseService {
	
	public List<Cases> getAllCases();
	public Cases getCasesBycaseNumber(String CaseNumber,Cases entityCase) throws Exception;
	public Cases addCases(Cases cases); 
}