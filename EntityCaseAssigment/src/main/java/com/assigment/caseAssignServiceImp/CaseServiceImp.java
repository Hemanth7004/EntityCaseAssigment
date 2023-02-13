package com.assigment.caseAssignServiceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assigment.caseAssignEntity.Cases;
import com.assigment.caseAssignRepository.CaseRepository;
import com.assigment.caseAssignService.CaseService;
import com.assigment.exceptions.EmptyInputException;
import com.assigment.exceptions.ResourceNotFoundException;

@Service
public class CaseServiceImp implements CaseService {

	@Autowired
	private CaseRepository caseRepository;

	@Override
	public List<Cases> getAllCases() {
		List<Cases> cases = new ArrayList<>();
		try {
			cases = caseRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return cases;
	}

	@Override
	public Cases getCasesBycaseNumber(String caseNumber, Cases entityCase) throws Exception {
		Cases cases = null;
		try {
			cases = caseRepository.findByCaseNumber(caseNumber);
			if (cases == null) {
				throw new ResourceNotFoundException("Details Not Found For CaseNumber " + caseNumber);
			}
			cases.setCaseNumber(entityCase.getCaseNumber());
			caseRepository.save(cases);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return cases;
	}

	@Override
	public Cases addCases(Cases cases) {
		Cases addcases = null;
		try {
			if (cases.getCaseNumber().isEmpty()) {
				throw new EmptyInputException("601", "Case Number Is Empty");
			}
			addcases = caseRepository.save(cases);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return addcases;
	}
}