package com.EmployeeDataManagement.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.EmployeeDataManagement.Repository.EmployeeDataRepository;
import com.EmployeeDataManagement.pojo.EmployeeDataPojo;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	EmployeeDataRepository employeeDataRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		EmployeeDataPojo employeeDataPojo= employeeDataRepo.findEmp(username);
		
		CustomUserDetails customUserDetails= new CustomUserDetails(employeeDataPojo);
		return customUserDetails;
	}

}
