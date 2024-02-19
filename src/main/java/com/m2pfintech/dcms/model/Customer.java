package com.m2pfintech.dcms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer entityId;
	
	public String firstName;
	
	public String middleName;
	
	public String lastName;
	
	@Column(unique = true,nullable = false)
	public String email;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	public String password;
	
	public String role;
	
	@ManyToOne
	@JoinColumn(name = "bankId")
	public Bank bank;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="addressId",referencedColumnName = "addressId")
	public Address customerAddressInfo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="commId",referencedColumnName = "commId")
	public Communication communicationInfo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="accountId",referencedColumnName = "accountId")  
	public Account accountInfo;

	public Customer(Integer entityId, String firstName, String middleName, String lastName, Address customerAddressInfo,
			Communication communicationInfo, @NotNull Account accountInfo) {
		super();
		this.entityId = entityId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.customerAddressInfo = customerAddressInfo;
		this.communicationInfo = communicationInfo;
		this.accountInfo = accountInfo;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Address getCustomerAddressInfo() {
		return customerAddressInfo;
	}

	public void setCustomerAddressInfo(Address customerAddressInfo) {
		this.customerAddressInfo = customerAddressInfo;
	}

	public Communication getCommunicationInfo() {
		return communicationInfo;
	}

	public void setCommunicationInfo(Communication communicationInfo) {
		this.communicationInfo = communicationInfo;
	}

	public Account getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(Account accountInfo) {
		this.accountInfo = accountInfo;
	}
	
	
	
	
	
}
