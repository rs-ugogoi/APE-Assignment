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
public class EmployeeRegistrationController {

	@Autowired
	EmployeeDataRepository employeeDataRepository;
	
	HttpSession session;
	
//	@PostMapping("employeeSignUp")
//	public String signUpDetails(@ModelAttribute EmployeeDataPojo employeeDetails, HttpServletResponse response,HttpServletRequest request)
//	{
//		session=request.getSession();
//		session.setAttribute("empId",request.getParameter("empId"));
//		session.setAttribute("message","");
//		employeeDataRepository.save(employeeDetails);
//		return "passwordConfig";
//	}
	
	@PostMapping("setPassword")
	public String setEmployeePassword(@ModelAttribute EmployeeDataPojo employeeData, HttpServletResponse response,HttpServletRequest request)
	{
		String empId=(String)session.getAttribute("empId");
		session=request.getSession();
		if(request.getParameter("password").equals(request.getParameter("reEnterPassword")))
		{
			employeeDataRepository.setPassword(request.getParameter("password"),empId);
			session.invalidate();
			return "redirect:/landingPage";
		}
		else
		{
			session.setAttribute("message","Incorrect Password");
			return "passwordConfig";
		}
	}
	
	@GetMapping("logout")
	public String logoutEmployee()
	{
		return "logout";
	}
	
}
