package com.m2pfintech.dcms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer accountId;
	
	public String accountNumber;
	
	@Enumerated(EnumType.STRING)
	public AccountType accountType;
	
	@Enumerated(EnumType.STRING)
	public AccountStatus accountStatus;

	public Account(String accountNumber, AccountType accountType, AccountStatus accountStatus) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	} 
	

}
