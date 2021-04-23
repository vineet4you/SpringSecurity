package com.example.Spring_Security_JWT.repo;

import com.example.Spring_Security_JWT.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	Optional<User> findByUserName(String userName);

}
