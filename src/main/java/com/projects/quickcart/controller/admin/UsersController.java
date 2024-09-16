package com.projects.quickcart.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projects.quickcart.service.UserService;

@Controller
@RequestMapping("/admin/users")
public class UsersController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ModelAndView getUserAndView() {
		ModelAndView mView = new ModelAndView("admin/users");
		mView.addObject("users", userService.getAllUsers());
		return mView;
	}

}
