package com.m2pfintech.dcms.service;

import org.springframework.stereotype.Service;

import com.m2pfintech.dcms.exceptionHandler.BankException;
import com.m2pfintech.dcms.exceptionHandler.BinException;
import com.m2pfintech.dcms.model.Bin;

@Service
public interface BinService {
	
	public String addBin(Bin bin) throws BinException, BankException;
	

}
