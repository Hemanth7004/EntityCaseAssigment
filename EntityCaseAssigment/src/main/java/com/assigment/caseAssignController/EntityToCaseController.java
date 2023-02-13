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

import com.assigment.caseAssignEntity.EntityToCases;
import com.assigment.caseAssignService.EntityToCaseService;

@RestController
public class EntityToCaseController {

	@Autowired
	private EntityToCaseService entityToCaseService;

	@PostMapping("/cases/{caseNumber}/entities")
	public ResponseEntity<List<EntityToCases>> editEntityToCase(@PathVariable("caseNumber") String caseNumber,
			@RequestBody EntityToCases entityCase) throws Exception {
		List<EntityToCases> response = entityToCaseService.updateEntitytoCase(caseNumber, entityCase);
		return new ResponseEntity<List<EntityToCases>>(response, HttpStatus.OK);
	}

	@GetMapping("/cases/{caseNumber}/entities")
	public ResponseEntity<String> countEntity(@PathVariable("caseNumber") String caseNumber) {
		int response = entityToCaseService.totalEntityByCase(caseNumber);
		return new ResponseEntity<String>("Total Number of Entity are " + response, HttpStatus.OK);
	}
}