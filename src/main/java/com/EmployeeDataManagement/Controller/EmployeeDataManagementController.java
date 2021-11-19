package com.EmployeeDataManagement.Controller;



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
	public String profile()
	{
		return "home";
	}
	
}
