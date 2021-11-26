package com.EmployeeDataManagement.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.EmployeeDataManagement.Repository.EmployeeDataRepository;
import com.EmployeeDataManagement.pojo.EmployeeDataPojo;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeDataRepository employeeDataRepository; 	
	
	@GetMapping("employeeHome")
	public String employeeHome(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("name");
		EmployeeDataPojo findEmp=employeeDataRepository.findEmp(email);
		
		session.setAttribute("employee",findEmp);
		return "employeeHome";
	}
}
