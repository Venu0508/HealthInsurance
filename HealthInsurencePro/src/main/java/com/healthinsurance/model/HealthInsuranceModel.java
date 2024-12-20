package com.healthinsurance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class HealthInsuranceModel 
{
	private String fullName;
	  private String gender;
	  private String mobileNo;
	  private String emailId;
	  private String customerId;

	  
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
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
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public HealthInsuranceModel(String fullName, String gender, String mobileNo, String emailId, String customerId,
			long id) {
		this.fullName = fullName;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.customerId = customerId;
		this.id = id;

	
	}
	public HealthInsuranceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	

  
  

}
