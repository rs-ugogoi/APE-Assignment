package com.EmployeeDataManagement.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.EmployeeDataManagement.Repository.EmployeeDataRepository;

@Controller
public class EmployeeLoginController {

	@Autowired
	EmployeeDataRepository employeeDataRepository;
	
	BCryptPasswordEncoder passwordEncode= new BCryptPasswordEncoder();
	//need to remove
//	@PostMapping("/employeeLogin")
//	public void employeeLogin(HttpServletRequest request, HttpServletResponse response) throws IOException
//	{
//
//		
//		EmployeeDataPojo findEmp=employeeDataRepository.findEmp(request.getParameter("username"));
//		
//		
//		if( findEmp!= null && passwordEncode.matches(request.getParameter("password"), findEmp.getPassword()))
//		{
//			HttpSession session=request.getSession();
//			session.setAttribute("name",findEmp.getName());
//			response.sendRedirect("employeeHome");
//		}
//		else
//		{
//			HttpSession session=request.getSession();
//			session.setAttribute("loginMessage","Invalid Email id or password");
//			response.sendRedirect("loginPage");
//		}
//	}
	
	
	@GetMapping("logoutPage")
	public String logoutEmployee()
	{
		return "logoutPage";
	}
	
}
