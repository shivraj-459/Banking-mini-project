package com.m2pfintech.dcms.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.m2pfintech.dcms.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

	Optional<Customer> findByEntityId(Integer entityId);
	
	Optional<Customer> findByEmail(String email);
	
}
