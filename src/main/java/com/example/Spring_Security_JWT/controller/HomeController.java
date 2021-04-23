package com.example.Spring_Security_JWT.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	public static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/home")
	public String welcomePage() {
		log.info("homepage");
		return "<h1> Welcome to Home Page <h1>";
	}
	
	@RequestMapping(value = "/test")
	public String testPage() {
		log.info("testpage");
		return "<h1> Welcome to test Page <h1>";
	}
	
	@RequestMapping(value = "/homeAdmin")
	public String adminPage() {
		log.info("Admin homepage");
		return "<h1> Welcome to Admin Home Page <h1>";
	}
	
	@RequestMapping(value = "/homeUser")
	public String userPage() {
		log.info("User homepage");
		return "<h1> Welcome to User Home Page <h1>";
	}
}
