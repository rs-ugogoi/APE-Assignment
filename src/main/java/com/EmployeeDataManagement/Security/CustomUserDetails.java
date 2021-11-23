package com.EmployeeDataManagement.Security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.EmployeeDataManagement.pojo.EmployeeDataPojo;

public class CustomUserDetails implements UserDetails {

	EmployeeDataPojo employeeDataPojo;
	
	
	
	public CustomUserDetails(EmployeeDataPojo employeeDataPojo) {
		super();
		this.employeeDataPojo = employeeDataPojo;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(employeeDataPojo.getRole());
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		
		return employeeDataPojo.getPassword();
	}

	@Override
	public String getUsername() {
		
		return employeeDataPojo.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	

}
