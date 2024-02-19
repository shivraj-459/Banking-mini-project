package com.m2pfintech.dcms.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Bank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer bankId;
	
	@Column(unique = true)
	public String bankName;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	public Address bankAddress;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	public List<Bin> binInfo = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "bank")
	public List<Customer> customerInfo = new ArrayList<>();
	

	public Bank(Integer bankId, String bankName, Address bankAddress, List<Bin> binInfo) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.bankAddress = bankAddress;
		this.binInfo = binInfo;
	}

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
