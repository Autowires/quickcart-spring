package com.projects.quickcart.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.projects.quickcart.dto.CurrentUser;
import com.projects.quickcart.service.CustomerService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public ModelAndView getCart(@SessionAttribute CurrentUser user) {
		ModelAndView mView = new ModelAndView("customer/cart");
		// TODO: you have share the cart items of user from service to model
		return mView;
	}

	@PostMapping
	public ModelAndView postCart(@SessionAttribute CurrentUser user, @RequestParam long productId) {
		ModelAndView mView = new ModelAndView("redirect:/cart");
		// TODO: add product to user cart
		return mView;
	}

	@PutMapping
	public ModelAndView updateCartQuanitity(@SessionAttribute CurrentUser user, @RequestParam long itemId,
			@RequestParam long quanitiy) {
		ModelAndView mView = new ModelAndView("redirect:/cart");
		// TODO: update the product quantity in cart
		return mView;
	}

	@DeleteMapping
	public ModelAndView deleteCartItem(@SessionAttribute CurrentUser user, @RequestParam long itemId,
			@RequestParam long cartItemId) {
		ModelAndView mView = new ModelAndView("redirect:/cart");
		// TODO: delete the item in cart
		return mView;
	}
}
