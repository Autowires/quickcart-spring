package com.projects.quickcart.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projects.quickcart.entity.ProductReview;
import com.projects.quickcart.service.ProductReviewService;

@Controller
@RequestMapping("/reviews")
public class ProductReviewController {

	@Autowired
	private ProductReviewService productReviewService;

	@GetMapping("/reviews")
	public ModelAndView listReviewsByproduct(@PathVariable("productId") long productId) {
		List<ProductReview> reviews = productReviewService.getReviewsByProductId(productId);
		ModelAndView mView = new ModelAndView("reviews");
		mView.addObject("reviews", reviews);
		mView.addObject("productId", productId);
		mView.addObject("productReview", new ProductReview());
		mView.addObject("mode", "list");
		return mView;
	}

	@GetMapping("/new")
	public ModelAndView showNewReviewForm(@RequestParam("productId") long productId) {
		ModelAndView mView = new ModelAndView();
		mView.addObject("productReview", new ProductReview());
		mView.addObject("productId", productId);
		mView.addObject("mode", "add");
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
