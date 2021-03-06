package com.EmployeeDataManagement.Security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		String redirectUrl = null;
		HttpSession session=request.getSession();
		
		session.setAttribute("name",(String)request.getParameter("username"));
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		
//		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		authorities=(Collection<GrantedAuthority>) authentication.getAuthorities();
		
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ROLE_ANALYST")) {
				session.setAttribute("role",grantedAuthority.getAuthority());
				redirectUrl = "/analystHome";
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
				session.setAttribute("role",grantedAuthority.getAuthority());
				redirectUrl = "/employeeHome";
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
				session.setAttribute("role",grantedAuthority.getAuthority());
				redirectUrl = "/adminHome";
				break;
			}
		}
		if (redirectUrl == null) {
			throw new IllegalStateException();
		}
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}

	
}
