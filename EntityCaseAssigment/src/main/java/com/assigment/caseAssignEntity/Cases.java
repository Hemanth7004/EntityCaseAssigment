package com.assigment.caseAssignEntity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Cases")
public class Cases {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String caseNumber;
	
	@CreationTimestamp
	@Column(name = "created_at")
	private Timestamp createdAt;

	public Cases() {
		super();
	}

	public Cases(Long id, String caseNumber, Timestamp createdAt) {
		super();
		this.id = id;
		this.caseNumber = caseNumber;
		this.createdAt = createdAt;
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

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Cases [id=" + id + ", caseNumber=" + caseNumber + ", createdAt=" + createdAt + "]";
	}
}