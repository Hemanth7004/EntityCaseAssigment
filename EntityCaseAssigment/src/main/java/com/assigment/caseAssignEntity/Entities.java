package com.assigment.caseAssignEntity;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Entities")
public class Entities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "is_company")
	private boolean isCompany;
	
	@CreationTimestamp
	@Column(name = "created_time")
	private Timestamp createdAt;
	
	@OneToMany(targetEntity = EntityToCases.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "entityId", referencedColumnName = "id")
	private List<EntityToCases> entityToCases;

	public Entities() {
		super();
	}

	public Entities(Long id, String name, String address, String email, String companyName, boolean isCompany,
			Timestamp createdAt, List<EntityToCases> entityToCases) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.companyName = companyName;
		this.isCompany = isCompany;
		this.createdAt = createdAt;
		this.entityToCases = entityToCases;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public boolean isCompany() {
		return isCompany;
	}

	public void setCompany(boolean isCompany) {
		this.isCompany = isCompany;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public List<EntityToCases> getEntityToCases() {
		return entityToCases;
	}

	public void setEntityToCases(List<EntityToCases> entityToCases) {
		this.entityToCases = entityToCases;
	}

	@Override
	public String toString() {
		return "Entities [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", companyName="
				+ companyName + ", isCompany=" + isCompany + ", createdAt=" + createdAt + ", entityToCases="
				+ entityToCases + "]";
	}	
}