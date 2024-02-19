package com.m2pfintech.dcms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Address{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer addressId;
	
	String city;
	String state;
	String country;
	String pincode;
	
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	


	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
	}




	public Address(String city, String state, String country, String pincode) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}




	public Integer getAddressId() {
		return addressId;
	}




	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public String getCountry() {
		return country;
	}




	public void setCountry(String country) {
		this.country = country;
	}




	public String getPincode() {
		return pincode;
	}




	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
}
