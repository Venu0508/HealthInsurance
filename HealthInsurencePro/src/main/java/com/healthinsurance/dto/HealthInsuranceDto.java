package com.healthinsurance.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class HealthInsuranceDto 
{
	private String fullName;
	  private String gender;
	  private String mobileNo;
	  private String emailId;
	  private String customerId;
	
	  	
	
	@Id
  private String id;
  public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public HealthInsuranceDto(String fullName, String gender, String mobileNo, String emailId, String customerId,
			String id) {
		this.fullName = fullName;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.customerId = customerId;
		this.id = id;
		
		
	}
	public HealthInsuranceDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

  
  

}
