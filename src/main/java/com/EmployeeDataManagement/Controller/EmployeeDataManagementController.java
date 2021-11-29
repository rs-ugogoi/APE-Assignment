package com.EmployeeDataManagement.Controller;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;





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
	public String profile(HttpServletResponse response,HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		if(session.getAttribute("role")!=null && session.getAttribute("role").equals("ROLE_USER"))
			return "employeeHome";
		else if(session.getAttribute("role")!=null && session.getAttribute("role").equals("ROLE_ANALYST"))
			return "analystHome";
		else if(session.getAttribute("role")!=null &&session.getAttribute("role").equals("ROLE_ADMIN"))
			return "adminHome";
		return "loginPage" ;
	}
		
	@GetMapping("error")
	public String error()
	{
		return "home";
	}
	
	@GetMapping("update")
	public String update()
	{
		return "update";
	}
	
	@GetMapping("analystHome")
	public String analystHome()
	{
		return "analystHome";
	}
	

}
