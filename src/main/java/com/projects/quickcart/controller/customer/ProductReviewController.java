package com.projects.quickcart.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.projects.quickcart.dto.CurrentUser;
import com.projects.quickcart.entity.ProductReview;
import com.projects.quickcart.service.ProductReviewService;

@Controller
@RequestMapping("/reviews")
public class ProductReviewController {

	@Autowired
	private ProductReviewService productReviewService;

	@GetMapping
	public ModelAndView listReviewsByproduct(@SessionAttribute CurrentUser user) {
		List<ProductReview> reviews = productReviewService.getReviewsByCustomerId(user.getUserId());
		ModelAndView mView = new ModelAndView("reviews");
		mView.addObject("reviews", reviews);
		return mView;
	}

	@PostMapping
	public ModelAndView showNewReviewForm(@SessionAttribute CurrentUser user, @RequestParam long productId,
			@RequestParam String reviewContent, @RequestParam int rating, @RequestHeader String referer) {
		ModelAndView mView = new ModelAndView("redirect:" + referer);
		productReviewService.saveProductReview(user.getUserId(), productId, reviewContent, rating);
		return mView;
	}

	@PostMapping("/save")
	public ModelAndView saveReview(@ModelAttribute("productReview") ProductReview productReview,
			@RequestParam("productId") long productId) {
		productReviewService.saveProductReview(productReview);
		return new ModelAndView("redirect:/reviews/product/" + productId);
	}

	@GetMapping("/edit/{id}")
	public ModelAndView showEditReviewForm(@PathVariable("id") long id) {
		ProductReview productReview = productReviewService.getProductReviewById(id);
		ModelAndView modelAndView = new ModelAndView("reviews");
		modelAndView.addObject("productReview", productReview);
		modelAndView.addObject("mode", "edit"); // Indicates we are in edit mode
		return modelAndView;
	}

	@PostMapping("/update")
	public ModelAndView updateReview(@ModelAttribute("productReview") ProductReview productReview,
			@RequestParam("productId") long productId) {
		productReviewService.updateProductReview(productReview);
		return new ModelAndView("redirect:/reviews/product/" + productId);
	}

	@GetMapping("/delete/{id}")
	public ModelAndView deleteReview(@PathVariable("id") long id, @RequestParam("productId") long productId) {
		productReviewService.deleteProductReview(id);
		return new ModelAndView("redirect:/reviews/product/" + productId);
	}

}
