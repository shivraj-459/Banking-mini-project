package com.m2pfintech.dcms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.m2pfintech.dcms.exceptionHandler.BankException;
import com.m2pfintech.dcms.exceptionHandler.CustomerException;
import com.m2pfintech.dcms.model.Communication;
import com.m2pfintech.dcms.model.Customer;
import com.m2pfintech.dcms.model.CustomerDTO;
import com.m2pfintech.dcms.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/registerCustomer")
	public ResponseEntity<CustomerDTO> registerCustomer(@RequestBody Customer customerInfo,@RequestHeader String bankName) throws CustomerException,BankException{
		
		customerInfo.setPassword(passwordEncoder.encode(customerInfo.getPassword()));
		
		customerInfo.setRole("ROLE_"+customerInfo.getRole().toUpperCase());
		
		CustomerDTO response= customerService.RegisterCustomer(customerInfo, bankName);

		return new ResponseEntity<CustomerDTO>(response, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/customers/{email}")
	public ResponseEntity<Customer> fetchCustomerDetailByEmail(@PathVariable("email") String email) throws CustomerException{
		
		Customer customer= customerService.fetchCustomerDetailsByEmail(email);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<CustomerDTO>> fetchAllCustomerDetailsHandler() throws CustomerException{
		
		List<CustomerDTO> list= customerService.fetchAllCustomerDetails();
		
		return new ResponseEntity<List<CustomerDTO>>(list, HttpStatus.OK);

	}
	
	@PatchMapping("/customers/{email}")
	public ResponseEntity<Customer> updateCommunicationInfoHandler(@RequestBody Communication communicationInfo,@PathVariable String email) throws CustomerException{
	
		Customer customer= customerService.updateCustomerCommunicationInfo(communicationInfo, email);
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/customers/{entityid}")
	public ResponseEntity<Integer> deleteCustomerHandler(@PathVariable("entityid") Integer entityID) throws CustomerException, BankException{
		
		Integer response = customerService.deleteCustomerByEntityId(entityID);
		
		return new ResponseEntity<Integer>(response,HttpStatus.OK);
	}
	
	
	@GetMapping("/signin")
	public ResponseEntity<String> getLoggedInCustomerDetailsHandler(Authentication auth) throws CustomerException{
		
		Customer customer= customerService.fetchCustomerDetailsByEmail(auth.getName());
		
		return new ResponseEntity<String>(customer.getFirstName() + " Logged In Successfully", HttpStatus.OK);
	}
	
	
	
}
