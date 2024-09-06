package com.projects.quickcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.projects.quickcart.service.BuyerService;

@Controller
public class ProductController {
	@Autowired
	private BuyerService bService;

	@GetMapping("/products")
	public ModelAndView productsView() {
		ModelAndView mView = new ModelAndView("products");
		mView.addObject("producs", bService.getProducts());
		return mView;

	}

	@GetMapping("/{productId}")
	public ModelAndView getProductsView(@PathVariable("productId") int productId) {
		ModelAndView mView = new ModelAndView("products");
		mView.addObject("products", bService.getProduct());

		return mView;

	}

	@GetMapping("/{category}")
	public ModelAndView findProductView(@PathVariable("category") String category) {
		ModelAndView mView = new ModelAndView("products");
		mView.addObject("products", bService.findProductByCategory());
		return mView;

	}
}
