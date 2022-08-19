package com.sayan.microservice.pensionerdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sayan.microservice.pensionerdetails.bean.PensionDetailsBean;

@Repository
public interface PensionRepository extends JpaRepository<PensionDetailsBean, String> {
	
}
