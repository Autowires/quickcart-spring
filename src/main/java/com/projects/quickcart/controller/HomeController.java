package com.projects.quickcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projects.quickcart.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/login")
	public String loginView() {
		return "login";
	}

	@PostMapping("/login")
	public String loginView(@RequestParam String username,
			@RequestParam String password, Model model, HttpSession session) {
		var user = userService.getUser(username, password);
		if (user.isEmpty()) {
			model.addAttribute("errorMessage", "Incorrect credentials");
			return "login";
		}
		var u = user.get();
		session.setAttribute("userId", u.getId());
		session.setAttribute("username", u.getUsername());
		session.setAttribute("status", u.getStatus());
		session.setAttribute("role", u.getRole());

		return switch (u.getRole()) {
			case "CUSTOMER" -> "redirect:/products";
			case "RETAILER" -> "redirect:/retailer";
			default -> {
				session.invalidate();
				System.out.println("Unknown user role " + u.getRole());
				yield "redirect:/";
			}
		};
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
