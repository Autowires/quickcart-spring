package com.projects.quickcart.service;

import java.util.List;

import com.projects.quickcart.entity.ProductReview;

public interface ProductReviewService {

	void saveProductReview(ProductReview productReview);

	ProductReview getProductReviewById(long id);

	List<ProductReview> getAllProductReviews();

	void updateProductReview(ProductReview productReview);

	void deleteProductReview(long id);

	List<ProductReview> getReviewsByProductId(long productId);

	List<ProductReview> getReviewsByCustomerId(long userId);

	void saveProductReview(long userId, long productId, String reviewContent, int rating);
}
