package com.EmployeeDataManagement.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.EmployeeDataManagement.Repository.EmployeeDataRepository;
import com.EmployeeDataManagement.pojo.EmployeeDataPojo;

@Controller
public class EmployeeLoginController {

	@Autowired
	EmployeeDataRepository employeeDataRepository;
	
	@PostMapping("employeeLogin")
	public void employeeLogin(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		EmployeeDataPojo employeeLoginDetails= employeeDataRepository.login(email, password);
		System.out.println(employeeLoginDetails);
//		System.out.println(employeeDataRepository.login(email, password));
//		System.out.println(employeeLoginDetails.getName());
		
		if(employeeLoginDetails != null )
		{
			System.out.println(employeeLoginDetails);
			HttpSession session=request.getSession();
			String name=employeeLoginDetails.getName();
			session.setAttribute("name",name);
			response.sendRedirect("profile");
		}
		else
		{
			HttpSession session=request.getSession();
			session.setAttribute("loginMessage","Invalid Email id or password");
//			String message="Invalid Email id or password";
//			Cookie ck=new Cookie("loginMessage",message);
//			response.addCookie(ck);
			response.sendRedirect("loginPage");
		}
	}
	
}
