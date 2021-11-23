package com.EmployeeDataManagement.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
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
//	     	.antMatchers(HttpMethod.POST,"/employeeLogin").hasRole("ADMIN")
//	     	.antMatchers(HttpMethod.POST,"setPassword").permitAll()
	     	.antMatchers("/adminHome").hasRole("ADMIN")
	     	.antMatchers("/analystHome").hasRole("ANALYST")
	     	.antMatchers("/employeeHome").hasRole("USER")
	     	.antMatchers("/**").permitAll()
	     	.anyRequest()
	     	.authenticated()
	     	.and()
	     	.formLogin().loginPage("/loginPage");
	    }
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder(10);
	}
	
	@Bean
	public UserDetailsService getUserDetailService()
	{
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(this.getUserDetailService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.authenticationProvider(authenticationProvider());
	}
	
}
