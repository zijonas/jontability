package org.jonas.jontability.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;

@Resource
public class UserPasswordAuthenticator implements AuthenticationProvider {

	private final UserDetailsService userDetailsService;

	public UserPasswordAuthenticator(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		authentication.setAuthenticated(true);
		return authentication;
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return true;
	}
}
