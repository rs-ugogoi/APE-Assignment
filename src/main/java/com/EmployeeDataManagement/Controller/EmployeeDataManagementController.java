package com.EmployeeDataManagement.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.EmployeeDataManagement.Service.AuthnService;

@RestController
@RequestMapping("/")
public class EmployeeDataManagementController {
	
	private ModelAndView modelView=new ModelAndView();

	@Autowired
	private AuthnService authnService;
	
	@GetMapping({"/","/landingPage"})
	public ModelAndView landingPage()
	{
		modelView.setViewName("landingPage");
		return modelView;
	}
	
	@GetMapping("loginPage")
	public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response)
	{
		modelView.setViewName("loginPage");
		return modelView;
	}
	
	@GetMapping("logoutPage")
	public ModelAndView logoutPage()
	{
		modelView.setViewName("logoutPage");
		return modelView;
	}
		
	@GetMapping("signup")
	public ModelAndView signUpPage()
	{
		modelView.setViewName("signup");
		return modelView;
	}
	
	@GetMapping("profile")
	public ModelAndView Profile(HttpServletRequest request)
	{
		return authnService.ViewProfile(request);
	}
		
	
	@GetMapping("error")
	public String error()
	{
		return "home";
	}
	
	
	@GetMapping("update")
	public ModelAndView update()
	{
		modelView.setViewName("update");
		return modelView;
	}
	

	@GetMapping("adminUpdate")
	public ModelAndView adminUpdate()
	{
		modelView.setViewName("adminUpdate");
		return modelView;
	}
	
	
	@GetMapping("deleteEmployee")
	public ModelAndView deleteEmployee(HttpServletRequest request,HttpServletResponse response)
	{
		modelView.setViewName("delete");
		return modelView;
	}

}
