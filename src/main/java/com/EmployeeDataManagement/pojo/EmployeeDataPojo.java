package com.EmployeeDataManagement.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeDataPojo {

	@Id
	int empId;
	
	String name;
	String surname;
	long pNumber;
	String email;
	
	
	
	public EmployeeDataPojo() {
		super();
	}
	
	
	
	public EmployeeDataPojo(int empId, String name, String surname, long pNumber, String email) {
		super();
		this.empId = empId;
		this.name = name;
		this.surname = surname;
		this.pNumber = pNumber;
		this.email = email;
	}



	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public long getpNumber() {
		return pNumber;
	}
	public void setpNumber(long pNumber) {
		this.pNumber = pNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
