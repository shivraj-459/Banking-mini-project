package com.m2pfintech.dcms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.m2pfintech.dcms.exceptionHandler.BankException;
import com.m2pfintech.dcms.model.Bank;
import com.m2pfintech.dcms.service.BankService;


@RestController
public class BankController {

	@Autowired
	private BankService bankService;
	
	@PostMapping("/addBank")
	public ResponseEntity<String> addBank(@RequestBody Bank bank) throws BankException{
		
		String newBank= bankService.addBank(bank);
		
		return new ResponseEntity<String>(newBank,HttpStatus.CREATED);	
	}
	
	@GetMapping("/banks")
	public ResponseEntity<List<Bank>> fetchAllBanksHandler() throws BankException{
		
		List<Bank> banks= bankService.fetchAllBanks();

		return new ResponseEntity<List<Bank>>(banks, HttpStatus.OK);
	}
	
	
	
}
