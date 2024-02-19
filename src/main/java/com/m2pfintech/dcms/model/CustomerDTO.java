package com.m2pfintech.dcms.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CustomerDTO {
	
	
	public Integer entityId;
	
	public String firstName;
	
	public String middleName;
	
	public String lastName;
	
	@Column(unique = true,nullable = false)
	public String email;

	public CustomerDTO(Integer entityId, String firstName, String middleName, String lastName, String email) {
		super();
		this.entityId = entityId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
	}

	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
