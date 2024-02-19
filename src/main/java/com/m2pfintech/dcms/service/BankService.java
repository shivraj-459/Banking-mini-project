package com.m2pfintech.dcms.service;


import java.util.List;

import com.m2pfintech.dcms.exceptionHandler.BankException;
import com.m2pfintech.dcms.model.Bank;

public interface BankService{

	public String addBank(Bank bank) throws BankException;
	
	public List<Bank> fetchAllBanks() throws BankException;
}
