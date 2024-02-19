package com.m2pfintech.dcms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.m2pfintech.dcms.model.Communication;

@Repository
public interface CommunicationDao extends JpaRepository<Communication, Integer>{

}
