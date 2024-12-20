package com.healthinsurance.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.healthinsurance.dto.HealthInsuranceDto;
import com.healthinsurance.model.HealthInsuranceModel;

public interface HealthInsuranceService 
{

	String msg();

	ResponseEntity<?> saveHealthInsurance(HealthInsuranceDto health);

	



	ResponseEntity<?> findByEmailId(String emailId);

	ResponseEntity<?> findByMobileData(String mobileNo);

	ResponseEntity<?> findByMobileNo(String mobileNo);

	List<HealthInsuranceModel> allUsers();

	 

	

}
