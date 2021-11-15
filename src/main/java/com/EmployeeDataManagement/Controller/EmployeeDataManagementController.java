package com.EmployeeDataManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.EmployeeDataManagement.Repository.EmployeeDataRepository;
import com.EmployeeDataManagement.pojo.EmployeeDataPojo;

@Controller
public class EmployeeDataManagementController {
	
	@Autowired
	EmployeeDataRepository employeeDataRepository;

	@GetMapping("/")
	public String landingPage()
	{
		return "landingPage";
	}
	
	@GetMapping("login")
	public String loginPage()
	{
		return "login";
	}
	
	@GetMapping("signup")
	public String signUpPage()
	{
		return "signup";
	}
	
	@PostMapping("employeeSignUp")
	public String signUpDetails(@ModelAttribute EmployeeDataPojo employeeDetails)
	{
		employeeDataRepository.save(employeeDetails);
		System.out.println(employeeDetails.getpNumber()) ;
		return "landingPage";
	}
	
}
