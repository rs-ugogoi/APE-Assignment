package com.EmployeeDataManagement.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.EmployeeDataManagement.Repository.EmployeeDataRepository;
import com.EmployeeDataManagement.pojo.EmployeeDataPojo;


@Controller
public class EmployeeDataManagementController {
	
	

	@GetMapping({"/","/landingPage"})
	public String landingPage()
	{
		return "landingPage";
	}
	
	@GetMapping("loginPage")
	public String loginPage()
	{
		return "loginPage";
	}
	
	@GetMapping("signup")
	public String signUpPage()
	{
		return "signup";
	}
	
	@GetMapping("profile")
	public String profile()
	{
		return "home";
	}
	
	@Autowired
	EmployeeDataRepository employeeDataRepository;
	
	HttpSession session;
	
	@PostMapping("employeeSignUp")
	public String signUpDetails(@ModelAttribute EmployeeDataPojo employeeDetails, HttpServletResponse response,HttpServletRequest request)
	{
		session=request.getSession();
		session.setAttribute("empId",request.getParameter("empId"));
		session.setAttribute("message","");
		employeeDataRepository.save(employeeDetails);
		return "passwordConfig";
	}
	
}
