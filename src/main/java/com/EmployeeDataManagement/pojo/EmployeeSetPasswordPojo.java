package com.EmployeeDataManagement.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class EmployeeSetPasswordPojo {

	
	@Id
	int empId;
	
	@NonNull
	String password;
	
	@NonNull
	String reEnterPassword;

//	@OneToOne
//	EmployeeDataPojo employeeData;
	
	public EmployeeSetPasswordPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public EmployeeSetPasswordPojo(String password) {
		super();
		this.password = password;
	}


	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getReEnterPassword() {
		return reEnterPassword;
	}

	public void setReEnterPassword(String reEnterPassword) {
		this.reEnterPassword = reEnterPassword;
	}
	
	
}
