package com.EmployeeDataManagement.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.EmployeeDataManagement.Repository.EmployeeDataRepository;
import com.EmployeeDataManagement.pojo.EmployeeDataPojo;

@RestController
public class AdminController {
	

	@Autowired
	private EmployeeDataRepository employeeDataRepository; 
	
	private EmployeeDataPojo findEmp;
	
	private HttpSession session;

	private ModelAndView modelView=new ModelAndView();
	
	@GetMapping("adminHome")
	public ModelAndView adminHome()
	{
//		session=request.getSession();
//		String email=(String)session.getAttribute("name");
//		session.setAttribute("email", email);
//		findEmp=employeeDataRepository.findEmp(email);
//		session.setAttribute("name",findEmp.getName());
		modelView.setViewName("adminHome");
		return modelView;
	}
	
	@GetMapping("employeeList")
	public ModelAndView employeeList(HttpServletRequest request,HttpServletResponse response)
	{
		List<EmployeeDataPojo> employeeList=new ArrayList<EmployeeDataPojo>();
		
		employeeList=employeeDataRepository.findAll(); 
		
		HttpSession session= request.getSession();
		session.setAttribute("employee",employeeList);
		modelView.setViewName("employeeList");
		return modelView;
	}
	
	//need to be removed
	//tried removing but not working
	@GetMapping("adminUpdate")
	public ModelAndView adminUpdate()
	{
		modelView.setViewName("adminUpdate");
		return modelView;
	}
	
	@PostMapping("selectEmployee")
	public ModelAndView selectEmployee(@ModelAttribute EmployeeDataPojo employeeData, HttpServletRequest request,HttpServletResponse response)
	{
//		System.out.println(request.getParameter("empId"));
//		System.out.println(employeeData.getEmpId());
		findEmp=employeeDataRepository.findEmp(employeeData.getEmpId());
		session=request.getSession();
		if(findEmp!=null)
		{
			session.setAttribute("empDetails",findEmp);
			modelView.setViewName("adminUpdate");
		}
		else
		{
			modelView.setViewName("adminUpdate");
		}
		
		return modelView;
	}
	
	
	@PostMapping("employeeType")
	public ModelAndView employeeType(HttpServletRequest request,HttpServletResponse response)
	{
		session=request.getSession();
		findEmp=(EmployeeDataPojo)session.getAttribute("empDetails");
		employeeDataRepository.employeeType(request.getParameter("role"),findEmp.getEmail()); ;
		modelView.setViewName("adminUpdate");
		return modelView;

	}
	
	@GetMapping("deleteEmployee")
	public ModelAndView deleteEmployee(HttpServletRequest request,HttpServletResponse response)
	{
		modelView.setViewName("delete");
		return modelView;
	}
	
	@PostMapping("removeEmployee")
	public ModelAndView removeEmployee(HttpServletRequest request,HttpServletResponse response)
	{
		if(request.getParameter("empId")!=null)
			findEmp=employeeDataRepository.findEmp(Integer.parseInt(request.getParameter("empId")));
		if(findEmp!=null)
			employeeDataRepository.deleteById(Integer.parseInt(request.getParameter("empId")));
		else
		{
			modelView.setViewName("delete");
			return modelView;
		}
		modelView.setViewName("adminHome");
		return modelView;
	}
}
