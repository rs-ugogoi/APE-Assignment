package com.EmployeeDataManagement.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.EmployeeDataManagement.Repository.EmployeeDataRepository;
import com.EmployeeDataManagement.pojo.EmployeeDataPojo;

@Controller
public class AdminController {
	

	@Autowired
	EmployeeDataRepository employeeDataRepository; 
	
	@GetMapping("adminHome")
	public String adminHome(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
//		EmployeeDataPojo findEmp=employeeDataRepository.findEmp(request.getParameter("username"));
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("name");
		EmployeeDataPojo findEmp=employeeDataRepository.findEmp(email);
//		HttpSession session=request.getSession();
		session.setAttribute("name",findEmp.getName());
		return "adminHome";
	}
	
	@GetMapping("employeeList")
	public String employeeList(HttpServletRequest request,HttpServletResponse response)
	{
		List<EmployeeDataPojo> employeeList=new ArrayList<EmployeeDataPojo>();
		
		employeeList=employeeDataRepository.findAll(); 
		
		HttpSession session= request.getSession();
		session.setAttribute("employee",employeeList);
		return "employeeList";
	}
}
