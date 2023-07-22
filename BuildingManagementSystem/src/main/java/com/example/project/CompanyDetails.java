package com.example.project;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Company")
public class CompanyDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Company_name")
	private String name;
	@Column(name = "Phn_No")
	private String phnNo;
	@Column(name = "Email_Id")
	private String emailId;
	@Column(name= "Rent")
	private int rent;
	
	public CompanyDetails() {
		
	}
	
	public CompanyDetails(String name,String phnNo,String emailId,int rent) {
		this.name=name;
		this.phnNo=phnNo;
		this.emailId=emailId;
		this.rent=rent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhnNo() {
		return phnNo;
	}

	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}
	
}
