package com.assigment.caseAssignEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Entity_to_cases")
public class EntityToCases {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String caseNumber;
	
	private Long entityId;

	public EntityToCases() {
		super();
	}

	public EntityToCases(Long id, String caseNumber, Long entityId) {
		super();
		this.id = id;
		this.caseNumber = caseNumber;
		this.entityId = entityId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	@Override
	public String toString() {
		return "EntityToCases [id=" + id + ", caseNumber=" + caseNumber + ", entityId=" + entityId + "]";
	}
}