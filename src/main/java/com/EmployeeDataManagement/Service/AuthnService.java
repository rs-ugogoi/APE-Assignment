package com.EmployeeDataManagement.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.EmployeeDataManagement.Repository.EmployeeDataRepository;
import com.EmployeeDataManagement.pojo.EmployeeDataPojo;

@Service
public class AuthnService {

	private ModelAndView modelView=new ModelAndView();

	private HttpSession session;

	@Autowired
	private EmployeeDataRepository employeeDataRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public ModelAndView SignUp(EmployeeDataPojo employeeDetails,HttpServletRequest request)
	{
		session=request.getSession();
		if((employeeDetails.getEmail()!=null) 
				&& 
			(employeeDataRepository.findEmp(employeeDetails.getEmail())==null) 
				&&
			(employeeDataRepository.findEmp(employeeDetails.getEmpId())==null))
		{
			session.setAttribute("empId",employeeDetails.getEmpId());
			this.employeeDataRepository.save(employeeDetails);
			modelView.setViewName("passwordConfig");
		}
		else
			modelView.setViewName("signup");
			
		return modelView;
	}
	
	
	public ModelAndView SetPassword(EmployeeDataPojo employeeDetails,HttpServletRequest request)
	{
		if(request.getParameter("password").equals(request.getParameter("reEnterPassword")))
		{
			employeeDataRepository.setPassword
			(bCryptPasswordEncoder.encode(employeeDetails.getPassword()),
					(Integer)session.getAttribute("empId"));
			modelView.setViewName("landingPage");
		}
		else
			modelView.setViewName("passwordConfig");
		return modelView;
	}
	
	public ModelAndView ViewProfile(HttpServletRequest request)
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
		return modelView;
	}
	
}
