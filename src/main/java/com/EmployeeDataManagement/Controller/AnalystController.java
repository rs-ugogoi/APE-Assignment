package com.EmployeeDataManagement.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.EmployeeDataManagement.Repository.EmployeeDataRepository;
import com.EmployeeDataManagement.pojo.EmployeeDataPojo;

@RestController
public class AnalystController {

	
	@Autowired
	private EmployeeDataRepository employeeDataRepository; 
	
	private EmployeeDataPojo empDetails;
	
	private ModelAndView modelView=new ModelAndView();
	
	@GetMapping("analystHome")
	public ModelAndView analystHome(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("name");
		empDetails=employeeDataRepository.findEmp(email);
		
		session.setAttribute("empDetails",empDetails);
		modelView.setViewName("analystHome");
		return modelView;
	}
}
