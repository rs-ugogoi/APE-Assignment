package com.EmployeeDataManagement.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Override
	 protected void configure(HttpSecurity http ) throws Exception
	    {
	     http
	     	.csrf().disable()
	     	.authorizeRequests()
	     	.antMatchers("/**").permitAll()
	     	.antMatchers(HttpMethod.POST,"employeeLogin").permitAll()
	     	.antMatchers(HttpMethod.POST,"setPassword").permitAll()
	     	.anyRequest()
	     	.authenticated()
	     	.and()
	     	.httpBasic();
	    }
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder(10);
	}
	
}
