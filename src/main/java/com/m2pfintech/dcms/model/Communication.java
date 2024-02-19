package com.m2pfintech.dcms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Communication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer commId;
	
	@NotNull
	public String mobileNo;
	
	@NotNull
	public String emailId;

	public Communication(@NotNull String mobileNo, @NotNull String emailId) {
		super();
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}

	public Communication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCommId() {
		return commId;
	}

	public void setCommId(Integer commId) {
		this.commId = commId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
	
}
