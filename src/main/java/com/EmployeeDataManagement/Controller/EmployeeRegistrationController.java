package com.EmployeeDataManagement.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.EmployeeDataManagement.Service.AuthnService;
import com.EmployeeDataManagement.pojo.EmployeeDataPojo;

@RestController
public class EmployeeRegistrationController {
	
	@Autowired
	AuthnService authnService;
		
	
	@PostMapping("employeeSignUp")
	public ModelAndView signUpDetails(@ModelAttribute EmployeeDataPojo employeeDetails, HttpServletResponse response,HttpServletRequest request)
	{
		return authnService.SignUp(employeeDetails,request);
	}
	
	@PostMapping("setPassword")
	public ModelAndView setEmployeePassword(@ModelAttribute EmployeeDataPojo employeeDetails, HttpServletResponse response,HttpServletRequest request)
	{		
		return authnService.SetPassword(employeeDetails,request);
	}
	
}
