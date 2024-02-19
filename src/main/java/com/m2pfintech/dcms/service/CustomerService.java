package com.m2pfintech.dcms.service;

import java.util.List;

import com.m2pfintech.dcms.exceptionHandler.BankException;
import com.m2pfintech.dcms.exceptionHandler.CustomerException;
import com.m2pfintech.dcms.model.Communication;
import com.m2pfintech.dcms.model.Customer;
import com.m2pfintech.dcms.model.CustomerDTO;

public interface CustomerService {
	
	public CustomerDTO RegisterCustomer(Customer customerInfo,String bankName) throws CustomerException, BankException;
	
	public Customer fetchCustomerDetailsByEmail(String email) throws CustomerException;
	
	public List<CustomerDTO> fetchAllCustomerDetails() throws CustomerException;
	
	public Customer updateCustomerCommunicationInfo(Communication communicationinfo,String email) throws CustomerException;
	
	public CustomerDTO deleteCustomerByEntityId(Integer entityId) throws CustomerException, BankException;
	
}
