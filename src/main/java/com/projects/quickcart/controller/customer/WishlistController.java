package com.projects.quickcart.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projects.quickcart.service.CustomerService;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

	@Autowired
	private CustomerService service;

	@GetMapping
	public ModelAndView wishlistView() {
		var mv = new ModelAndView("customer/wishlist");
		long userId = 1; // TODO: get userId from session
		// TODO: handle situation where user not customer
		mv.addObject("products", service.getItems(userId));
		return mv;
	}

	@PostMapping
	public ModelAndView addProduct(@RequestParam long productId, @RequestHeader String referer) {
		var mv = new ModelAndView("redirect:" + referer);
		long userId = 1; // TODO: get userId from session
		// TODO: handle situation where user not customer
		service.addWishlistItem(userId, productId);
		return mv;
	}

	@DeleteMapping
	public ModelAndView deleteProduct(@RequestParam long productId, @RequestHeader String referer) {
		var mv = new ModelAndView("redirect:" + referer);
		long userId = 1; // TODO: get userId from session
		// TODO: handle situation where user not customer
		service.removeWishlistItem(userId, productId);
		return mv;
	}
}
