package com.EmployeeDataManagement.Controller;

import java.io.IOException;

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
public class EmployeeController {

	@Autowired
	EmployeeDataRepository employeeDataRepository; 
	
	EmployeeDataPojo empDetails;
	
	@GetMapping("employeeHome")
	public String employeeHome(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("name");
		empDetails=employeeDataRepository.findEmp(email);
		
		session.setAttribute("employee",empDetails);
		return "employeeHome";
	}
	
	@PostMapping("updateEmployeeDetails")
	public void updateEmployeeDetails(@ModelAttribute EmployeeDataPojo employeeDetails,HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		
		employeeDataRepository.updateEmployeeDetails((String)request.getParameter("email"),(String)request.getParameter("name"),(String)request.getParameter("surname"),(String)request.getParameter("pNumber"),(String)request.getParameter("empId"));
		response.sendRedirect("employeeHome");
	}
	
	@GetMapping("delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		HttpSession session=request.getSession();
		empDetails=(EmployeeDataPojo) session.getAttribute("employee");
		employeeDataRepository.deleteById(empDetails.getEmpId());
		
		response.sendRedirect("landingPage");
	}
	
	@GetMapping("password")
	public  void password(HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println(request.getParameter("pas"));
	}
}
