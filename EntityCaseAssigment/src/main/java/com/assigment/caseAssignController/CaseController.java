package com.assigment.caseAssignController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assigment.caseAssignEntity.Cases;
import com.assigment.caseAssignService.CaseService;

@RestController
public class CaseController {

	@Autowired
	private CaseService caseService;

	@PostMapping("/casesEdit/{caseNumber}/entities")
	public ResponseEntity<Cases> editEntityToCase(@PathVariable("caseNumber") String caseNumber,
			@RequestBody Cases entityCase) throws Exception {
		Cases response = caseService.getCasesBycaseNumber(caseNumber, entityCase);
		return new ResponseEntity<Cases>(response, HttpStatus.ACCEPTED);
	}

	@PostMapping("/cases")
	public ResponseEntity<Cases> addCases(@RequestBody Cases cases) {
		Cases response = caseService.addCases(cases);
		return new ResponseEntity<Cases>(response, HttpStatus.CREATED);
	}

	@GetMapping("/getAllCases")
	public ResponseEntity<List<Cases>> getAllCases() {
		List<Cases> cases = caseService.getAllCases();
		return new ResponseEntity<List<Cases>>(cases, HttpStatus.OK);
	}
}