package com.EmployeeDataManagement.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.EmployeeDataManagement.Service.AppFeatures;

@RestController
public class AnalystController {
	
	@Autowired
	private AppFeatures appFeatures;
	
	@GetMapping("analystHome")
	public ModelAndView analystHome(HttpServletRequest request, HttpServletResponse response)
	{
		return appFeatures.Profile(request);
	}
	
	
	
}
