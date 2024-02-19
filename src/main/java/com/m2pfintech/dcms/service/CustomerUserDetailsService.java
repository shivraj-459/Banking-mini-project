package com.m2pfintech.dcms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.m2pfintech.dcms.model.Customer;
import com.m2pfintech.dcms.repository.CustomerDao;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		Optional<Customer> opt= customerDao.findByEmail(username);
		
		
		if(opt.isPresent()) {
			
			Customer customer=opt.get();
			
			List<GrantedAuthority> authorities= new ArrayList<>();
			
			SimpleGrantedAuthority sga=new SimpleGrantedAuthority(customer.getRole());
			
			authorities.add(sga);
			
			return new User(customer.getEmail(),customer.getPassword(), authorities);
			
		}else {
			throw new BadCredentialsException("User Details not found with this username : "+username);
		}
		
	}

}
