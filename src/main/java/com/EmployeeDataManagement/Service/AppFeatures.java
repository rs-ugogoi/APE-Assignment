package com.EmployeeDataManagement.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.EmployeeDataManagement.Repository.EmployeeDataRepository;
import com.EmployeeDataManagement.pojo.EmployeeDataPojo;

@Service
public class AppFeatures {

	@Autowired
	private EmployeeDataRepository employeeDataRepository; 

	private ModelAndView modelView=new ModelAndView();
	
	private EmployeeDataPojo empDetails;
	
	private	HttpSession session;
	
	public ModelAndView UpdateDetails(EmployeeDataPojo employeeDetails,HttpServletRequest request) throws IOException
	{
		employeeDataRepository.updateEmployeeDetails(employeeDetails.getEmail(),employeeDetails.getName(),employeeDetails.getSurname(),employeeDetails.getpNumber(),employeeDetails.getEmpId());
		return Profile(request);
	}
	
	public ModelAndView Profile(HttpServletRequest request)
	{
		session=request.getSession();
		empDetails=employeeDataRepository.findEmp((String)session.getAttribute("name"));
		session.setAttribute("empDetails",empDetails);
		if(empDetails.getRole().equals("ROLE_USER"))
			modelView.setViewName("employeeHome");
		else if(empDetails.getRole().equals("ROLE_ANALYST"))
			modelView.setViewName("analystHome");

		return modelView;
	}
	
	public ModelAndView DeleteEmployee(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		empDetails=(EmployeeDataPojo) session.getAttribute("empDetails");
		employeeDataRepository.deleteById(empDetails.getEmpId());
		modelView.setViewName("landingPage");
		return modelView;
	}
	
	public ModelAndView EmployeeList(HttpServletRequest request)
	{
		List<EmployeeDataPojo> employeeList=new ArrayList<EmployeeDataPojo>();
		employeeList=employeeDataRepository.findAll(); 
		session= request.getSession();
		session.setAttribute("employee",employeeList);
		modelView.setViewName("employeeList");
		return modelView;
	}
	
	public ModelAndView Select(EmployeeDataPojo employeeData,HttpServletRequest request)
	{
		empDetails=employeeDataRepository.findEmp(employeeData.getEmpId());
		session=request.getSession();
		if(empDetails!=null)
		{
			session.setAttribute("empDetails",empDetails);
			modelView.setViewName("adminUpdate");
		}
		else
			modelView.setViewName("adminUpdate");
		return modelView;
	}
	
	public ModelAndView UpdateType(HttpServletRequest request)
	{
		session=request.getSession();
		empDetails=(EmployeeDataPojo)session.getAttribute("empDetails");
		employeeDataRepository.employeeType(request.getParameter("role"),empDetails.getEmail()); ;
		modelView.setViewName("adminUpdate");
		return modelView;
	}
	
	public ModelAndView Remove(HttpServletRequest request)
	{
		if(request.getParameter("empId")!=null)
			empDetails=employeeDataRepository.findEmp(Integer.parseInt(request.getParameter("empId")));
		
		if(empDetails!=null)
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
