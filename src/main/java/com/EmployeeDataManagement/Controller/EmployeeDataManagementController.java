package com.EmployeeDataManagement.Controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



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
		System.out.println("Test1");
		return "loginPage";
	}
	
//	@PostMapping("Test")
//	public String test()
//	{
//		System.out.println("Test2");
//		return "adminHome";
//	}
//	
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
	
	@GetMapping("adminHome")
	public String adminHome()
	{
		return "adminHome";
	}
	
	@GetMapping("analystHome")
	public String analystHome()
	{
		System.out.println("Test2");
		return "analystHome";
	}
	
	@GetMapping("employeeHome")
	public String employeeHome()
	{
		System.out.println("Test2");
		return "employeeHome";
	}
}
