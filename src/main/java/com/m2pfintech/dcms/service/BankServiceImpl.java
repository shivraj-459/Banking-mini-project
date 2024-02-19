package com.m2pfintech.dcms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.m2pfintech.dcms.exceptionHandler.BankException;
import com.m2pfintech.dcms.model.Bank;
import com.m2pfintech.dcms.repository.AddressDao;
import com.m2pfintech.dcms.repository.BankDao;
import com.m2pfintech.dcms.repository.BinDao;

@Service
public class BankServiceImpl implements BankService{

	@Autowired
	private BankDao bankDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private BinDao binDao;
	
	@Override
	public String addBank(Bank bank) throws BankException{

		Optional<Bank> opt=bankDao.findByName(bank.bankName);
		
		if(opt.isPresent()) {
			throw new BankException("Bank Already Exist");
		}
	
		Bank newBank=bankDao.save(bank);
		
		return newBank.bankName + " added";
	}

	@Override
	public List<Bank> fetchAllBanks() throws BankException {

		List<Bank> banks= bankDao.findAll();
		
		if(banks.isEmpty()) {
			
			throw new BankException("No Bank Found...!");
		}
		
		return banks;
	}

}
