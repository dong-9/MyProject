package com.jdh.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jdh.utils.MemberDAO;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberDAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomUserDetails userDetails = new CustomUserDetails();
		userDetails = dao.selectOneUser(username);
		
		if(userDetails == null) {
			throw new UsernameNotFoundException(username);
		}
		return userDetails;
	}
}