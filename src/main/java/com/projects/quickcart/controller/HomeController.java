package com.projects.quickcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/login")
	public String loginView() {
		return "login";
	}

	@GetMapping("/register")
	public String registrationView() {
		return "register";
	}

	@GetMapping("/retailer-register")
	public String retailerRegistrationView() {
		return "register-retailer";
	}

}
