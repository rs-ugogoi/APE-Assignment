package com.EmployeeDataManagement.Controller;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;






@RestController
@RequestMapping("/")
public class EmployeeDataManagementController {
	
	private ModelAndView modelView=new ModelAndView();

	@GetMapping({"/","/landingPage"})
	public ModelAndView landingPage()
	{
		modelView.setViewName("landingPage");
		return modelView;
	}
	
	@GetMapping("loginPage")
	public ModelAndView loginPage()
	{
		modelView.setViewName("loginPage");
		return modelView;
	}
	
//	@GetMapping("logoutPage")
//	public String logoutPage()
//	{
//		return "logoutPage";
//	}
		
	@GetMapping("signup")
	public ModelAndView signUpPage()
	{
		modelView.setViewName("signup");
		return modelView;
	}
	
	@GetMapping("profile")
	public ModelAndView profile(HttpServletResponse response,HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute("email");
		session.setAttribute("name",email); 
		
		if(session.getAttribute("role")!=null && session.getAttribute("role").equals("ROLE_USER"))
			modelView.setViewName("employeeHome");
		else if(session.getAttribute("role")!=null && session.getAttribute("role").equals("ROLE_ANALYST"))
			modelView.setViewName("analystHome");
		else if(session.getAttribute("role")!=null &&session.getAttribute("role").equals("ROLE_ADMIN"))
			modelView.setViewName("adminHome");
		return modelView ;
	}
		
	
	@GetMapping("error")
	public String error()
	{
		return "home";
	}
	
	
	@GetMapping("update")
	public String update()
	{
		modelView.setViewName("update");
		return "update";
	}
	

	

}
