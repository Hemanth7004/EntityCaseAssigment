package com.assigment.caseAssignController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assigment.caseAssignEntity.Entities;
import com.assigment.caseAssignService.EntityService;

@RestController
public class EntityController {

	@Autowired
	private EntityService entityService;
	
	@PostMapping("/entities")
	public ResponseEntity<List<Entities>> addEntity(@RequestBody List<Entities> entities) {
			List<Entities>  entity = entityService.addEntities(entities);		
			return new ResponseEntity<List<Entities>>(entity,HttpStatus.CREATED);
	}
	
	@GetMapping("getAllEntity")
	public ResponseEntity<List<Entities>> getAllentity() {
		List<Entities>  entity = entityService.getAllEntities();		
		return new ResponseEntity<List<Entities>>(entity,HttpStatus.OK);
	}
}