package com.m2pfintech.dcms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.m2pfintech.dcms.exceptionHandler.BankException;
import com.m2pfintech.dcms.exceptionHandler.CustomerException;
import com.m2pfintech.dcms.model.Bank;
import com.m2pfintech.dcms.model.Communication;
import com.m2pfintech.dcms.model.Customer;
import com.m2pfintech.dcms.model.CustomerDTO;
import com.m2pfintech.dcms.repository.AccountDao;
import com.m2pfintech.dcms.repository.AddressDao;
import com.m2pfintech.dcms.repository.BankDao;
import com.m2pfintech.dcms.repository.CommunicationDao;
import com.m2pfintech.dcms.repository.CustomerDao;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private BankDao bankDao;
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private AddressDao addressDao;
	
	
	@Autowired
	private CommunicationDao communicationDao;
	
	@Override
	public CustomerDTO RegisterCustomer(Customer customerInfo, String bankName) throws CustomerException, BankException {
	    Optional<Bank> bankOps = bankDao.findByName(bankName);

	    if (bankOps.isEmpty()) {
	        throw new BankException("BankName not found");
	    }

	    Bank existingBank = bankOps.get();
	    
	     List<Customer> customerList= existingBank.getCustomerInfo();
	     
	     Boolean isExist =false;
	     
	     for(Customer c: customerList) {
	    	 
	    	 if(c.getEntityId().equals(customerInfo.entityId)) {
	    		 isExist =true;
	    		 break;
	    	 }
	     }

	    if (isExist) {
	        throw new CustomerException("Customer already registered under " + bankName);
	    }

	    customerInfo.setBank(existingBank);
	    

	    addressDao.save(customerInfo.getCustomerAddressInfo());
	    
	    accountDao.save(customerInfo.getAccountInfo());
	    
	    communicationDao.save(customerInfo.getCommunicationInfo());
	   
	    Customer registeredCustomer= customerDao.save(customerInfo);
	    
	    CustomerDTO CustomerDTO = new CustomerDTO(registeredCustomer.getEntityId(),registeredCustomer.getFirstName(),registeredCustomer.getMiddleName(),registeredCustomer.getLastName(), registeredCustomer.getEmail());

	    return CustomerDTO;
	}

	@Override
	public Customer fetchCustomerDetailsByEmail(String email) throws CustomerException {


		Optional<Customer> opt= customerDao.findByEmail(email);
		
		if(opt.isPresent()) {
			
			 Customer fetchedCustomer= opt.get();
			
			return fetchedCustomer;
		}else {
			throw new CustomerException("Customer Not registered with : "+email);
		}
	}

	@Override
	public List<CustomerDTO> fetchAllCustomerDetails() throws CustomerException {
		
		List<Customer> list= customerDao.findAll();
		
		if(list.isEmpty()) {
			throw new CustomerException("No Customer Found");
		}
		else {
			
			List<CustomerDTO> customerDTOs= new ArrayList<>(); 
			
			list.forEach(customer->{
			CustomerDTO CustomerDTO = new CustomerDTO(customer.getEntityId(),customer.getFirstName(),customer.getMiddleName(),customer.getLastName(), customer.getEmail());
			customerDTOs.add(CustomerDTO);
			});
		
			return customerDTOs;
		
		}
	}

	@Override
	public Customer updateCustomerCommunicationInfo(Communication communicationinfo, String email)
			throws CustomerException {
		
		Optional<Customer> opt= customerDao.findByEmail(email);
		
		if(opt.isPresent()) {
		
		    Customer customer=  opt.get();
		    
		    Integer comId= customer.getCommunicationInfo().getCommId();
		    
		    customer.setCommunicationInfo(communicationinfo);
		    
		    communicationDao.deleteById(comId);
	
		    Customer updated= customerDao.save(customer);
		
		return updated;
		
		}else {
			throw new CustomerException("Customer Not registered with : " + email);
		}
	}

	@Override
	public Integer deleteCustomerByEntityId(Integer entityId) throws CustomerException, BankException {

		
		Optional<Customer> opt= customerDao.findByEntityId(entityId);
		
		System.out.println("Started...");
		
		if(opt.isPresent()) {
			
			Customer customer=opt.get();
			
			Integer bankID= customer.getBank().getBankId();
			
			Optional<Bank> bankopt= bankDao.findById(bankID);
			
			if(bankopt.isPresent()) {
				
				Bank bank= bankopt.get();
				List<Customer> list= bank.getCustomerInfo();
				list.remove(customer);
				
				
				customerDao.deleteById(customer.getEntityId());	
				
			}else {
				throw new BankException("Bankinfo not found for customer "+ entityId);
			}
			
		}else {
			throw new CustomerException("Entity ID not found : "+ entityId);
		}
		
		return entityId;
	}
	
	


	

}
