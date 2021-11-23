package com.EmployeeDataManagement.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.EmployeeDataManagement.Repository.EmployeeDataRepository;
import com.EmployeeDataManagement.pojo.EmployeeDataPojo;

@Controller
public class EmployeeRegistrationController {

	@Autowired
	EmployeeDataRepository employeeDataRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
		
	HttpSession session;
	
	@PostMapping("employeeSignUp")
	public String signUpDetails(@ModelAttribute EmployeeDataPojo employeeDetails, HttpServletResponse response,HttpServletRequest request)
	{
		session=request.getSession();
		session.setAttribute("message","");

		if(request.getParameter("email")!=null && employeeDataRepository.findEmp(request.getParameter("email"))==null)
		{
			
			session.setAttribute("empId",request.getParameter("empId"));
			session.setAttribute("message","");
			
			employeeDataRepository.save(employeeDetails);
			return "passwordConfig";
		
		}
		
		else
		{
			session=request.getSession();
			session.setAttribute("message","Email already registered");
			return "signup";
		}
	}
	
	@PostMapping("setPassword")
	public String setEmployeePassword(@ModelAttribute EmployeeDataPojo employeeData, HttpServletResponse response,HttpServletRequest request)
	{
		String empId=(String)session.getAttribute("empId");
		session=request.getSession();
		if(request.getParameter("password").equals(request.getParameter("reEnterPassword")))
		{
			String password=bCryptPasswordEncoder.encode(request.getParameter("password"));
			employeeDataRepository.setPassword(password,empId);
			session.invalidate();
			return "redirect:/landingPage";
		}
		else
		{
			session.setAttribute("message","Incorrect Password");
			return "passwordConfig";
		}
	}
	
}
