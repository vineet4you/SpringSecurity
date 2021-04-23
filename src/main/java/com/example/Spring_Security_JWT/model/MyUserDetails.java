package com.example.Spring_Security_JWT.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{

	private String userName;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorirties;
	
	public MyUserDetails(User user) {
		userName = user.getUserName();
		password = user.getPassword();
		active = user.isActive();
		authorirties = Arrays.stream(user.getRoles().split(","))
						.map(SimpleGrantedAuthority::new)
						.collect(Collectors.toList());
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorirties;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return userName;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return active;
	}

}
