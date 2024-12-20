package com.healthinsurance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthinsurance.model.HealthInsuranceModel;

public interface HealthInsuranceRepo extends JpaRepository<HealthInsuranceModel, Long>
{

	Optional<HealthInsuranceModel> findByMobileNo(String mobileNo);

	Optional<HealthInsuranceModel> findByemailId(String emailId);

	
	Optional<HealthInsuranceModel> findByMobileNoOrEmailId(String mobileNo, String emailId);




	
}
