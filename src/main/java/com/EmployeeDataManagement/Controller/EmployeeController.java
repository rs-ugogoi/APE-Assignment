package com.EmployeeDataManagement.Controller;

import java.io.IOException;

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
public class EmployeeController {

	
	@Autowired
	private AppFeatures appFeatures;
	
	@GetMapping("employeeHome")
	public ModelAndView employeeHome(HttpServletRequest request, HttpServletResponse response)
	{
		return appFeatures.Profile(request);
	}
	
	@PostMapping("updateEmployeeDetails")
	public ModelAndView updateEmployeeDetails(@ModelAttribute EmployeeDataPojo employeeDetails,HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		return appFeatures.UpdateDetails(employeeDetails,request);
	}
	
	@GetMapping("delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		return appFeatures.DeleteEmployee(request);
	}
	

}
