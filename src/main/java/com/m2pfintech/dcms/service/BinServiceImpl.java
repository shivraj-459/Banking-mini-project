package com.m2pfintech.dcms.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import com.m2pfintech.dcms.exceptionHandler.BankException;
import com.m2pfintech.dcms.exceptionHandler.BinException;
import com.m2pfintech.dcms.model.Bank;
import com.m2pfintech.dcms.model.Bin;
import com.m2pfintech.dcms.repository.BankDao;
import com.m2pfintech.dcms.repository.BinDao;

public class BinServiceImpl implements BinService {

	@Autowired
	private BinDao binDao;
	
	@Autowired
	private BankDao bankDao;
	
	@Override
	public String addBin(Bin bin) throws BinException,BankException {

//				Optional<Bin> binOps= binDao.findByBinValue(bin.binValue);
//				Optional<Bank> bankOps= bankDao.findByName(bin.getBank().getBankName());
//				
//				if(bankOps.isEmpty()) {
//					throw new BankException("BankName Not Found");
//				}
//						
//				if(binOps.isPresent()) {
//					throw new BinException("Bin Already Exist");
//				}
				
				
				
				
		return null;
	}

}
