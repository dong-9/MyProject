package com.jdh.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailsService userDetailsServcie;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String email = (String)authentication.getName();
		String password = (String)authentication.getCredentials();
		
		CustomUserDetails userDetails = (CustomUserDetails)userDetailsServcie.loadUserByUsername(email);
		
		if(userDetails == null || !email.equals(userDetails.getUsername()) 
				|| !passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException(email);
		}else if (!userDetails.isEnabled()) {
			throw new DisabledException(email);
		}

		userDetails.setPassword(null);
		
		Authentication newAuth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	
		return newAuth;
		
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
