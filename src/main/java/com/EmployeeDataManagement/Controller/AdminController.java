package com.EmployeeDataManagement.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.EmployeeDataManagement.Service.AppFeatures;
import com.EmployeeDataManagement.pojo.EmployeeDataPojo;

@RestController
public class AdminController {
		
	@Autowired
	private AppFeatures appFeatures;
	

	private ModelAndView modelView=new ModelAndView();
	
	@GetMapping("adminHome")
	public ModelAndView adminHome()
	{
		modelView.setViewName("adminHome");
		return modelView;
	}
	
	@GetMapping("employeeList")
	public ModelAndView employeeList(HttpServletRequest request,HttpServletResponse response)
	{
		return appFeatures.EmployeeList(request);
	}
	
	
	@PostMapping("selectEmployee")
	public ModelAndView selectEmployee(@ModelAttribute EmployeeDataPojo employeeDetails, HttpServletRequest request,HttpServletResponse response)
	{
		return appFeatures.Select(employeeDetails, request);
	}
	
	
	@PostMapping("employeeType")
	public ModelAndView employeeType(HttpServletRequest request,HttpServletResponse response)
	{
		return appFeatures.UpdateType(request);
	}
	
	
	@PostMapping("removeEmployee")
	public ModelAndView removeEmployee(HttpServletRequest request,HttpServletResponse response)
	{
		return appFeatures.Remove(request);
	}
}
