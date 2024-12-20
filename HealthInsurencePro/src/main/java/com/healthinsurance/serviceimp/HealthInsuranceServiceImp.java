package com.healthinsurance.serviceimp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.healthinsurance.dto.HealthInsuranceDto;
import com.healthinsurance.model.HealthInsuranceModel;
import com.healthinsurance.repo.HealthInsuranceRepo;
import com.healthinsurance.service.HealthInsuranceService;

@Service
public class HealthInsuranceServiceImp implements HealthInsuranceService {

    @Autowired
    private HealthInsuranceRepo repository;

    // Simple message response
    @Override
    public String msg() {
        return "Hello from Health Insurance Service";
    }

    @Override
    public ResponseEntity<?> saveHealthInsurance(HealthInsuranceDto dto) {
        // Check if the mobileNo already exists in the database
        Optional<HealthInsuranceModel> existingData = repository.findByMobileNoOrEmailId(dto.getMobileNo(),dto.getEmailId());

        if (existingData.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                                 .body("Data already exists for the provided mobile number or EmailId ");
        }
        else {
        	
        
        // If no customerId is provided, generate one
          LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mmss");
           String customerId = now.format(formatter);  // Generate unique ID
        

        // Create a new HealthInsuranceModel object
        HealthInsuranceModel insuranceModel = new HealthInsuranceModel();
        insuranceModel.setFullName(dto.getFullName());
        insuranceModel.setMobileNo(dto.getMobileNo());
        insuranceModel.setEmailId(dto.getEmailId());
        insuranceModel.setGender(dto.getGender());
        insuranceModel.setCustomerId(customerId);

        // Save the data to the repository
        repository.save(insuranceModel);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body("Data stored successfully ");
        }
    }

    // Find by mobile number
    @Override
    public ResponseEntity<?> findByMobileNo(String mobileNo) {
        Optional<HealthInsuranceModel> data = repository.findByMobileNo(mobileNo);

        if (data.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("No data found for mobile number: " + mobileNo);
        }

        return ResponseEntity.status(HttpStatus.OK).body("Found");
    }

    // Find by email ID
    @Override
    public ResponseEntity<?> findByEmailId(String emailId) {
        Optional<HealthInsuranceModel> data = repository.findByemailId(emailId);

        if (data.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("No data found for email ID: " + emailId);
        }

        return ResponseEntity.status(HttpStatus.OK).body("Found");
    }

    // Retrieve data by mobile number
    @Override
    public ResponseEntity<?> findByMobileData(String mobileNo) {
        Optional<HealthInsuranceModel> data = repository.findByMobileNo(mobileNo);

        if (data.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("No data found for mobile number: " + mobileNo);
        }

        return ResponseEntity.status(HttpStatus.OK).body(data.get());
    }


	@Override
	public List<HealthInsuranceModel> allUsers() {
		 return repository.findAll();
		
	}




}
