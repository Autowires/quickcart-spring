package com.projects.quickcart.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	@GetMapping("/products")
	public ModelAndView productsView() {
		ModelAndView mView = new ModelAndView("products");
		mView.addObject("producs", List.of());
		return mView;
	}

}
