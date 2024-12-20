package com.healthinsurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthinsurance.dto.HealthInsuranceDto;
import com.healthinsurance.model.HealthInsuranceModel;
import com.healthinsurance.service.HealthInsuranceService;

@RestController
@RequestMapping("/register")
public class HealthInsuranceController
{
	@Autowired
	private HealthInsuranceService service;
	

@GetMapping("/get")
public String msg() 
{
	return service.msg();
}
@PostMapping("/post")
public ResponseEntity<?> post(@RequestBody HealthInsuranceDto health ) 
{
	return service.saveHealthInsurance(health);
}
@GetMapping("/get/{mobileNo}")
public ResponseEntity<?> findBymobileNo(@PathVariable String mobileNo)
{
	return service.findByMobileNo(mobileNo);
}
@GetMapping("/call/{emailId}")
public ResponseEntity<?> findByemailId(@PathVariable String emailId)
{
	return service.findByEmailId(emailId);
}
@GetMapping("/retrive/{mobileNo}")
public ResponseEntity<?> findBymobileData(@PathVariable String mobileNo)
{
	return service.findByMobileData(mobileNo);
}
@GetMapping("/users")
public List<HealthInsuranceModel> allUsers()
{
    return service.allUsers(); // Returns the list of users from the service
}
}
