package com.m2pfintech.dcms.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.m2pfintech.dcms.model.Bin;

@Repository
public interface BinDao extends JpaRepository<Bin, Integer> {

	Optional<Bin> findByBinValue(String binValue);
	
}
