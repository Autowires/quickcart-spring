package com.projects.quickcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RetailerController {

	@GetMapping(value = "/retailer")
	public ModelAndView homeView() {
		return new ModelAndView("retailer/index");
	}

}
