package com.EmployeeDataManagement.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.EmployeeDataManagement.Repository.EmployeeDataRepository;
import com.EmployeeDataManagement.pojo.EmployeeDataPojo;

//@Controller
@RestController
public class EmployeeRegistrationController {

	@Autowired
	private EmployeeDataRepository employeeDataRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
		
	private ModelAndView modelView=new ModelAndView();
	
	private HttpSession session;
	
	@PostMapping("employeeSignUp")
	public ModelAndView signUpDetails(@ModelAttribute EmployeeDataPojo employeeDetails, HttpServletResponse response,HttpServletRequest request)
	{
		session=request.getSession();
		session.setAttribute("message","");
		System.out.println(employeeDetails.getName());

		if(request.getParameter("email")!=null && employeeDataRepository.findEmp(request.getParameter("email"))==null)
		{
			
			session.setAttribute("empId",request.getParameter("empId"));
			session.setAttribute("message","");
			
			employeeDataRepository.save(employeeDetails);
			modelView.setViewName("passwordConfig") ;
		
		}
		
		else
		{
			session=request.getSession();
			session.setAttribute("message","Email already registered");
			modelView.setViewName("signup") ;
		}
		
		return modelView;
		
	}
	
	@PostMapping("setPassword")
	public ModelAndView setEmployeePassword(@ModelAttribute EmployeeDataPojo employeeData, HttpServletResponse response,HttpServletRequest request)
	{
		String empId=(String)session.getAttribute("empId");
		session=request.getSession();
		if(request.getParameter("password").equals(request.getParameter("reEnterPassword")))
		{
			String password=bCryptPasswordEncoder.encode(request.getParameter("password"));
			employeeDataRepository.setPassword(password,empId);
			modelView.setViewName("landingPage");
		}
		else
		{
			modelView.setViewName("passwordConfig");
		}
		
		return modelView;
	}
	
}
