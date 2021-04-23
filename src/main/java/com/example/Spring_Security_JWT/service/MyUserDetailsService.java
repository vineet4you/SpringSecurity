package com.example.Spring_Security_JWT.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Spring_Security_JWT.model.MyUserDetails;
import com.example.Spring_Security_JWT.model.User;
import com.example.Spring_Security_JWT.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<User> userDetails = repo.findByUserName(userName);
		
		userDetails.orElseThrow(() -> new UsernameNotFoundException("UserName:" + userName));
		
		return userDetails.map(MyUserDetails::new).get();
		
	}

}
