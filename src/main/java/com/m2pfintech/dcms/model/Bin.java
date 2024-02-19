package com.m2pfintech.dcms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
public class Bin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer binId;
	
	@Column(unique = true)
	public String binValue;
	
	@Enumerated(EnumType.STRING)
	public Network binNetwork;
	
	public String productCode;
	
	
	public Bin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Bin(Integer binId, String binValue, Network binNetwork, String productCode) {
		super();
		this.binId = binId;
		this.binValue = binValue;
		this.binNetwork = binNetwork;
		this.productCode = productCode;
	}

	

}
